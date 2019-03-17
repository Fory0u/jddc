package com.neusoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.service.IUserService;
import com.neusoft.util.CodeUtil;
import com.neusoft.vo.User;
@Controller
@RequestMapping("/user.do")
public class UserController {

	@Autowired
	private IUserService userService;
	@ResponseBody
	@RequestMapping(params="isLogin")
	public String isLogin(String userNo,String userPwd,HttpSession session){
	    
	    System.out.println(userNo);
	    System.out.println(userPwd);

		String flag="";
		//先判断账号是否存在
		int count=userService.getCheckAccount(userNo);
		//在判断密码是否正确 
		if(count<=0){
			return "A";
		}
		User bgUser=userService.getBgLogin(userNo,userPwd);
	    if(null==bgUser){
	    	flag="N";//账号或密码错误
	    }else{
	    	flag="Y";
	    	session.setAttribute("bgUser", bgUser);
	    }
	    
	    
		return flag;
	}
	@RequestMapping(params="indexBg")
	public String indexBg(){
		return "index";
	}
	@RequestMapping(params="welcome")
	public String welcome(){
		return "welcome";
	}
	@RequestMapping(params="qiehuan")
	public String qiehuan(){
		return "login";
	}
	
	@RequestMapping(params="listUser")
	public String listUser(HttpSession session,Integer index,String userName,String userAgender){
		int size=5;
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("userAgender", userAgender);
		int count=userService.queryCount(map);
		int total=count%size==0?count/size:count/size+1;
		if(index==null){
			index=1;
		}
		List<User>	users=userService.getUserList(index, size, userName,userAgender);
		session.setAttribute("index", index);
		session.setAttribute("total", total);
		session.setAttribute("users", users);
		return "usersList";
	}
	@RequestMapping(params="addUser")
	public String addUser(String userName,String userAge,String userAgender,String adminFlag,String userPwd){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userNo", CodeUtil.getCodeStr(4));
		map.put("userName", userName);
		map.put("userPwd", userPwd);
		map.put("userAge", userAge);
		map.put("userAgender", userAgender);
		map.put("userFlag", adminFlag);
		userService.addUser(map);
		return "redirect:user.do?listUser";
	}
	@RequestMapping(params="deleteUser")
	public String deleteUser(String userNo){
		userService.deleteUser(userNo);
		return "redirect:user.do?listUser";
	}
	@RequestMapping(params="detailUser")
	public String detailUser(String userNo,HttpServletRequest request){
		User user=userService.detailUser(userNo);
		request.setAttribute("user", user);
		return "user-edit";
	}
	@RequestMapping(params="editUser")
	public String editUser(String userNo,String userAge,String userAgender,String adminFlag,String userPwd){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userNo", userNo);
		map.put("userPwd", userPwd);
		map.put("userAge", userAge);
		map.put("userAgender", userAgender);
		map.put("userFlag", adminFlag);
		userService.editUser(map);
		return "redirect:user.do?listUser";
	}
	

	
}
