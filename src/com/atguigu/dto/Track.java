package com.atguigu.dto;

public class Track{

    public Track() {
    }

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public Track(String name, String mainMusician, Integer length) {
        this.name = name;
        this.length = length;
    }

    private String name;

    private Integer length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
