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

    public Element getElement() {
        return element;
    }

    @Override
    public void add(INode childNode) {
        element.appendChild(((INodeAdaptorImplDOM) childNode).getElement());
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
