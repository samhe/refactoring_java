package com.refactor.adapter.xml;

import java.util.List;

public interface Node {
    Node add(String name);

    void addAttribute(String attribute, String value);

    void addValue(String value);

    List children();
}
