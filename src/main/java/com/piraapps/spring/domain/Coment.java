package com.piraapps.spring.domain;

import java.io.Serializable;
import java.util.Date;

import com.piraapps.spring.dto.AuthorDTO;

public class Coment implements Serializable{
	private static final long serialVersionUID = 1L;

	private String text;
	private Date date;
	private AuthorDTO author;
	
	public Coment() { }
	
	public Coment(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public AuthorDTO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
