package com.neusoft.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.User;

public interface UserMapper {

	User getLogin(@Param(value="loginid")String loginid,@Param(value="loginPwd")String loginPwd);

	int getCheckAccount(String userNo);

	int queryCount(Map<String, Object> map);

	List<User> getUserList(Map<String, Object> map);

	void addUser(Map<String, Object> map);

	void deleteUser(@Param(value="c_id")String cid);

	User detailUser(@Param(value="c_id")String cid);

	void editUser(Map<String, Object> map);

	int queryRecordCount(Map<String, Object> map);
	/***
	 * 根据单值代码类型和序号获得单值名称
	 * @param dzdmlx
	 * @param dzdmxh
	 * @return
	 */
	String getDzdmMc(@Param("dzdmlx")String dzdmlx,@Param("dzdmxh")String dzdmxh);
	/**
	 * 根据单值代码类型获得单值名称列表
	 * @param dzdmlx
	 * @return
	 */
	List<Map<String,String>> getDzdmMcList(@Param("dzdmlx")String dzdmlx);
}
