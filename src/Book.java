/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class Book {
    private String id;

    private String isbn;

    private String title;

    private Member loanTo;

    public Book(String id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getLoanTo() {
        return loanTo;
    }

    public void setLoanTo(Member loanTo) {
        this.loanTo = loanTo;
    }
}
