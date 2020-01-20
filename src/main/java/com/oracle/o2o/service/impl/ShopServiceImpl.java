package com.oracle.o2o.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.oracle.o2o.dao.ShopDao;
import com.oracle.o2o.dto.ImageHolder;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.enums.ShopStateEnum;
import com.oracle.o2o.exception.ShopOperationException;
import com.oracle.o2o.service.ShopService;
import com.oracle.utils.ImageUtil;
import com.oracle.utils.PathUtil;
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
 
	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		// ��ȡshopͼƬĿ¼�����ֵ·��
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
		// ��ֵ�ж�
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// ��������Ϣ����ʼֵ
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			// ��ӵ�����Ϣ
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("���̴���ʧ��");
			} else {
				if (thumbnail.getImage() != null) {
					// �洢ͼƬ
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					// ���µ��̵�ͼƬ��ַ
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("����ͼƬ��ַʧ��");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.Check, shop);
	}
}
