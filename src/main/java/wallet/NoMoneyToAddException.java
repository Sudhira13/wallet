package wallet;

public class NoMoneyToAddException extends Exception {
    public NoMoneyToAddException(String message) {
        super(message);
    }
}
