package com.refactor.adapter.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;


public class ElementAdapter implements Node {
    Document doc;
    Element element;

    public ElementAdapter(Document doc, Element element) {
        this.doc = doc;
        this.element = element;
    }

    @Override
    public Node add(String name) {
        Element newElement = doc.createElement(name);
        element.appendChild(newElement);
        return new ElementAdapter(doc, newElement);
    }

    @Override
    public void addAttribute(String attribute, String value) {
        element.setAttribute(attribute, value);
    }

    @Override
    public void addValue(String value) {
        element.appendChild(doc.createTextNode(value));
    }

    /**
     * NOTES: Not implement the method yet, is it an potential risk in adapter pattern ??
     */
    @Override
    public List children() {
        throw new UnsupportedOperationException();
    }
}