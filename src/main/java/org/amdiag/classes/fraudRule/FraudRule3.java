package org.amdiag.classes.fraudRule;

import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule3 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        Trader trader = transaction.getTrader();
        //Rule3
        //If the trader is from Sydney, then the transaction is fraud
        return trader.getCity().equals("Sydney");
    }
}
