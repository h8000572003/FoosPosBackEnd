package com.food.pos.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.pos.domain.GCMDTO;
import com.food.pos.domain.GCMPo;
import com.food.pos.service.GCMService;
import com.food.pos.util.POST2GCM;
import com.mkyong.common.model.Status;

@Controller
@RequestMapping("/gcm")
public class GCMController {

	private Logger LOG = LoggerFactory.getLogger(GCMController.class);

	@Autowired
	private GCMService gCMService;

	public GCMController() {
		LOG.info("GCMController..begin");
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody List<GCMPo> query() {

		try {

			GCMDTO gCMDTO = new GCMDTO();

			return gCMService.queryAll(gCMDTO);
		} catch (Exception e) {
			LOG.error("e:", e);
			return new ArrayList<GCMPo>();
		}

	}

	/**
	 * 註冊通知
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody Status insert(@RequestParam("id") String id) {

		LOG.info("insert id={}", id);
		GCMDTO gCMDTO = new GCMDTO();
		gCMDTO.setgCMPo(new GCMPo());
		gCMDTO.getgCMPo().setId(id);

		final Status status = new Status();
		try {
			gCMService.insert(gCMDTO);
			status.successful();
		} catch (Exception e) {
			LOG.error("e:", e);
			status.fail();
		} finally {
			return status;
		}

	}

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public @ResponseBody Status send() {
		GCMDTO gCMDTO = new GCMDTO();
		final Status status = new Status();
		try {
			List<GCMPo> gcms = gCMService.queryAll(gCMDTO);
			for (GCMPo po : gcms) {
				POST2GCM.post(po.getId(), "test");
			}
			status.successful();
		} catch (Exception e) {
			status.fail();
		} finally {

		}

		return status;

	}
}
