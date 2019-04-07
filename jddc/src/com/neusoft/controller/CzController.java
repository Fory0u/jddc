package com.neusoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.mapper.UserMapper;
import com.neusoft.mapper.CzMapper;
import com.neusoft.service.ICzService;
import com.neusoft.vo.Cl;
import com.neusoft.vo.Cz;

@Controller
@RequestMapping("cz.do")
public class CzController {

	@Autowired
	ICzService iCzService;
	@Autowired
	UserMapper userMapper;
	@Autowired
	CzMapper czMapper;

	@RequestMapping(params = "listCz")
	public String listCz(Integer index, ModelMap modelmap) {
		int size = 5;
		Map<String, Object> map = new HashMap<String, Object>();
		int count = iCzService.queryCount(map);
		int total = count % size == 0 ? count / size : count / size + 1;
		if (index == null) {
			index = 1;
		}
		map.put("start", (index - 1) * size);
		map.put("size", size);

		List<Cz> czs = iCzService.getAllCz(map);
		getCz(czs);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("czs", czs);
		return "czsList";
	}

	@RequestMapping(params = "listCzQt")
	public String listCzQt(Integer index, ModelMap modelmap) {
//		int size = 5;
		Map<String, Object> map = new HashMap<String, Object>();
//		int count = iCzService.queryCount(map);
//		int total = count % size == 0 ? count / size : count / size + 1;
		if (index == null) {
			index = 1;
		}
//		map.put("start", (index - 1) * size);
//		map.put("size", size);

		List<Cz> czs = iCzService.getAllCz(map);
		getCz(czs);
//		modelmap.put("index", index);
//		modelmap.put("total", total);
		modelmap.put("czs", czs);
		return "/qt/czgl";
	}

	/**
	 * ̬将状态单值代码转成状态文字
	 * 
	 * @param czs
	 */
	private void getCz(List<Cz> czs) {
		// TODO Auto-generated method stub
		for (Cz cz : czs) {
			cz.setCCzzt(czMapper.selectCzzt(cz.getCCzzt()));
		}
	}

	@RequestMapping(params = "getCzIdtoCd")
	public String getCzIdtoCd(String czid, ModelMap modelmap,
			HttpSession session) {
		Cz cz = iCzService.getCzById(czid);
		// modelmap.put("cz", cz);
		session.setAttribute("cz", cz);
		return "redirect:cl.do?listClQt";
	}

	@RequestMapping(params = "addCz")
	public String addCz(String czmc, String czzt, Integer czrs,
			ModelMap modelmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("czmc", czmc);
		map.put("czzt", czzt);
		map.put("czrs", czrs);

		int count = iCzService.addCz(map);
		if (count > 0) {
			return "redirect:cz.do?listCz";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "editCz")
	public String editCz(String cid, String czmc, String czzt, Integer czrs,
			ModelMap modelmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("czmc", czmc);
		map.put("czzt", czzt);
		map.put("czrs", czrs);

		int count = iCzService.editCz(map);
		if (count > 0) {
			return "redirect:cz.do?listCz";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "deleteCz")
	public String deleteCz(String cid, ModelMap modelmap) {
		int count = iCzService.deleteCz(cid);
		if (count > 0) {
			return "redirect:cz.do?listCz";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "detailCz")
	public String detailUser(String cid, HttpServletRequest request) {
		Cz cz = iCzService.getCzById(cid);
		cz.setCCzzt(userMapper.getDzdmMc("10003", cz.getCCzzt()));
		request.setAttribute("cz", cz);
		return "czEdit";
	}

	@ResponseBody
	@RequestMapping(params = "getAllCzzt")
	public JSONArray getAllCzzt(HttpServletRequest request) {
		List<Map<String, String>> czzts = userMapper.getDzdmMcList("10003");
		return JSONArray.fromObject(czzts);
	}

}
