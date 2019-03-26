package com.neusoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.service.ICdService;
import com.neusoft.vo.Cd;
@Controller
@RequestMapping("cd.do")
public class CdController {
	
	@Autowired
	ICdService iCdService;
	
	@RequestMapping(params="listCd")
	public String listCd(Integer index,ModelMap modelmap ){
		int size=5;
		Map<String,Object> map=new HashMap<String, Object>();
		int count=iCdService.queryCount(map);
		int total=count%size==0?count/size:count/size+1;
		if(index==null){
			index=1;
		}
		map.put("start", (index-1)*size);
		map.put("size", size);
		
		List<Cd> cds=iCdService.getAllCd(map);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("cds", cds);
		return "cdsList";
	}
	
	@RequestMapping(params="addCd")
	public String addCd(String cdmc,String cl,float jg,ModelMap modelmap ){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cdmc",cdmc);
		map.put("cl",cl);
		map.put("jg",jg);
		int count = iCdService.addCd(map);
		if(count >0){
			return "redirect:cd.do?listCd";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="editCd")
	public String editCd(String cid,String cdmc,String cl,Float jg,ModelMap modelmap ){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cid",cid);
		map.put("cdmc",cdmc);
		map.put("cl",cl);
		map.put("jg",jg);
		int count = iCdService.editCd(map);
		if(count >0){
			return "redirect:cd.do?listCd";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="deleteCd")
	public String deleteCd(String cid,ModelMap modelmap ){
		int count = iCdService.deleteCd(cid);
		if(count >0){
			return "redirect:cd.do?listCd";
		}else{
			return "no";
		}
	}
}
