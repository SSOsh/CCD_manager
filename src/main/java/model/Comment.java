package model;

import lombok.Data;

@Data
public class Comment {
    private int commentID;
    private int postID;
    private String memdberID;
    private String TEXT;
    private String date;

}
