package model;

import lombok.Data;

@Data
public class Comment {
    private int commentID;
    private int postID;
    private String memdberID;
    private String TEXT;
    private String date;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getMemdberID() {
        return memdberID;
    }

    public void setMemdberID(String memdberID) {
        this.memdberID = memdberID;
    }

    public String getTEXT() {
        return TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
