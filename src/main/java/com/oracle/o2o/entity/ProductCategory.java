package com.oracle.o2o.entity;
import java.util.Date;

/**
 * ��Ʒ���ʵ����
 *
 */
public class ProductCategory {
	// ����ID
	private Long productCategoryId;
	// ������������ĸ����̵�
	private Long shopId;
	// �����
	private String productCategoryName;
	// Ȩ�أ�Խ��Խ��ǰ��ʾ
	private Integer priority;
	// ����ʱ��
	private Date createTime;

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
