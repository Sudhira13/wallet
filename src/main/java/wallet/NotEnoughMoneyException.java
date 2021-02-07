package wallet;

public class NotEnoughMoneyException extends Throwable {
    public NotEnoughMoneyException() {
        super("There is not enough money in the wallet!");
    }
}
