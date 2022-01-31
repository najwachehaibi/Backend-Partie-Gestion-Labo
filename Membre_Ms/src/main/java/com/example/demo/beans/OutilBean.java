package com.example.demo.beans;

import java.util.Date;

public class OutilBean {
	private Long id;
    private String source;
	private Date date;
	public OutilBean(Long id, String source, Date date) {
		super();
		this.id = id;
		this.source = source;
		this.date = date;
	}
	public OutilBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
