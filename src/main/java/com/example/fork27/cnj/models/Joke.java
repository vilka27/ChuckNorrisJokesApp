package com.example.fork27.cnj.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class Joke {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @NonNull
    private String id;

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("icon_url")
    @Expose
    private String icon;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {

        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
