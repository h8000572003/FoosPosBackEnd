package com.food.pos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "Meal")
public class MealPo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	@Column(name = "txId")
	private String txId;

	@Column(name = "name")
	private String name;

	@Column(name = "spcialize")
	private String spcialize;

	@Column(name = "dollar")
	private String dollar;

	@Column(name = "number")
	private String number;

	@Column(name = "useNumber")
	private String useNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpcialize() {
		return spcialize;
	}

	public void setSpcialize(String spcialize) {
		this.spcialize = spcialize;
	}

	public String getDollar() {
		return dollar;
	}

	public void setDollar(String dollar) {
		this.dollar = dollar;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUseNumber() {
		return useNumber;
	}

	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MealPo) {
			MealPo po = (MealPo) obj;
			if (StringUtils.equals(po.getName() + po.getSpcialize(), getName()
					+ getSpcialize())) {
				return true;

			} else {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
}
