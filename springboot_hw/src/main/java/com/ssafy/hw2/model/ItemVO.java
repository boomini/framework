package com.ssafy.hw2.model;

import java.util.List;

public class ItemVO {
	int seq;
	String item_code;
	String item_name;
	int item_price;
	String item_corp;
	char item_stat;
	String date;
	int cate_seq;
	String cate;
	private List<FileInfo> fileInfos = null;
	
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_corp() {
		return item_corp;
	}
	public void setItem_corp(String item_corp) {
		this.item_corp = item_corp;
	}
	public char getItem_stat() {
		return item_stat;
	}
	public void setItem_stat(char item_stat) {
		this.item_stat = item_stat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCate_seq() {
		return cate_seq;
	}
	public void setCate_seq(int cate_seq) {
		this.cate_seq = cate_seq;
	}
	public List<FileInfo> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(List<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}
	@Override
	public String toString() {
		return "ItemVO [seq=" + seq + ", item_code=" + item_code + ", item_name=" + item_name + ", item_price="
				+ item_price + ", item_corp=" + item_corp + ", item_stat=" + item_stat + ", date=" + date
				+ ", cate_seq=" + cate_seq + ", cate=" + cate + ", fileInfos=" + fileInfos + "]";
	}
	
	
	
}
