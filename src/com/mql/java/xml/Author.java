package com.mql.java.xml;

public class Author {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return  name ;
	}

	public Author() {
		super();
	}

	public Author(String name) {
		super();
		this.name = name;
	}
}
