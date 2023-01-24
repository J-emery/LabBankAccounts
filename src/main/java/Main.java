import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        var first = new BankAccount("James","Emery", LocalDate.of(1999,04,30),12);

        first.changeAccountType("Savings");
        System.out.println(first.getAccountType());

    }
}