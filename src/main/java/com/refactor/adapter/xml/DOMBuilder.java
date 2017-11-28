package com.refactor.adapter.xml;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Stack;

public class DOMBuilder extends AbstractBuilder {
	private Document doc;

	public DOMBuilder(String rootName) {
		startNewBuild(rootName);
	}

	public Document getDocument() {
		return doc;
	}

	@Override
	protected void init(String rootName) {
		doc = new DocumentImpl();
		Element rootElement = doc.createElement(rootName);
		doc.appendChild(rootElement);
		ElementAdapter elementAdapter = new ElementAdapter(doc, rootElement);
		root = elementAdapter;
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public String toString() {
		OutputFormat format = new OutputFormat(doc);
		StringWriter stringOut = new StringWriter();
		XMLSerializer serial = new XMLSerializer(stringOut, format);
		try {
			serial.asDOMSerializer();
			serial.serialize(doc.getDocumentElement());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return ioe.getMessage();
		}
		return stringOut.toString();
	}
}
