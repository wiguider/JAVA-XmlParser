package com.mql.java.xml;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlNode {
	private Node node;

	public XmlNode(Node node) {

		this.node = node;
	}

	public XmlNode(String source) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(source);
			node = doc.getFirstChild();
			// System.out.println(n.getNodeName());
			// System.out.println(n.getNodeValue());
			// System.out.println(n.getNodeType());
			// System.out.println(Node.COMMENT_NODE);
			while (node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
			}
			Node root = node;
			System.out.println(root.getNodeName());
		} catch (Exception e) {
			System.out.println("Erreur: " + e.getMessage());

		}

	}

	public String getName() {
		return node.getNodeName();
	}

	public boolean isElement() {
		return (node.getNodeType() == Node.ELEMENT_NODE);
	}

	public boolean isText() {
		return (node.getNodeType() == Node.TEXT_NODE);
	}

	public String getValue() {
		if (isText())
			return node.getNodeValue();
		else if (isElement())
			return node.getTextContent();
		return "";
	}

	public XmlNode[] getElementChildren() {
		// node.getFirstChild();
		NodeList nodeList = node.getChildNodes();
		Vector<XmlNode> n = new Vector<XmlNode>();

		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				n.add(new XmlNode(nodeList.item(i)));
			}

		}
		XmlNode t[]=new XmlNode[n.size()];
		for (int i = 0; i < t.length; i++) {
			t[i]=n.get(i);
		}
		return t;
	}
	public String getAttributeValue(String name){
		NamedNodeMap map = node.getAttributes();
		return map.getNamedItem(name).getNodeValue();
		
	}
	public String getAttributeValue(int index){
		NamedNodeMap map = node.getAttributes();
		return map.item(index).getNodeValue();
		
	}
	public int getAttributesCount(){
		NamedNodeMap map = node.getAttributes();
		return map.getLength();
		
	}
	public XmlNode[] getChildren() {

		NodeList nodeList = node.getChildNodes();
		XmlNode[] xmlNode = new XmlNode[nodeList.getLength()];
		for (int i = 0; i < nodeList.getLength(); i++) {

			xmlNode[i] = new XmlNode(nodeList.item(i));

		}

		return xmlNode;
	}

}
