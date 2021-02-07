package wallet;

import java.util.List;

public class Money {
    private final CurrencyType type;
    public double amount;
    private double sum = 0;

    public Money(CurrencyType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public double convertIntoRupee(List<Money> wallet){
        for (Money money : wallet) {
            if(money.type == CurrencyType.DOLLAR){
                sum += money.amount*74.5;
            }
            else{
                sum += money.amount;
            }
        }
        return sum;
    }

    public double convertIntoDollar(List<Money> wallet){
        for (Money money : wallet) {
            if(money.type == CurrencyType.RUPEE){
                sum += money.amount/74.5;
            }
            else{
                sum += money.amount;
            }
        }
        return sum;
    }

}
