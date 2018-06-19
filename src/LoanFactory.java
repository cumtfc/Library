import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class LoanFactory {
    public static Loan create(Book book, Member member) {
        book.setLoanTo(member);
        Loan loan = new Loan();
        loan.setId(UUID.randomUUID().toString());
        loan.setBook(book);
        loan.setLoanDate(LocalDateTime.now());
        loan.setMember(member);
        System.out.println(LocalDateTime.now()+":借书成功");
        return loan;
    }
}
