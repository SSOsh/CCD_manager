import lombok.Data;

@Data
public class BookProgressStatus {
    private String BookName;
    private String Author;
    private String startDay;
    private String finishDay;
    private String Status;
    private String userID;
    private String BookID;

}
