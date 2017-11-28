package com.refactor.adapter.xml;

import java.util.List;

public interface Node {
    void add(Node childNode);

    void addAttribute(String attribute, String value);

    void addValue(String value);

    List children();
}
