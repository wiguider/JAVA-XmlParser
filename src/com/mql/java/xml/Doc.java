package com.mql.java.xml;

import java.util.Vector;

public class Doc {
	private String id;
	private String lang;
	private String title;
	private Date date;
	private Vector<Author> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vector<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Vector<Author> authors) {
		this.authors = authors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String toString() {
		return "Document [id=" + id + ", lang=" + lang + ", title=" + title
				+ ", date=" + date + ", authors=" + authors + "]"+"\n";
	}

	public void addAuthor(Author author) {
		authors.add(author);

	}

	public Doc() {
		authors = new Vector<Author>();
	}

}
