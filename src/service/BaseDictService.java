package service;

import java.util.List;

import pojo.BaseDict;

/**
 * 字典数据表业务逻辑接口
 * @author Steven
 *
 */
public interface BaseDictService {
	/**
	 * 跟据字典编码查询字典列表
	 * @param code
	 * @return
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
