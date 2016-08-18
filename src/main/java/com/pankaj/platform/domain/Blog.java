package com.pankaj.platform.domain;

import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by pankajpardasani on 16/07/2016.
 */
public class Blog {
    private Long id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private List<Comments> comments;

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
