package com.atguigu.dto;

import java.util.ArrayList;
import java.util.List;

public class Album {

    public Album() {
    }

    public Album(String name, String mainMusician) {
        this.name = name;
        this.mainMusician = mainMusician;
    }

    public Album(String name, String mainMusician, List<Track> trackList) {
        this.name = name;
        this.mainMusician = mainMusician;
        this.trackList = trackList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainMusician() {
        return mainMusician;
    }

    public void setMainMusician(String mainMusician) {
        this.mainMusician = mainMusician;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    private String name;

    private String mainMusician;

    private List<Track> trackList = new ArrayList<>();




}
