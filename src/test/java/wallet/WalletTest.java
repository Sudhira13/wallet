package wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    void shouldAddMoneyToTheWallet() {
        Money money = new Money(Currency.DOLLAR,1);
        Wallet wallet = new Wallet(money).add(new Money(Currency.RUPEE,1));
        assertEquals(75.85,wallet.money.amount);
    }

}
