package org.amdiag.classes.fraudRule;

import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule4 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        Trader trader = transaction.getTrader();
        //Rule4
        //If the trader is from Jamaica, then the transaction is fraud
        return trader.getCountry().equals("Jamaica");
    }
}
