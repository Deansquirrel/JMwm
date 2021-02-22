package com.yuansong.mwm.repository;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	
	public boolean isUserExists(String username, String password) {
		if("yuansong".equals(username) && "yuansong".equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
