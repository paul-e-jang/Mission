package com.sjwp.mission.domain.model.article;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "IMG_NAME", length = 100, nullable = false)
    private String imgName;
    @Column(name = "IMG_SIZE")
    private int imgSize;
    @Column(name = "UPLOADER")
    private String uploader;
    @Column(name = "UPLOADED_TIME")
    private Date uploaded_time;

    public Article() {
    }

    public Article(String imgName, int imgSize, String uploader, Date uploaded_time) {
        this.imgName = imgName;
        this.imgSize = imgSize;
        this.uploader = uploader;
        this.uploaded_time = uploaded_time;
    }



    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public int getImgSize() {
		return imgSize;
	}

	public void setImgSize(int imgSize) {
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

	@Override
    public String toString() {
        return "Course [" +
                "id=" + id +
                ", imgName='" + imgName + '\'' +
                ", imgSize=" + imgSize +
                ", uploader=" + uploader +
                ", uploaded_time=" + uploaded_time +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article course = (Article) o;
        return uploaded_time == course.uploaded_time &&
                Objects.equals(imgName, course.imgName) &&
                Objects.equals(imgSize, course.imgSize) &&
                Objects.equals(uploader, course.uploader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgName, imgSize, uploader, uploaded_time);
    }
}
