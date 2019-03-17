package com.neusoft.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.User;

public interface UserMapper {

	User getLogin(@Param(value="loginAcct")String loginAcct,@Param(value="loginPwd")String loginPwd);

	int getCheckAccount(String userNo);

	int queryCount(Map<String, Object> map);

	List<User> getUserList(Map<String, Object> map);

	void addUser(Map<String, Object> map);

	void deleteUser(String userNo);

	User detailUser(String userNo);

	void editUser(Map<String, Object> map);

	int queryRecordCount(Map<String, Object> map);
}
