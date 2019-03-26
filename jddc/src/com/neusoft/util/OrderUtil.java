package com.neusoft.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.service.ICdService;
import com.neusoft.vo.Cd;
@Service
public class OrderUtil {
	@Autowired
	ICdService iCdService;
	
	public Map<String,Object> getOrder(String dcxx,String dcsl){
		Map<String,Object> map = new HashMap<String,Object>();
		String[] dcxxArr =  new String().split(";");
		String[] dcslArr =  new String().split(";");
		float zj =0.0f; 
		int zs = 0;
		if(dcxx != null ){
			dcxxArr = dcxx.split(";");
		}
		if(dcxx != null ){
			dcslArr = dcsl.split(",");
		}
		for (int i = 0; i < dcxxArr.length; i++) {
			Cd cd = iCdService.getCdById(dcxxArr[i]);
			zj += cd.getFJg();
		}
		for (int i = 0; i < dcslArr.length; i++) {
			zs += Integer.parseInt(dcslArr[i]);
		}
		map.put("zs", zs);
		map.put("zj", zj);
		return map;
	}

}
