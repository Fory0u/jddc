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

import com.neusoft.mapper.CdMapper;
import com.neusoft.mapper.ClMapper;
import com.neusoft.service.ICdService;
import com.neusoft.vo.Cd;
import com.neusoft.vo.Cz;

@Controller
@RequestMapping("cd.do")
public class CdController {

	@Autowired
	ICdService iCdService;
	@Autowired
	CdMapper cdMapper;
	@Autowired
	ClMapper clMapper;

	@RequestMapping(params = "listCd")
	public String listCd(Integer index, ModelMap modelmap) {
		int size = 5;
		Map<String, Object> map = new HashMap<String, Object>();
		int count = iCdService.queryCount(map);
		int total = count % size == 0 ? count / size : count / size + 1;
		if (index == null) {
			index = 1;
		}
		map.put("start", (index - 1) * size);
		map.put("size", size);

		List<Cd> cds = iCdService.getAllCd(map);
		getCds(cds);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("cds", cds);
		return "cdsList";
	}

	/**
	 * ̬将状态单值代码转成文字
	 * 
	 * @param czs
	 */
	private void getCds(List<Cd> cds) {
		// TODO Auto-generated method stub
		for (Cd cd : cds) {
			cd.setCCl(clMapper.getClById(cd.getCCl()).getCCl());
		}
	}

	/***
	 * 根据菜类查询菜单
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "listCdByCl")
	public JSONArray listCdQt(String clid, ModelMap modelmap) {
		return JSONArray.fromObject(cdMapper.selectCdByCl(clid));
	}

	@RequestMapping(params = "addCd")
	public String addCd(String cdmc, String cl, float jg, ModelMap modelmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cdmc", cdmc);
		map.put("cl", cl);
		map.put("jg", jg);
		int count = iCdService.addCd(map);
		if (count > 0) {
			return "redirect:cd.do?listCd";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "editCd")
	public String editCd(String cid, String cdmc, String cl, Float jg,
			ModelMap modelmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("cdmc", cdmc);
		map.put("cl", cl);
		map.put("jg", jg);
		int count = iCdService.editCd(map);
		if (count > 0) {
			return "redirect:cd.do?listCd";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "deleteCd")
	public String deleteCd(String cid, ModelMap modelmap) {
		int count = iCdService.deleteCd(cid);
		if (count > 0) {
			return "redirect:cd.do?listCd";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "detailCd")
	public String detailUser(String cid, HttpServletRequest request) {
		Cd cd = iCdService.getCdById(cid);
		request.setAttribute("cd", cd);
		return "cdEdit";
	}

}
