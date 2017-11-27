package com.refactor.adapter.xml;

import java.util.List;

public interface INode {
    INode add(String child);

    void addAttribute(String attribute, String value);

    void addValue(String value);

    List children();
}
