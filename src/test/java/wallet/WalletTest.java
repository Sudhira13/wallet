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

    @Test
    void shouldWithDrawMoneyFromTheWallet() throws NotEnoughMoneyException {
        Money money = new Money(Currency.DOLLAR,5);
        Wallet wallet = new Wallet(money).withDraw(new Money(Currency.RUPEE, 1));
        assertEquals(373.25,wallet.money.amount);
    }

    @Test
    void shouldThrowExceptionIfNotEnoughMoneyInTheWallet(){
        Money money = new Money(Currency.RUPEE,200);
        Wallet wallet = new Wallet(money);
        assertThrows(NotEnoughMoneyException.class,() -> wallet.withDraw(new Money(Currency.RUPEE, 250)));
    }

    @Test
    void shouldReturnTotalAmountForPreferredCurrencyDollar(){
        Money money = new Money(Currency.RUPEE, 299.4);
        Wallet wallet = new Wallet(money);
        double totalAmount = wallet.getTotal(Currency.DOLLAR);
        assertEquals(4,totalAmount);
    }

    @Test
    void shouldReturnTotalAmountForPreferredCurrencyRupee(){
        Money money = new Money(Currency.DOLLAR, 4);
        Wallet wallet = new Wallet(money);
        double totalAmount = wallet.getTotal(Currency.RUPEE);
        assertEquals(299.4,totalAmount);
    }

}
