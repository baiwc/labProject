package com.wc.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.wc.service.InjectionService;

public class TestInjection extends BaseJunit4Test {
	
	@Autowired
	private InjectionService injectionService;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Test
	public void testInjextion(){
		injectionService.save("第一个测试");
		System.out.println("llll");
	}
	
	@Test
	public void getMsg(){
		List list = jdbcTemplate.queryForList("select * from user", new HashMap<String,Object>());
		if(list != null && list.size() > 0){
			System.out.println("数据大小"+list.size()+";"+"数据"+list.toString());
			
		}else{
			System.out.println("没有数据或者数据库异常");
		}
	}

}
