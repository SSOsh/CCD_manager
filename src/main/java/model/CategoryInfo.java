package model;

import lombok.Data;

@Data
public class CategoryInfo {
    //2020-11-20 승환 앞에 c 소문자로 바꾸고 categoryID 추가 했음. PK
    private String categoryID; //DB에서 AI 아님
    private String categoryName;
    private String categoryDepth1;
    private String categoryDepth2;
    private String categoryDepth3;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDepth1() {
        return categoryDepth1;
    }

    public void setCategoryDepth1(String categoryDepth1) {
        this.categoryDepth1 = categoryDepth1;
    }

    public String getCategoryDepth2() {
        return categoryDepth2;
    }

    public void setCategoryDepth2(String categoryDepth2) {
        this.categoryDepth2 = categoryDepth2;
    }

    public String getCategoryDepth3() {
        return categoryDepth3;
    }

    public void setCategoryDepth3(String categoryDepth3) {
        this.categoryDepth3 = categoryDepth3;
    }
}
