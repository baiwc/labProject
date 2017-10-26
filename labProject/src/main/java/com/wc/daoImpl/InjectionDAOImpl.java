package com.wc.daoImpl;

import org.springframework.stereotype.Repository;

import com.wc.dao.InjectionDAO;

@Repository
public class InjectionDAOImpl implements InjectionDAO {

	@Override
	public void save(String msg) {
		// TODO Auto-generated method stub
		System.out.println("DAO要保存的数据： "+ msg);
	}

}
