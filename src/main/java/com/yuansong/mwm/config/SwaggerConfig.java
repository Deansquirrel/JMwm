package com.yuansong.mwm.config;

import org.springframework.context.annotation.Configuration;

import com.yuansong.tools.swagger.ISwaggerConfig;

@Configuration
public class SwaggerConfig implements ISwaggerConfig {

	@Override
	public Boolean getEnable() {
		return true;
	}

	@Override
	public String getTitle() {
		return "mwm";
	}

	@Override
	public String getDescription() {
		return "";
	}

	@Override
	public String getVersion() {
		return "version";
	}

	@Override
	public String getBasePackage() {
		return "com.yuansong";
	}

}
