package week_7.class_problems;

class Bank {
    private int savings;
    private final String id;

    Bank(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(int amount) {
        savings = savings + amount;
    }

    void withdraw(int amount) {
        if (amount <= savings) {
            savings = savings - amount;
        }
    }

    int getSavings() {
        return savings;
    }
}

public class PiggyBank {
    public static void main(String[] args) {

        Bank pb = new Bank("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}