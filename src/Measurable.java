/**
 *  2. Code an interface named Measurable which provides an abstract getMeasure method that returns a float,
 *  then code a class Data with a static method that computes the average of a list of Measurable objects sent in as a parameter.
 *  Modify BankAccount so that it implements Measurable, then in BankAccount’s main method, call Data.average to compute the average of the accounts.
 */

public interface Measurable {
    // method is abstract by default
    float getMeasure();
}
