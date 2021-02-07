package wallet;

public class Wallet {
    public Money money;

    public Wallet(Money money) {
        this.money = money;
    }

    public Wallet add(Money money){
        double amount = this.money.amount + money.amount;
        Money newMoney = new Money(Currency.RUPEE, amount);
        return new Wallet(newMoney);
    }
}