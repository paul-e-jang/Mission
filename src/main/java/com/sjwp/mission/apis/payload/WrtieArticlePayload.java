package com.sjwp.mission.apis.payload;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class WrtieArticlePayload {

  @NotNull
  private String imgName;
  
  @NotNull
  private String imgSize;

  @NotNull
  private String uploader;

  @NotNull
  private Date uploaded_time;

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
