package springBootMVCShopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.AutoNumMapper;
@Service
public class AutoNumService {
	@Autowired
	AutoNumMapper autoNumMapper;
	public String execute(String sep, String columnName, int len, String tableName) {
		String autoNum = autoNumMapper.autoNumSelect(sep, columnName, len, tableName);
		return autoNum;
	}
}
