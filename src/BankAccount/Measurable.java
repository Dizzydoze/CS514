package BankAccount;

/**
 *  2. Code an interface named BankAccount.Measurable which provides an abstract getMeasure method that returns a float,
 *  then code a class BankAccount.Data with a static method that computes the average of a list of BankAccount.Measurable objects sent in as a parameter.
 *  Modify BankAccount.BankAccount so that it implements BankAccount.Measurable, then in BankAccount.BankAccount’s main method, call BankAccount.Data.average to compute the average of the accounts.
 */

public interface Measurable {
    // method is abstract by default
    float getMeasure();
}
