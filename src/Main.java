import java.time.LocalDateTime;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("001","isbnJava","《Java从入门到放弃》");
        Book book2 = new Book("002","isbnPm","《如何与程序员和谐相处-PM的自我修养》");
        Book book3 = new Book("003","isbnPmPro","《活着》");
        Book book4 = new Book("004","isbnSwift","《Life is short.I use python》");
        Book book5 = new Book("005","isbnSwift","《Life is short.I use python》");

        Member member1 = new Member("01","测试娃娃1");
        Member member2 = new Member("02","测试娃娃2");

        System.out.println(LocalDateTime.now()+":member1尝试借book1");
        if (member1.canLoan(book1)) {
            member1.loan(book1);
        }
        System.out.println(LocalDateTime.now()+":member1再尝试借book1");
        if (member1.canLoan(book1)) {
            member1.loan(book1);
        }
        System.out.println(LocalDateTime.now()+":member1还book1");
        member1.returnBook(book1);

        System.out.println(LocalDateTime.now()+":member2借book2");
        if (member2.canLoan(book2)) {
            member2.loan(book2);
        }
        System.out.println(LocalDateTime.now()+":member2借book3");
        if (member2.canLoan(book3)) {
            member2.loan(book3);
        }
        System.out.println(LocalDateTime.now()+":member2借book4");
        if (member2.canLoan(book4)) {
            member2.loan(book4);
        }
        System.out.println(LocalDateTime.now()+":member2借book5");
        if (member2.canLoan(book5)) {
            member2.loan(book5);
        }
        System.out.println(LocalDateTime.now()+":member2还book2");
        member2.returnBook(book2);

        System.out.println(LocalDateTime.now()+":member2再借book5");
        if (member2.canLoan(book5)) {
            member2.loan(book5);
        }

        System.out.println(member1.findCurrentLoanFor(book4));
        System.out.println(member2.findCurrentLoanFor(book4));
    }
}
