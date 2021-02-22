package com.yuansong.mwm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.mwm.config.Constant;
import com.yuansong.mwm.controller.vo.AuthLoginByTokenReq;
import com.yuansong.mwm.controller.vo.AuthLoginReq;
import com.yuansong.mwm.controller.vo.AuthLoginResp;
import com.yuansong.mwm.controller.vo.BaseResp;
import com.yuansong.mwm.controller.vo.TokenConetent;
import com.yuansong.mwm.repository.User;
import com.yuansong.mwm.service.TokenHelper;
import com.yuansong.tools.common.ExceptionTool;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private TokenHelper tokenHelper;

	@ApiOperation(value="登录")
	@PostMapping(value="/login",produces = "application/json;charset=UTF-8")
	public BaseResp<AuthLoginResp> login(@RequestBody AuthLoginReq req) {
		return this.getAuthResult(req.getUsername(), req.getPassword());
	}
	
	@ApiOperation(value="登录")
	@PostMapping(value="/loginByToken",produces = "application/json;charset=UTF-8")
	public BaseResp<AuthLoginResp> login(@RequestBody AuthLoginByTokenReq req) {
		BaseResp<AuthLoginResp> resp = new BaseResp<AuthLoginResp>();
		TokenConetent content = null;
		try {
			content = this.tokenHelper.getTokenContent(req.getToken());
		} catch(Exception e) {
			logger.error(ExceptionTool.getStackTrace(e));
			resp.setCode(-1L);
			resp.setMessage("校验失败，请稍后重试");
			return resp;
		}
		if(content.getExpire() < System.currentTimeMillis()) {
			resp.setCode(-1L);
			resp.setMessage("登录已超时，请重新登录");
			return resp;
		}
		return this.getAuthResult(content.getUsername(), content.getPassword());
	}
	
	private BaseResp<AuthLoginResp> getAuthResult(String username, String password) {
		BaseResp<AuthLoginResp> resp = new BaseResp<AuthLoginResp>();
		if(this.user.isUserExists(username, password)) {
			Long expire = System.currentTimeMillis() + Constant.TOKEN_EXPIRE_IN;
			TokenConetent content = new TokenConetent();
			content.setUsername(username);
			content.setPassword(password);
			content.setExpire(expire);
			String token = "";
			try {
				token = this.tokenHelper.getToken(content);
			} catch(Exception e) {
				logger.error(ExceptionTool.getStackTrace(e));
				resp.setCode(-1L);
				resp.setMessage("校验失败，请稍后重试");
				return resp;
			}
			resp.setCode(0L);
			resp.setMessage("success");
			AuthLoginResp data = new AuthLoginResp();
			data.setToken(token);
			data.setExpire(expire);
			resp.setData(data);
			return resp;			
		} else {
			resp.setCode(-1L);
			resp.setMessage("用户名或密码错误");
			return resp;
		}
	}
	
}
