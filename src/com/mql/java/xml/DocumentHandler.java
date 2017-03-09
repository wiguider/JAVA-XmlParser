package com.mql.java.xml;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DocumentHandler extends DefaultHandler {
	/* Classe utilisée pour gérer les évenement émis par SAX 
	 * lors du traitement du fichier XML
	 */
	// private boolean title = false;
	private String tag = "";
	// private boolean author = false;
	private Doc doc = null;
	private Vector<Doc> documentList;

	public DocumentHandler() {
		documentList = new Vector<Doc>();
	}

	public Vector<Doc> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(Vector<Doc> documentList) {
		this.documentList = documentList;
	}

	public void startDocument() throws SAXException {
		System.out.println(">>Debut analyse");
	}

	public void endDocument() throws SAXException {
		System.out.println(">>Fin analyse");
	}

	public void startElement(String uri, String localName,
			String qualifiedName, Attributes att) throws SAXException {
		// System.out.println(" - "+uri+", "+localName+", "+qualifiedName);
		tag = qualifiedName;
		// if ("title".equals(tag))
		// = true;
		// else
		if ("document".equals(qualifiedName)) {
			doc = new Doc();
			// for (int i = 0; i < att.getLength(); i++) {
			// System.out.println("- "+att.getQName(i)+" = "+att.getValue(i));
			//
			// }
			//
			doc.setId(att.getValue("id"));
			doc.setLang(att.getValue("lang"));

		} else if ("date".equals(qualifiedName)) {
			Date d = new Date(Integer.parseInt(att.getValue("day")),
					Integer.parseInt(att.getValue("month")),
					Integer.parseInt(att.getValue("year")));
			doc.setDate(d);
		}
		/*
		 * else if ("author".equals(qualifiedName)) { tag = qualifiedName;//
		 * author = true; }
		 */
	}

	public void endElement(String uri, String localName, String qualifiedName)
			throws SAXException {
		// if ("title".equals(qualifiedName))
		// title = false;
		//
		if ("document".equals(qualifiedName)) {

			documentList.add(doc);
			doc = null;
		}
		// else if ("author".equals(qualifiedName)) {
		// author = false;
		// }
		tag = "";
	}

	public void characters(char[] characters, int start, int lenght)
			throws SAXException {
		String info = new String(characters, start, lenght);
		if ("title".equals(tag))
			// System.out.println(info);
			doc.setTitle(info);
		else if ("author".equals(tag)) {
			doc.addAuthor(new Author(info));
		}
	}

	public void processingInstruction(String arg0, String arg1)
			throws SAXException {

	}

}
