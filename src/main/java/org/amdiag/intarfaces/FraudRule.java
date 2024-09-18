package org.amdiag.intarfaces;

import org.amdiag.classes.Transaction;

public interface FraudRule {
    boolean isFraud(Transaction transaction);
}
