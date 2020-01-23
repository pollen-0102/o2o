package com.oracle.o2o.service;
import com.oracle.o2o.dto.ImageHolder;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.exception.ShopOperationException;
/*5.店铺注册之Service层的实现
Service层需要事务的管理，店铺注册先要将店铺的信息插入到数据库，其次要返回店铺的id，通过店铺的id去创建存储图片的文件夹，在文件夹下处理上传的图片，最后将文件夹的地址更新回数据库。在其中任何一个操作出现错误都需要回滚。
店铺添加业务层接口*/

public interface ShopService {
	/**
	 * 注册店铺信息，包括图片处理
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
