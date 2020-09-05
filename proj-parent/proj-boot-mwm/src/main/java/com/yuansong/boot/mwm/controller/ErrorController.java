package com.yuansong.boot.mwm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.Gson;
import com.yuansong.boot.mwm.controller.vo.BaseMessage;
import com.yuansong.tools.common.ExceptionTool;

@RestControllerAdvice
public class ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	@ExceptionHandler(Exception.class)
    public String error(Exception e){
		String errMsg = ExceptionTool.getStackTrace(e); 
		logger.error(errMsg);
        Gson gson = new Gson();
        BaseMessage<String> resp = new BaseMessage<String>();
        resp.setCode("-1");
        resp.setMessage("未处理的异常。" + errMsg);
        return gson.toJson(resp);
    }
}
