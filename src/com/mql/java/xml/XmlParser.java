package com.mql.java.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlParser {

	public XmlParser() {
		domParser2();
	}

	void saxParser() {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			DocumentHandler documentHandler = new DocumentHandler();
			parser.parse("resources/xml/documents.xml", documentHandler);
			System.out.println(documentHandler.getDocumentList());
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	void domParser() {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("resources/xml/documents.xml");
			Node n = doc.getFirstChild();
			System.out.println(n.getNodeName());
			System.out.println(n.getNodeValue());
			System.out.println(n.getNodeType());
			System.out.println(Node.COMMENT_NODE);
			while(n.getNodeType()!=Node.ELEMENT_NODE){
				n=n.getNextSibling();
			}
			Node root =n;
			System.out.println(root.getNodeName());
		} catch (Exception e) {

		}

	}
	void domParser2() {
		XmlNode n=new XmlNode("resources/xml/documents.xml");
		XmlNode f[]=n.getElementChildren();
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i].getName()/*+":"+ f[i].getValue()*/);
			XmlNode pf[]=f[i].getElementChildren();
			for (int j = 0; j < pf.length; j++) {
//				System.out.println(pf[j].getName()/*+":"+ f[i].getValue()*/);
				if("title".equals(pf[j].getName())){
					System.out.println(pf[j].getValue());
				}else if(pf[j].getName().equals("date")){
					System.out.print(pf[j].getAttributeValue("day")+"/");
					System.out.print(pf[j].getAttributeValue("month")+"/");
					System.out.println(pf[j].getAttributeValue("year"));
				}else if(pf[j].getName().equals("authors")){
					for (int c = 0; c < pf[j].getElementChildren().length; c++) {
						System.out.println(pf[j].getElementChildren()[c].getValue());	
					}
					
				}
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		new XmlParser();
	}

}
