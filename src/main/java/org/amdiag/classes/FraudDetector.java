package org.amdiag.classes;

class FraudDetector {
    private int maxThreshold = 1000000;

    boolean isFraud(Transaction transaction) {
        //Rule1
        Trader trader = transaction.getTrader();
        if(trader.getFullName().equals("Pokemon"))
            return true;

        //Rule2
        if(transaction.getAmount() > maxThreshold)
            return true;


        return false;
    }

    public int getMaxThreshold() {
        return maxThreshold;
    }
}
