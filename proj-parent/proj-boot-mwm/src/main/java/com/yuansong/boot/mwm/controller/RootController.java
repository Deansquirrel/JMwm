package com.yuansong.boot.mwm.controller;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.common.Hex;
import com.yuansong.tools.secret.ZillionWSDA;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags= {"01 Root"})
@RequestMapping("/")
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);

	@ApiOperation("Root")
	@GetMapping("/")
	public String root() {
		logger.debug(MessageFormat.format("{0}", "Root"));
		String msg = "";
		try {
			msg = ZillionWSDA.EncryptToBase64Format("1234", "deansquirrel");
			logger.debug(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hexStr = Hex.str2HexStr(msg);
		logger.debug(hexStr);
		hexStr = hexStr.replace(" ", "");
				logger.debug(hexStr);
		logger.debug(Hex.hexStr2Str(hexStr));
		
		try {
			logger.debug(ZillionWSDA.DecryptFromBase64Format(msg, "deansquirrel"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Root" + msg;
	}
}
