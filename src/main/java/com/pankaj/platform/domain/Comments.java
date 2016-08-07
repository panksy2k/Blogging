package com.pankaj.platform.domain;

/**
 * Created by pankajpardasani on 16/07/2016.
 */
public class Comments {
    private Long commentID;
    private String comment;
    private String userName;

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
