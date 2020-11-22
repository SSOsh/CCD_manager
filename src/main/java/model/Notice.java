package model;

import lombok.Data;

@Data
public class Notice {
    private int noticeID;
    private String title;
    private String contents;
    private String division; //20-11-20 승환 공지사항 구분 추가했어유
    private String date;

    public int getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(int noticeID) {
        this.noticeID = noticeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDivision(){
        return division;
    }

    public void setDivision(String division){
        this.division = division;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
