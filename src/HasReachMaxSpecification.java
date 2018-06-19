import java.time.LocalDateTime;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class HasReachMaxSpecification implements Specification<Member> {

    @Override
    public boolean isSatisfiedBy(Member member) {
        int max = 3;
        boolean b = member.getLoans().stream().filter(Loan::hasNotBeenReturned).count() < max;
        if (!b) {
            System.out.println(LocalDateTime.now()+":"+member.getName()+"借书已达到上限"+max+"本。");
        }
        return b;
    }
}
