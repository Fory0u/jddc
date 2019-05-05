package com.neusoft.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.mapper.CdMapper;
import com.neusoft.mapper.ClMapper;
import com.neusoft.service.ICdService;
import com.neusoft.service.IClService;
import com.neusoft.vo.Cd;
import com.neusoft.vo.Cl;
import com.sun.net.httpserver.HttpServer;

@Controller
@RequestMapping("cd.do")
public class CdController {

	@Autowired
	ICdService iCdService;
	@Autowired
	CdMapper cdMapper;
	@Autowired
	ClMapper clMapper;
	@Autowired
	IClService iClService;
	
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
	@RequestMapping(params = "findMoByCdmc")
	public String findMoByCdmc(String cdmc, ModelMap modelmap) {
		List<Cd> cds = cdMapper.findMoByCdmc(cdmc);
		List<Cl> cls = iClService.getAllCl(null);
		modelmap.put("cds", cds);
		modelmap.put("cls", cls);
		return "/qt/cdgl";
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
	public String addCd(String cdmc, String cl, float jg, MultipartFile photo, ModelMap modelmap ,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cdmc", cdmc);
		map.put("cl", cl);
		map.put("jg", jg);
		map.put("photo", getPhoto(photo,request));
		
		int count = iCdService.addCd(map);
		if (count > 0) {
			return "redirect:cd.do?listCd";
		} else {
			return "no";
		}
	}

	private Object getPhoto(MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//获取文件名
		String photo = file.getOriginalFilename();
		//判断文件是否存在 
		if(!file.getOriginalFilename().equals("")){
			//定义上传路径
//			String str = "E:\\tomcat\\apache-tomcat-7.0.90\\webapps\\shy\\upload";
		
			String str = "";
			try {
				String str1 = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
				str = str1.substring(1,str1.indexOf(request.getContextPath())+request.getContextPath().length() ) + "/upload";
				 
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
//			String name=file.getOriginalFilename();
			//文件名拼接到指定路径上
			File desc = new File(str+"\\"+file.getOriginalFilename());
			//从内存中读到指定的磁盘中
			try {
				file.transferTo(desc);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return photo;
	}
	@RequestMapping(params = "editCd")
	public String editCd(String cid, String cdmc, String cl, Float jg,MultipartFile photo,HttpServletRequest request,
			ModelMap modelmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("cdmc", cdmc);
		map.put("cl", cl);
		map.put("jg", jg);
		map.put("photo", getPhoto(photo,request));
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
