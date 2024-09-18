package org.amdiag.classes;

class FraudDetector {

    boolean isFraud(Transaction transaction) {
        Trader trader = transaction.getTrader();
        if(trader.getFullName().equals("Pokemon"))
            return true;
        else return false;
    }
}
