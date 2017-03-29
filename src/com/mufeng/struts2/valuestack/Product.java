package com.mufeng.struts2.valuestack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product {
private Integer productId;
private String productName;
private String productDesc;
private Double productPrice;
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
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
public Double getProductPrice() {
	return productPrice;
}
public void setProductPrice(Double productPrice) {
	this.productPrice = productPrice;
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
			+ ", productPrice=" + productPrice + "]";
}
public String save(){
	System.out.println("save:"+this);
	ValueStack valueStack=ActionContext.getContext().getValueStack();
	Test test=new Test();
	test.setProductDesc("很好");
	test.setProductName("auto");
	valueStack.push(test);
	return "success";
}
}
