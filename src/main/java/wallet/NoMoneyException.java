package wallet;

public class NoMoneyException extends Exception {
    public NoMoneyException(String message) {
        super(message);
    }
}
