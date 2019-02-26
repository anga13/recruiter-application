package se.kth.iv1201.grupp13.recruiterapplication.domain;

/**
 * Thrown whenever an attempt is made to perform a transaction that is not
 * allowed by the recruiter system's business rules.
 */
public class IllegalRecruiterTransactionException extends Exception {
    /**
     * Creates a new instance with the specified message.
     *
     * @param msg A message explaining why the exception is thrown.
     */
    public IllegalRecruiterTransactionException(String msg) {
        super(msg);
    }

}

