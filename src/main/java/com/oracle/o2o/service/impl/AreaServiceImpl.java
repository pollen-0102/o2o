package com.oracle.o2o.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracle.o2o.dao.AreaDao;
import com.oracle.o2o.entity.Area;
import com.oracle.o2o.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDao areadao;
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areadao.queryArea();
	}

}
