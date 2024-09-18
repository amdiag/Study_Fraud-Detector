package org.amdiag.classes.fraudRule;

import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule5 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        Trader trader = transaction.getTrader();
        //Rule5
        //If the country of the trader is Germany and the transaction amount is greater than 1000, transaction is fraud
        return trader.getCountry().equals("Germany") && transaction.getAmount() > 1000;
    }
}
