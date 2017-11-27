package com.refactor.adapter.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class INodeAdaptorImplDOM implements INode {
    private Document doc;
    private Element element;

    public INodeAdaptorImplDOM(Document doc, Element element) {
        this.doc = doc;
        this.element = element;
    }

    @Override
    public INode add(String child) {
        Element childElement = doc.createElement(child);
        element.appendChild(childElement);
        INode childNode = new INodeAdaptorImplDOM(doc, childElement);
        return childNode;
    }

    @Override
    public void addAttribute(String attribute, String value) {
        element.setAttribute(attribute, value);
    }

    @Override
    public void addValue(String value) {
        element.appendChild(doc.createTextNode(value));
    }

    @Override
    public List children() {
        throw new UnsupportedOperationException();
    }

}
