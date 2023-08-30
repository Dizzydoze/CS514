public class BankAccount {
    public float balance;
    public float rate;

    // Constructor 1
    public BankAccount(int balance, float rate){
        this.balance = balance;
        this.rate = rate;
    }
    // Constructor 2 with default parameters
    public BankAccount(float rate){
        this.balance = 0;
        this.rate = rate;
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

    }
}