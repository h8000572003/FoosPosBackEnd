package com.food.pos.util;

import java.io.IOException;

import com.food.pos.contract.Contract;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class POST2GCM {

	
	public static void post(String registrationId, String content) {
		Sender sender = new Sender(Contract.API_KEY);
		Message message = new Message.Builder().addData("message", content)
				.addData("other-parameter", "some value").build();
		try {
			Result result = sender.send(message, registrationId, 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
