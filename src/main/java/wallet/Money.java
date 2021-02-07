package wallet;


public class Money {
    private final Currency type = Currency.RUPEE;
    public double amount;

    public Money(Currency type, double amount) {
        this.amount = type.convertToRupees(amount);
    }

}
