package com.neusoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.service.ICzService;
import com.neusoft.vo.Cz;
@Controller
@RequestMapping("cz.do")
public class CzController {
	
	@Autowired
	ICzService iCzService;
	
	@RequestMapping(params="listCz")
	public String listCz(Integer index,ModelMap modelmap ){
		int size=5;
		Map<String,Object> map=new HashMap<String, Object>();
		int count=iCzService.queryCount(map);
		int total=count%size==0?count/size:count/size+1;
		if(index==null){
			index=1;
		}
		map.put("start", (index-1)*size);
		map.put("size", size);
		
		List<Cz> czs=iCzService.getAllCz(map);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("czs", czs);
		return "czsList";
	}
}
