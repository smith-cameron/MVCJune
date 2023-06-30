package com.camerons.springmvc.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tweets")
public class Tweet {
//	Basic class object Attributes ----------------
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
//	Object Specific Attributes ----------------------
	@NotBlank(message="Content Required")
	@Size(min=2, max=255, message="Content must be over 2 characters")
	private String tweetContent;
	@NotNull(message="imaginaryIntAtt Required")
	@Min(value=10, message="imaginaryIntAtt must be over 10")
	private int imaginaryIntAtt;
//	Table Relationship Attributes ------------------------
	
//	Empty Constructor ----------------------------------
	public Tweet() {}
	
	public Tweet(String tweetContent,int imaginaryIntAtt) {
		this.tweetContent = tweetContent;
		this.imaginaryIntAtt = imaginaryIntAtt;
	}
	//	Getters & Setters ------------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTweetContent() {
		return tweetContent;
	}
	public void setTweetContent(String tweetContent) {
		this.tweetContent = tweetContent;
	}
	public int getImaginaryIntAtt() {
		return imaginaryIntAtt;
	}
	public void setImaginaryIntAtt(int imaginaryIntAtt) {
		this.imaginaryIntAtt = imaginaryIntAtt;
	}
	
}
