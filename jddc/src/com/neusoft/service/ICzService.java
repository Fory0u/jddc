package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Cz;

public interface ICzService {
	Cz getCzById(String cid);
	List<Cz> getAllCz();

	int addCz(Map<String, Object> map);

	int deleteCz(String cid);
}
