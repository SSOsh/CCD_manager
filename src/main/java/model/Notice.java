package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Notice {
    @Getter
    @Setter
    private int noticeID;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String contents;
    @Getter
    @Setter
    private String date;
}
