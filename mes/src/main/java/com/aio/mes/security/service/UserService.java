package com.aio.mes.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aio.mes.security.mapper.UserMapper;

@Service
public class UserService implements UserDetailsService{
 
	@Autowired
    UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userMapper.getUserInfo(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException("No User");
		}
		return new LoginUserVO(userVO);
	}
}
