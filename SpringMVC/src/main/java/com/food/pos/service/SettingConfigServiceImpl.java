package com.food.pos.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

import com.food.pos.dto.SettingConfigDTO;

@Service("settingConfigService")
public class SettingConfigServiceImpl implements SettingConfigService {

	@Override
	public void load(SettingConfigDTO dto) {
		dto.setNowIp(this.getIp());

	}

	private String getIp() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();

			return localhost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

}
