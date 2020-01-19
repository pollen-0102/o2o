package com.oracle.o2o.entity;
import java.util.Date;
import java.util.List;
/**
 * ��Ʒʵ����
 *
 */
public class Product {
	// ����ID
	private Long productId;
	// ��Ʒ��
	private String productName;
	// ��Ʒ���
	private String productDesc;
	// ����ͼ
	private String imgAddr;
	// ԭ��
	private String normalPrice;
	// �ּ�(�ƹ�۸�)
	private String promotionPrice;
	// Ȩ�أ�Խ��Խ��ǰ��ʾ
	private Integer priority;
	// ����ʱ��
	private Date createTime;
	// ���һ�εĸ���ʱ��
	private Date lastEditTime;
	// 0.�¼� 1.��ǰ��չʾϵͳչʾ
	private Integer enableStatus;

	// ͼƬ����ͼ�б�����Ʒ�Ƕ��һ�Ĺ�ϵ
	private List<ProductImg> productImgList;
	// ��Ʒ���һ����Ʒ������һ����Ʒ���
	private ProductCategory productCategory;
	// ����ʵ���࣬������Ʒ�����ĸ�����
	private Shop shop;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
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

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public List<ProductImg> getProductImgList() {
		return productImgList;
	}

	public void setProductImgList(List<ProductImg> productImgList) {
		this.productImgList = productImgList;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}