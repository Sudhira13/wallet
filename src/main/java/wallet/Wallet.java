package wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    public final List<Money> myWallet = new ArrayList<>();

    public void addMoney(Money money) throws NoMoneyToAddException {
        if(money.amount<0) throw new NoMoneyToAddException("Please add money!");
        myWallet.add(money);
        System.out.println(myWallet);
    }

    public boolean withDrawMoney(Money money) throws InvalidAmountException {
        if(!myWallet.contains(money)) throw new InvalidAmountException("Amount is not in the wallet!");
        return myWallet.remove(money);
    }

    public double getTotalAmount(Money money, CurrencyType preferredCurrency){
        if(preferredCurrency == CurrencyType.RUPEE){
            return money.convertIntoRupee(myWallet);
        }else{
            return money.convertIntoDollar(myWallet);
        }
    }

}