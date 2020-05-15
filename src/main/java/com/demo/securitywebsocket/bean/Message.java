package com.demo.securitywebsocket.bean;

/**
 * @author: 邹玉玺
 * @date: 2020/5/10-14:29
 */
public class Message {
    private String name;
    private  String content;

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
