package service.impl;

import java.util.List;

import mapper.BaseDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.BaseDict;
import service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> getBaseDictByCode(String code) {
		return baseDictMapper.getBaseDictByCode(code);
	}

}
