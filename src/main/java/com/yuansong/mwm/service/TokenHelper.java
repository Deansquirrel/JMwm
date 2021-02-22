package com.yuansong.mwm.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yuansong.mwm.config.Constant;
import com.yuansong.mwm.controller.vo.TokenConetent;
import com.yuansong.tools.secret.ZillionWSDA;

@Service
public class TokenHelper {
	
	private Gson gson = new Gson();
	
	public String getToken(TokenConetent content) throws Exception {
		return ZillionWSDA.EncryptToBase64Format(this.gson.toJson(content), Constant.TOKEN_KEY);
	}
	
	public TokenConetent getTokenContent(String token) throws Exception {
		return this.gson.fromJson(ZillionWSDA.DecryptFromBase64Format(token, Constant.TOKEN_KEY), TokenConetent.class);
	}

}
