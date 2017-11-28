package com.refactor.adapter.xml;

import java.util.Stack;

public class XMLBuilder extends AbstractBuilder {

	public XMLBuilder(String rootName) {
		super.startNewBuild(rootName);
	}

	protected void init(String rootName) {
		root = new TagNode(rootName);
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public String toString() {
		return root.toString();
	}
}
