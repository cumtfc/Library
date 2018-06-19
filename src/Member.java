import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class Member {

    private String id;

    private String name;

    private List<Loan> loans = new ArrayList<>(3);

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void returnBook(Book book) {
        for (Loan loan : loans) {
            Book bookInLoan = loan.getBook();
            if (bookInLoan.getId().equals(book.getId())) {
                bookInLoan.setLoanTo(null);
                System.out.println(LocalDateTime.now() + ":" + getName() + "已归还" + book.getTitle() + "。");
                loan.markAsReturned();
            }
        }
    }

    public boolean canLoan(Book book) {
        if (book.getLoanTo() != null) {
            System.out.println(LocalDateTime.now() + ":" + this.getName() + "尝试借" + book.getTitle() + "失败，这本书已经借出去了。");
            return false;
        }
        HasReachMaxSpecification specification = new HasReachMaxSpecification();
        if (!specification.isSatisfiedBy(this)) {
            return false;
        }
        LoanOnlyOneSpecification loanOnlyOneSpecification = new LoanOnlyOneSpecification(book);
        return loanOnlyOneSpecification.isSatisfiedBy(this);
    }

    public Loan loan(Book book) {
        if (!canLoan(book)) {
            System.out.println(
                LocalDateTime.now() + ":借书前应该检查这本书能不能借+memberName:" + this.getName() + "bookName:" + book.getTitle());
            return null;
        }
        Loan loan = LoanFactory.create(book, this);
        loans.add(loan);
        return loan;
    }

    public Loan findCurrentLoanFor(Book book) {
        Member loanTo = book.getLoanTo();
        if (loanTo == null || !loanTo.getId().equals(this.getId())) {
            return null;
        }
        for (Loan loan : loans) {
            if (loan.getBook().getId().equals(book.getId()) && loan.hasNotBeenReturned()) {
                System.out.println(
                    LocalDateTime.now() + ":" + name + "借了" + book.getTitle() + "，书的id:" + book.getId() + "。");
                return loan;
            }
        }
        System.out.println(
            LocalDateTime.now() + ":" + name + "没有借" + book.getTitle() + "，书的id:" + book.getId() + "。");
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
