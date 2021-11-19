package com.ssafy.hw2.model;

public class FileInfo {
	int seq;
	int photo_seq;
	String file_name;
	String file_path_org;
	String file_path_thumb;
	long file_size;
	char stat_view;
	String dt_reg;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getPhoto_seq() {
		return photo_seq;
	}
	public void setPhoto_seq(int photo_seq) {
		this.photo_seq = photo_seq;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path_org() {
		return file_path_org;
	}
	public void setFile_path_org(String file_path_org) {
		this.file_path_org = file_path_org;
	}
	public String getFile_path_thumb() {
		return file_path_thumb;
	}
	public void setFile_path_thumb(String file_path_thumb) {
		this.file_path_thumb = file_path_thumb;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public char getStat_view() {
		return stat_view;
	}
	public void setStat_view(char stat_view) {
		this.stat_view = stat_view;
	}
	public String getDt_reg() {
		return dt_reg;
	}
	public void setDt_reg(String dt_reg) {
		this.dt_reg = dt_reg;
	}
	@Override
	public String toString() {
		return "FileInfo [seq=" + seq + ", photo_seq=" + photo_seq + ", file_name=" + file_name + ", file_path_org="
				+ file_path_org + ", file_path_thumb=" + file_path_thumb + ", file_size=" + file_size + ", stat_view="
				+ stat_view + ", dt_reg=" + dt_reg + "]";
	}
	
	
}
