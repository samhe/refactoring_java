package com.refactor.adapter.xml;

import java.util.Stack;

public class XMLBuilder extends AbstractBuilder {
	private INode root;
	private INode parent;
	private INode current;

	public XMLBuilder(String rootName) {
		init(rootName);
	}

	protected void init(String rootName) {
		root = createNode(rootName);
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public void startNewBuild(String rootName) {
		init(rootName);
	}

	public String toString() {
		return root.toString();
	}

	@Override
	protected INode createNode(String child) {
		return new TagNode(child);
	}

}
