package com.digitalhouse.a0818moacn01_02.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopChartDeezer {

    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
