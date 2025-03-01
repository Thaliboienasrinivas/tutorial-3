class BankAccount {
    private String accountHolder;
    private double balance;        
    protected String accountType;  
    public int accountNumber;      

    BankAccount(String accountHolder, double balance, String accountType, int accountNumber) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    
    public void viewBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

   
    protected void updateAccountType(String newType) {
        this.accountType = newType;
        System.out.println("Account Type Updated to: " + accountType);
    }

   
    private void updateBalance(double newBalance) {
        this.balance = newBalance;
        System.out.println("Balance Updated to: $" + balance);
    }

    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " Deposited Successfully");
        viewBalance();
    }

   
    public void adminUpdateBalance(double newBalance) {
        updateBalance(newBalance);
    }
}

class Employee extends BankAccount {
    Employee(String accountHolder, double balance, String accountType, int accountNumber) {
        super(accountHolder, balance, accountType, accountNumber);
    }

   
    public void modifyAccountType(String newType) {
        updateAccountType(newType);
    }
}

class Admin extends BankAccount {
    Admin(String accountHolder, double balance, String accountType, int accountNumber) {
        super(accountHolder, balance, accountType, accountNumber);
    }

    
    public void modifyBalance(double newBalance) {
        adminUpdateBalance(newBalance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("### Customer Actions ###");
        BankAccount customer = new BankAccount("John Doe", 5000, "Savings", 101);
        customer.viewBalance();
        customer.deposit(1000);
        
        System.out.println("\n### Employee Actions ###");
        Employee employee = new Employee("John Doe", 5000, "Savings", 101);
        employee.modifyAccountType("Current");

        System.out.println("\n### Admin Actions ###");
        Admin admin = new Admin("John Doe", 5000, "Current", 101);
        admin.modifyBalance(10000);
    }
}
