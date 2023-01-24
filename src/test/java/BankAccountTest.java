import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp(){
        account = new BankAccount("James", "Emery", LocalDate.of(1982,07,28),12);
    }

// Testing Getters
    @Test
    void testGetName(){
        assertThat(account.getName()).isEqualTo("James Emery");
    }
    @Test
    void testGetDateOfBirth(){
        assertThat(account.getDateOfBirth()).isEqualTo(LocalDate.of(1982,07,28));
    }
    @Test
    void testGetAccountNumber(){
        assertThat(account.getAccountNumber()).isEqualTo(12);
    }
    @Test
    void testGetBalance(){
        assertEquals(account.getBalance(),0,0.01);
    }
    @Test
    void testGetInterest(){
        assertThat(account.getInterest()).isEqualTo(0.01D);
    }
    @Test
    void testGetAccountType(){
        account.changeAccountType("Savings");
        assertThat(account.getAccountType()).isEqualTo("Savings");
    }
    @Test
    void testGetOverdraft(){
        assertThat(account.getOverdraft()).isEqualTo(0);
    }

//Testing Setters
    @Test
    void testChangeName(){
        account.changeName("Fred","Big");
        assertThat(account.getName()).isEqualTo("Fred Big");
    }
    @Test
    void testChangeDOB(){
        LocalDate now = LocalDate.now();
        account.changeDOB(now);
        assertThat(account.getDateOfBirth()).isEqualTo(now);
    }
    @Test
    void testChangeInterest(){
        account.changeInterest(0.1);
        assertThat(account.getInterest()).isEqualTo(0.1);
    }
    @Test
    void testChangeOverdraft(){
        account.changeOverdraft(200D);
        assertThat(account.getOverdraft()).isEqualTo(200);
    }

//Testing other methods
    @Test
    void testDeposit(){
        account.deposit(200D);
        assertEquals(account.getBalance(),200,0.01);
    }
    @Test
    void testSuccessfulDeposit(){
        account.deposit(200D);
        account.withdrawal(200D);
        assertEquals(account.getBalance(),0,0.01);
    }
    @Test
    void testUnsuccessfulDeposit(){
        account.deposit(100D);
        account.withdrawal(200D);
        assertEquals(account.getBalance(),100,0.01);
    }
    @Test
    void testInterestAccrual(){
        account.deposit(500D);
        account.changeInterest(0.1);
        account.accrueInterest();
        assertEquals(account.getBalance(),500+0.1*500,0.01);
    }
}
