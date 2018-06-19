import java.time.LocalDateTime;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class Loan {

    private String id;

    private LocalDateTime loanDate;

    private LocalDateTime returnDate;

    private Book book;

    private Member member;

    public boolean hasNotBeenReturned() {
        return returnDate == null;
    }

    public void markAsReturned() {
        this.returnDate = LocalDateTime.now();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
