package model;

import lombok.Data;

@Data
public class Like {
    private int likeID;
    private int likeStatus;
    private String memberID;
    private int bookID;

    public int getLikeID() { return likeID; }
    public int getLikeStatus() { return likeStatus; }
    public String getMemberID() { return memberID; }
    public int getBookID() { return bookID; }

    public void setLikeID(int likeID) { this.likeID = likeID; }
    public void setLikeStatus(int likeStatus) { this.likeStatus = likeStatus; }
    public void setMemberID(String memberID) { this.memberID = memberID; }
    public void setBookID(int bookID) { this.bookID = bookID; }
}
