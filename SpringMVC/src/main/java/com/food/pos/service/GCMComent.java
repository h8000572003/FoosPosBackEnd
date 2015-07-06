package com.food.pos.service;

import com.food.pos.json.ReqCode;

public interface GCMComent {
	/**
	 * 所有註冊id通知
	 * 
	 * @param message
	 */
	void sendAll(ReqCode message);

	/**
	 * 對單一註冊id通知
	 * 
	 * @param id
	 * @param message
	 */
	void sendById(String id, ReqCode message);
}
