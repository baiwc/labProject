package com.wc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.dao.InjectionDAO;
import com.wc.service.InjectionService;

@Service
public class InjectionServiceImpl implements InjectionService {

	@Autowired
	private InjectionDAO injectionDAO;
	
	@Override
	public void save(String msg) {
		// TODO Auto-generated method stub
		
		System.out.println("Service 接受到的参数 ： "+msg);
		
		msg = msg + ":" + this.hashCode();
		
		injectionDAO.save(msg);
	}

}
