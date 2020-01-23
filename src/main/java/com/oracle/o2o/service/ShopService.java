package com.oracle.o2o.service;
import com.oracle.o2o.dto.ImageHolder;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.exception.ShopOperationException;
/*5.����ע��֮Service���ʵ��
Service����Ҫ����Ĺ�������ע����Ҫ�����̵���Ϣ���뵽���ݿ⣬���Ҫ���ص��̵�id��ͨ�����̵�idȥ�����洢ͼƬ���ļ��У����ļ����´����ϴ���ͼƬ������ļ��еĵ�ַ���»����ݿ⡣�������κ�һ���������ִ�����Ҫ�ع���
�������ҵ���ӿ�*/

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
