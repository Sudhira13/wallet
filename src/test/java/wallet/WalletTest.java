package wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    void shouldBeAbleToAddMoneyToTheWallet() {
        Wallet wallet = new Wallet();
        Money money = new Money(CurrencyType.RUPEE, 50);
        assertDoesNotThrow(()->wallet.addMoney(money));
    }


    @Test
    void shouldReturnTotalAmountInTheWallet() throws NoMoneyToAddException {
        Wallet wallet = new Wallet();
        Money money = new Money(CurrencyType.RUPEE,100);
        wallet.addMoney(money);
        Money money_one = new Money(CurrencyType.RUPEE,150);
        wallet.addMoney(money_one);
        double totalAmount = wallet.getTotalAmount(money,CurrencyType.RUPEE);
        assertEquals(250,totalAmount);
    }

    @Test
    void shouldReturnTotalAmountIfThePreferredCurrencyIsRupees() throws NoMoneyToAddException {
        Wallet wallet = new Wallet();
        Money money = new Money(CurrencyType.RUPEE,50);
        wallet.addMoney(money);
        Money money_one = new Money(CurrencyType.DOLLAR,1);
        wallet.addMoney(money_one);
        double totalAmount = wallet.getTotalAmount(money_one,CurrencyType.RUPEE);
        assertEquals(124.5,totalAmount,0.001);
    }

    @Test
    void shouldReturnTotalAmountIfThePreferredCurrencyIsDollars() throws NoMoneyToAddException {
        Wallet wallet = new Wallet();
        Money rupeeMoney = new Money(CurrencyType.RUPEE, 180.85);
        wallet.addMoney(rupeeMoney);
        Money dollarMoney = new Money(CurrencyType.DOLLAR,1);
        wallet.addMoney(dollarMoney);
        double totalAmount = wallet.getTotalAmount(dollarMoney,CurrencyType.DOLLAR);
        assertEquals(3.42,totalAmount,0.01);
    }
}
