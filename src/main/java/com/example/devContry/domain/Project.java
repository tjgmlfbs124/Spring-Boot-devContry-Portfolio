package com.example.devContry.domain;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;

@Entity
@Table(name="tb_projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // 고유 ID

    private String title;               // 제목
    private String fw;                  // 프레임워크
    private Long views;                 // 조회수

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

    public String getFw() {
        return fw;
    }

    public void setFw(String fw) {
        this.fw = fw;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
