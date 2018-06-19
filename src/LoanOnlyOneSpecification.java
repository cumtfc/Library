import java.time.LocalDateTime;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class LoanOnlyOneSpecification implements Specification<Member> {

    private Book wantBook;

    public LoanOnlyOneSpecification(Book wantBook) {
        this.wantBook = wantBook;
    }

    @Override
    public boolean isSatisfiedBy(Member member) {
        boolean b = member.getLoans()
            .stream()
            .noneMatch(loan -> loan.hasNotBeenReturned() && loan.getBook().getIsbn().equals(wantBook.getIsbn()));
        if (!b) {
            System.out.println(LocalDateTime.now() + ":" + member.getName() + "已经借了1本" + wantBook.getTitle() + "不能再借。");
        }
        return b;
    }
}
