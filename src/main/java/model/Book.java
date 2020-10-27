package model;

import lombok.Data;

@Data
public class Book {
    private int BookId;
    private double starRating;
    private String title;
    private String table;
    private String purchaseUrl;
    private String author;
    private String summarize;
    private String bookCoverUrl;
    private String videoUrl;
    private String publisher;
}
