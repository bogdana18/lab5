import org.example.BankAccount;
import org.example.InsufficientFundsException;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testWithdraw() throws Exception {
        BankAccount account = new BankAccount(1, "John Doe", 100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());

        try {
            account.withdraw(150.0);
            fail("Expected InsufficientFundsException");
        } catch (InsufficientFundsException e) {
            assertEquals("Insufficient funds", e.getMessage());
        }
    }
}
