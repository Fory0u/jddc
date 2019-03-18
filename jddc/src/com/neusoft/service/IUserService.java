package com.neusoft.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.User;

public interface IUserService {

//	int getCheckAccount(String userNo);

	User getLogin(String loginid,String loginPwd);

	int queryCount(Map<String, Object> map);

	List<User> getUserList(Integer index, int size, String userName,
			String userAgender);

	void addUser(Map<String, Object> map);

	void deleteUser(String cid);

	User detailUser(String cid);

	void editUser(Map<String, Object> map);

	int queryRecordCount(Map<String, Object> map);
	
	

}
