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

        //Rule3
        if(trader.getCity().equals("Sydney"))
            return true;

        //Rule4
        if(trader.getCountry().equals("Jamaica"))
            return true;

        //Rule5
        if(trader.getCountry().equals("Germany") && transaction.getAmount() > 1000)
            return true;

        return false;
    }

    public int getMaxThreshold() {
        return maxThreshold;
    }
}
