package com.neusoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.mapper.UserMapper;
import com.neusoft.service.IClService;
import com.neusoft.vo.Cl;
@Controller
@RequestMapping("cl.do")
public class ClController {
	
	@Autowired
	IClService iClService;

	
	@RequestMapping(params="listCl")
	public String listCl(Integer index,ModelMap modelmap ){
		int size=5;
		Map<String,Object> map=new HashMap<String, Object>();
		int count=iClService.queryCount(map);
		int total=count%size==0?count/size:count/size+1;
		if(index==null){
			index=1;
		}
		map.put("start", (index-1)*size);
		map.put("size", size);
		
		List<Cl> cls=iClService.getAllCl(map);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("cls", cls);
		return "clsList";
	}
	@RequestMapping(params="listClQt")
	public String listClQt(Integer index,ModelMap  modelmap ){
		List<Cl> cls=iClService.getAllCl(null);
		modelmap.put("cls", cls);
		return "/qt/cdgl";
	}
	@RequestMapping(params="addCl")
	public String addCl(String cl,ModelMap modelmap ){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cl",cl);
		
		int count = iClService.addCl(map);
		if(count >0){
			return "redirect:cl.do?listCl";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="editCl")
	public String editCl(String cid,String cl,ModelMap modelmap ){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cid",cid);
		map.put("cl",cl);
		int count = iClService.editCl(map);
		if(count >0){
			return "redirect:cl.do?listCl";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="deleteCl")
	public String deleteCl(String cid,ModelMap modelmap ){
		int count = iClService.deleteCl(cid);
		if(count >0){
			return "redirect:cl.do?listCl";
		}else{
			return "no";
		}
	}
	
	@RequestMapping(params="detailCl")
	public String detailUser(String cid,HttpServletRequest request){
		Cl cl=iClService.getClById(cid);
		request.setAttribute("cl", cl);
		return "clEdit";
	}
	@ResponseBody
	@RequestMapping(params="getAllCl")
	public JSONArray getAllCl(HttpServletRequest request){
		List<Cl> cls=iClService.getAllCl(null);
		return JSONArray.fromObject(cls);
	}
	
}
