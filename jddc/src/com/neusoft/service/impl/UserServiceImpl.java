package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.mapper.UserMapper;
import com.neusoft.service.IUserService;
import com.neusoft.vo.User;

@Transactional
@Service("IUserService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
//	@Override
//	public int getCheckAccount(String userNo) {
//		return userMapper.getCheckAccount(userNo);
//	}

	@Override
	public	User getLogin(String loginid,String loginPwd) {
		return userMapper.getLogin(loginid, loginPwd);
	}

	@Override
	public int queryCount(Map<String, Object> map) {
		return userMapper.queryCount(map);
	}

	@Override
	public List<User> getUserList(Integer index, int size, String userName,
			String userAgender) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		 if(index==null){
	    	  index=0;
	      }
	       map.put("userName", userName);
	       map.put("userAgender",userAgender);
	       map.put("start",(index-1)*size);
	       map.put("pagesize",size);
	       List<User> list=userMapper.getUserList(map);
	     return list;
	}

	@Override
	public void addUser(Map<String, Object> map) {
        userMapper.addUser(map);		
	}

	@Override
	public void deleteUser(String userNo) {
		userMapper.deleteUser(userNo);
	}

	@Override
	public User detailUser(String userNo) {
		return userMapper.detailUser(userNo);
	}

	@Override
	public void editUser(Map<String, Object> map) {
		userMapper.editUser(map);
	}

	@Override
	public int queryRecordCount(Map<String, Object> map) {
		return userMapper.queryRecordCount(map);
	}



}
