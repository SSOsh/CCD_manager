package model;

import lombok.Data;

@Data
public class Member {
    private String memberID;
    private String memberPW;
    private String name;
    private String nickname;
    private String address;

    public Member() {

    }

    public Member(String memberID, String memberPW) {
        this.memberID = memberID;
        this.memberPW = memberPW;
    }

    public Member(String memberID, String memberPW, String name, String nickname, String address) {
        this.memberID = memberID;
        this.memberPW = memberPW;
        this.name = name;
        this.nickname = nickname;
        this.address = address;
    }


    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberPW() {
        return memberPW;
    }

    public void setMemberPW(String memberPW) {
        this.memberPW = memberPW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

