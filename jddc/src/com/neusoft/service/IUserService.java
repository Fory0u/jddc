package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.User;

public interface IUserService {

	int getCheckAccount(String userNo);

	User getBgLogin(String userNo, String userPwd);

	int queryCount(Map<String, Object> map);

	List<User> getUserList(Integer index, int size, String userName,
			String userAgender);

	void addUser(Map<String, Object> map);

	void deleteUser(String userNo);

	User detailUser(String userNo);

	void editUser(Map<String, Object> map);

	int queryRecordCount(Map<String, Object> map);


}
