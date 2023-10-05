import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. Modify your BankAccount class so that it implements Comparable<BankAccount>
 *    Add code in the main that compares two bank accounts using compareTo,
 *    and add code in the main that creates a list of three BankAccount objects,
 *    sorts them, and prints the sorted list.
 */


public class BankAccount implements Comparable<BankAccount>, Measurable{
    public float balance;
    public float rate;

    // Constructor 1
    public BankAccount(float balance, float rate){
        this.balance = balance;
        this.rate = rate;
    }
    // Constructor 2 with default parameters
    public BankAccount(float rate){
        this.balance = 0;
        this.rate = rate;
    }

    @Override
    public int compareTo(BankAccount bankAccount) {
        if (this.balance == bankAccount.balance){
            return 0;
        }
        else if (this.balance > bankAccount.balance){
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public float getMeasure() {
        return this.balance;
    }

    public void processYear(){

        float interest = this.balance * this.rate;
        this.balance = this.balance + interest;

    }

    public void processNYear(int n){
        int i = 0;
        while (i < n) {
            this.processYear();
            i ++;
        }
        System.out.println("balance after " + n + " years is: " + this.balance);
    }

    public static void main(String [] args) {

        BankAccount account = new BankAccount(1000, 1f);
        // n years
        int n = 5;
        account.processNYear(n);

        // Comparable implementation
        List<BankAccount> list1 = new ArrayList<>();
        float rate = .1f;
        list1.add(new BankAccount(800.0f, rate));
        list1.add(new BankAccount(500.0f, rate));
        list1.add(new BankAccount(300.0f, rate));

        Collections.sort(list1);
        for (BankAccount bankAccount : list1) {
            System.out.println(bankAccount.balance);
        }

        // Measurable Implementation
        List<Measurable> list2 = new ArrayList<>();
        list2.add(new BankAccount(550.0f, rate));
        list2.add(new BankAccount(150.0f, rate));
        list2.add(new BankAccount(200.0f, rate));
        System.out.println(Data.average1(list2));

        // Generics
        System.out.println(Data.average2(list1));
    }
}