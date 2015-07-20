package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import com.food.pos.dto.ToOrderBillDTO;
import com.food.pos.dto.ToOrderFoodDTO;
import com.food.pos.dto.ToOrderFoodItemDTO;
import com.food.pos.service.ToOrderBillService;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.sun.star.uno.RuntimeException;

@ManagedBean
@ViewScoped
public class ToOrderBillBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToOrderBillDTO dto = new ToOrderBillDTO();

	@ManagedProperty(value = "#{toOrderBillService}")
	private transient ToOrderBillService service;

	@PostConstruct
	public void init() {
		this.dto = new ToOrderBillDTO();
		this.service.readData(dto);

	}

	public ToOrderBillDTO getDto() {
		return dto;
	}

	public void setDto(ToOrderBillDTO dto) {
		this.dto = dto;
	}

	public ToOrderBillService getService() {
		return service;
	}

	public void setService(ToOrderBillService service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toSend() {

		if (StringUtils.isBlank(dto.getOutOrIn())) {
			FacesMessage facesMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "請選擇內用或外帶", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}

//		
//		if (StringUtils.isBlank(dto.getName())) {
//			FacesMessage facesMsg = new FacesMessage(
//					FacesMessage.SEVERITY_ERROR, "請選擇商品", null);
//			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
//		}

		this.service.sendBill(dto);
		this.dto = new ToOrderBillDTO();
		this.service.readData(dto);

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"新增成功", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return null;
	}

	public String remove(ToOrderFoodItemDTO select) {
		dto.getToOrderFoods().remove(select);
		return null;

	}

	/**
	 * 小鍵盤輸入
	 * 
	 * @author 1109001
	 *
	 */
	enum Key_CODE {
		K_1(1), //
		K_2(2), //
		K_3(3), //
		K_4(4), //
		K_5(5), //
		K_6(6), //
		K_7(7), //
		K_8(8), //
		K_9(9), //
		K_0(0) {
			@Override
			public String changeValue(String orgValue) {
				if (StringUtils.isBlank(orgValue)) {
					return orgValue;
				}
				return super.changeValue(orgValue);
			}
		},
		K_CLEAN(-1) {
			@Override
			public String changeValue(String orgValue) {
				return StringUtils.EMPTY;
			}
		},

		K_BACK(-2) {
			@Override
			public String changeValue(String orgValue) {

				if (StringUtils.isBlank(orgValue)) {
					return StringUtils.EMPTY;
				} else {
					return orgValue.substring(0, orgValue.length() - 1);
				}

			}
		},
		;
		private int value;

		private Key_CODE(int value) {
			this.value = value;
		}

		public String changeValue(String orgValue) {
			return orgValue + value;

		}
	}

	public void changeNum(String value) {
		final Key_CODE key = Key_CODE.valueOf(value);

		dto.setNumber(key.changeValue(dto.getNumber()));

	}

	public void selectFood(ToOrderFoodDTO food) {
		dto.setName(food.getName());
		dto.setDollar(food.getDollar() + "");
	}

	public void toAdd() {

		if (StringUtils.isBlank(dto.getName())) {
			FacesMessage facesMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "請選擇商品", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
		if (StringUtils.isBlank(dto.getNumber())) {
			FacesMessage facesMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "請輸入數量", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}else{
			ToOrderFoodItemDTO foodItem = new ToOrderFoodItemDTO();

			foodItem.setName(dto.getName());
			foodItem.setDollar(Integer.parseInt(dto.getDollar()));
			foodItem.setNumber(dto.getNumber());
			foodItem.setSpecailize(StringUtils.join(dto.getFeatureStringList(), ","));

			if (dto.getToOrderFoods().contains(foodItem)) {
				foodItem = dto.getToOrderFoods().get(
						dto.getToOrderFoods().indexOf(foodItem));
				foodItem.setNumber(dto.getNumber());
			} else {
				dto.getToOrderFoods().add(foodItem);
			}
		}

		

	}

	public void count() {
		int total = 0;
		for (ToOrderFoodItemDTO item : dto.getToOrderFoods()) {
			total += item.getDollar() * Integer.parseInt(item.getNumber());
		}
		dto.setTotalMoney(total + "");
	}

	public void hasPay() {
		this.getDto().setPayied("Y");
	}
}
