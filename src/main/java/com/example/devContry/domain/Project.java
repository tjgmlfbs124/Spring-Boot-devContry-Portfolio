package com.example.devContry.domain;

import java.awt.*;
import java.util.ArrayList;

public class Project {
    private Long id;                    // 고유 ID
    private String title;               // 제목
    private String content;             // 내용
    private String fw;                  // 프레임워크
    private ArrayList<String> images;   // 이미지 경로

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getFw() {
        return fw;
    }

    public void setFw(String fw) {
        this.fw = fw;
    }
}
