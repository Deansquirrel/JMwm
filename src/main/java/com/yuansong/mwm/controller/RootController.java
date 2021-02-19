package com.yuansong.mwm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/root")
public class RootController {
	
	@ApiOperation(value="测试目录")
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String getRoot() {
		return "root";
	}
}
