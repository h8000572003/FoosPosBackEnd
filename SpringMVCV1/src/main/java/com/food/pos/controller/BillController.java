package com.food.pos.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.pos.contract.AeUtils;
import com.food.pos.json.Bill;
import com.food.pos.json.ReqCode;
import com.food.pos.service.GCMComent;
import com.food.pos.service.GCMService;
import com.google.gson.Gson;
import com.mkyong.common.model.Status;

@Controller
@RequestMapping("/bill")
public class BillController {

	private static Logger LOG = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillCompent billCompent;

	@Autowired
	private GCMService gCMService;

	@Autowired
	private GCMComent mGCMComent;

	@RequestMapping(value = "/query/unBuy/today", method = RequestMethod.GET)
	public @ResponseBody Status query() {

		Status status = new Status();
		try {
			status.setContent(this.billCompent.getTodayUnBuyBill());
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 查詢尚未進行清單
	 * 
	 * @return
	 */
	@RequestMapping(value = "/query/unBuy/today/noSpeakOut", method = RequestMethod.GET)
	public @ResponseBody Status queryAndNoSpeakOut() {

		Status status = new Status();
		try {
			status.setContent(this.billCompent
					.findTodayUnBuyAndNoSpeakOut(AeUtils.getNowTime()));
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 查詢尚未進行清單
	 * 
	 * @return
	 */
	@RequestMapping(value = "/query/unBuy/today/isSpeak", method = RequestMethod.GET)
	public @ResponseBody Status queryAndIsSpeakOut() {

		Status status = new Status();
		try {
			status.setContent(this.billCompent
					.findTodayUnBuyAndIsSpeakOut(AeUtils.getNowTime()));
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/*
	 * 更新是否叫餐狀況
	 */
	@RequestMapping(value = "/update/{txid}/isSpeakOut", method = RequestMethod.GET)
	public @ResponseBody Status updateIsSpeakOut(@PathVariable String txid,
			@RequestParam("value") String value) {
		Status status = new Status();
		try {
			this.billCompent.updateIsSpeakOut(txid, value);
			this.mGCMComent.sendAll(ReqCode.MODIFY_BIll);// 通知
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 更新是否付錢狀況
	 * 
	 * @param txid
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/update/{txid}/isPaid", method = RequestMethod.GET)
	public @ResponseBody Status updateIsPaid(@PathVariable String txid,
			@RequestParam("value") String value) {
		Status status = new Status();
		try {
			this.billCompent.updateIsPay(txid, value);
			this.mGCMComent.sendAll(ReqCode.MODIFY_BIll);// 通知
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 更新是否完成出餐
	 * 
	 * @param txid
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/update/{txid}/isMealOut", method = RequestMethod.GET)
	public @ResponseBody Status updateIsMealOut(@PathVariable String txid,
			@RequestParam("value") String value) {
		Status status = new Status();
		try {
			this.billCompent.updateIsMealOut(txid, value);
			this.mGCMComent.sendAll(ReqCode.MODIFY_BIll);// 通知
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 更新座位
	 * 
	 * @param txid
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/update/{txid}/seat", method = RequestMethod.GET)
	public @ResponseBody Status updateSeat(@PathVariable String txid,
			@RequestParam("value") String value) {
		Status status = new Status();
		try {
			this.billCompent.updateSeat(txid, value);
			this.mGCMComent.sendAll(ReqCode.MODIFY_BIll);// 通知
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 刪除今天帳單
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/today", method = RequestMethod.GET)
	public @ResponseBody Status deleteTotal() {
		Status status = new Status();
		try {
			this.billCompent.deleteTotal();
			this.mGCMComent.sendAll(ReqCode.DELETE);// 通知
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	/**
	 * 新增一筆
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insert/newOne", method = RequestMethod.POST)
	public @ResponseBody Status insertOne(HttpServletRequest request) {
		Status status = new Status();
		try {
			request.setCharacterEncoding("UTF-8");// 客戶端網頁我們控制為UTF-8
			final String message = request.getParameter("message");
			LOG.info("message={}", message);
			final Bill bill = new Gson().fromJson(message, Bill.class);
			this.billCompent.insert(bill);
			this.mGCMComent.sendAll(ReqCode.ADD_BIll);// 通知
			status.successful();

		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

}
