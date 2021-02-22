package com.yuansong.mwm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.mwm.config.Constant;
import com.yuansong.mwm.controller.vo.AuthLoginByTokenReq;
import com.yuansong.mwm.controller.vo.AuthLoginReq;
import com.yuansong.mwm.controller.vo.AuthLoginResp;
import com.yuansong.mwm.controller.vo.BaseResp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@ApiOperation(value="登录")
	@PostMapping(value="/login",produces = "application/json;charset=UTF-8")
	public BaseResp<AuthLoginResp> login(@RequestBody AuthLoginReq req) {
		BaseResp<AuthLoginResp> resp = new BaseResp<AuthLoginResp>();
		resp.setCode(0L);
		resp.setMessage("success");
		AuthLoginResp data = new AuthLoginResp();
		data.setToken("token");
		data.setExpire(System.currentTimeMillis() + Constant.TOKEN_EXPIRE_IN);
		resp.setData(data);
		return resp;
	}
	
	@ApiOperation(value="登录")
	@PostMapping(value="/login",produces = "application/json;charset=UTF-8")
	public BaseResp<AuthLoginResp> login(@RequestBody AuthLoginByTokenReq req) {
		BaseResp<AuthLoginResp> resp = new BaseResp<AuthLoginResp>();
		resp.setCode(0L);
		resp.setMessage("success");
		AuthLoginResp data = new AuthLoginResp();
		data.setToken("token");
		data.setExpire(System.currentTimeMillis() + Constant.TOKEN_EXPIRE_IN);
		resp.setData(data);
		return resp;
	}
	
}
