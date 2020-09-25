package com.sjwp.mission.apis.payload;

import java.util.Date;

public class FileUploadPayload {
	String imgName;
	String imgSize;
	String uploader;
	Date uploaded_time;
	String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgSize() {
		return imgSize;
	}
	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public Date getUploaded_time() {
		return uploaded_time;
	}
	public void setUploaded_time(Date uploaded_time) {
		this.uploaded_time = uploaded_time;
	}
	
}
