package com.refactor.adapter.xml;

import java.util.Stack;

public abstract class AbstractBuilder implements OutputBuilder {
	static final protected String CANNOT_ADD_ABOVE_ROOT = "Cannot add node above the root node.";
	static final protected String CANNOT_ADD_BESIDE_ROOT = "Cannot add node beside the root node.";
	protected Stack history = new Stack();
	protected INode root;
	protected INode parent;
	protected INode current;

	public void addAbove(String uncle) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		boolean atRootNode = (history.size() == 1);
		if (atRootNode)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		current = (INode) history.peek();
		addBelow(uncle);
	}

	public void addGrandfather(String grandfather) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		boolean atRootNode = (history.size() == 1);
		if (atRootNode)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		history.pop();
		current = (INode) history.peek();
		addBelow(grandfather);
	}

	public void addAttribute(String name, String value) {
		current.addAttribute(name, value);
	}

	public void addBelow(String child) {
		INode childNode = current.add(child);
		parent = current;
		current = childNode;
		history.push(current);
	}

	public void addBeside(String sibling) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
		INode siblingNode = parent.add(sibling);
		current = siblingNode;
		history.pop();
		history.push(current);
	}

	public void addValue(String value) {
		current.addValue(value);
	}

	public void startNewBuild(String rootName) {
		init(rootName);
	}

	protected abstract void init(String rootName);

//	protected abstract INode createNode(String child);
}
