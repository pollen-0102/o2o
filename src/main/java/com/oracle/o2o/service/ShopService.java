package com.oracle.o2o.service;

import com.oracle.o2o.dto.ImageHolder;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.exception.ShopOperationException;


public interface ShopService {
	/**
	 * ע�������Ϣ������ͼƬ����
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
