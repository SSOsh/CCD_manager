package model;

import lombok.Data;

@Data
public class Post {
    private int postID;
    private int forumID;
    private String memberID;
    private String title;
    private String contents;
    private String nickname;
    private String date;

}
