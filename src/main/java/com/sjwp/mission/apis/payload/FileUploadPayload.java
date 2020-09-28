package com.sjwp.mission.apis.payload;

import javax.validation.constraints.NotNull;

public class FileUploadPayload {
	@NotNull
	String imgName;
	@NotNull
	String imgSize;
	@NotNull
	String uploader;
	@NotNull
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
	
}
