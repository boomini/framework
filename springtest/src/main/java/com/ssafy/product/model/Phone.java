package com.ssafy.product.model;

public class Phone {
	String num;
	String mode;
	int price;
	int vcode;
	String vendor;
	@Override
	public String toString() {
		return "Phone [num=" + num + ", mode=" + mode + ", price=" + price + ", vcode=" + vcode + ", vendor=" + vendor
				+ "]";
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getVcode() {
		return vcode;
	}
	public void setVcode(int vcode) {
		this.vcode = vcode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	
}
