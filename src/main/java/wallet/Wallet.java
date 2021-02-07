package wallet;

public class Wallet {
    public final Money money;

    public Wallet(Money money) {
        this.money = money;
    }

    public Wallet add(Money money){
        double amount = this.money.amount + money.amount;
        Money newMoney = new Money(Currency.RUPEE, amount);
        return new Wallet(newMoney);
    }

    public  Wallet withDraw(Money money) throws NotEnoughMoneyException {
        if(this.money.amount<money.amount) throw new NotEnoughMoneyException();
        double balance = this.money.amount - money.amount;
        Money newMoney = new Money(Currency.RUPEE, balance);
        return new Wallet(newMoney);
    }
}