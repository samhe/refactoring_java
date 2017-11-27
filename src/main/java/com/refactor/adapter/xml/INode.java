package com.refactor.adapter.xml;

import java.util.List;

public interface INode {
    void add(INode childNode);

    void addAttribute(String attribute, String value);

    void addValue(String value);

    List children();
}
