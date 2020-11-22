package model;

public class BookStatusProgress {
    private String BookName;
    private String Author;
    private String startDay;
    private String finishDay;
    private String Status;
    private String userID;
    private int BookID;

    public String getBookName() {
        return BookName;
    }
    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }

    public String getStartDay() {
        return startDay;
    }
    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getFinishDay() {
        return finishDay;
    }
    public void setFinishDay(String finishDay) {
        this.finishDay = finishDay;
    }

    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return BookID;
    }
    public void setBookID(int BookID) {
        this.BookID = BookID;
    }
}
