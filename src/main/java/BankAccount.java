import java.time.LocalDate;

public class BankAccount {
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private Double balance;
    private Double interestRate;
    private String accountType;
    private Double overdraft;

    public BankAccount (String fname, String lname, LocalDate dob, int accnum){
        firstname = fname;
        lastname = lname;
        dateOfBirth = dob;
        accountNumber = accnum;
        balance = 0D;
        accountType = "Checking";
        overdraft = 0D;
        interestRate= 0.01;
    }
// Get methods:
    public String getName(){
        return firstname + " " + lastname;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public Double getBalance() {
        return balance;
    }
    public Double getInterest(){
        return interestRate;
    }
    public String getAccountType(){
        return accountType;
    }
    public Double getOverdraft(){
        return overdraft;
    }

// Set methonds:
    public void changeName(String fname, String lname){
        firstname = fname;
        lastname = lname;
    }
    public void changeDOB(LocalDate dob){
        dateOfBirth = dob;
    }
    public void changeInterest(Double amount){
        interestRate = amount;
    }
    public void changeAccountType(String newAccountType){
        newAccountType = newAccountType.toLowerCase();
        switch (newAccountType) {
            case "savings":
                accountType = "Savings";
                interestRate = 0.03;
                System.out.println("Your account is now a savings account");
                break;
            case "checking":
                accountType = "Checking";
                interestRate = 0.01;
                System.out.println("Your account is now a checking account");
                break;
            default:
                System.out.println("Please enter Checking or savings");
        }
    }
    public void changeOverdraft(Double newOverdraft){
        overdraft = newOverdraft;
    }

// Deposit method:

    public void deposit(Double deposit){
        balance += deposit;
        System.out.println("You have deposited £" + deposit +"\nYour balance is now £" + balance);
    }

// Withdrawal method:

    public void withdrawal(Double withdrawal){
        if (balance >= withdrawal){
            balance -= withdrawal;
            System.out.println("Here is £" + withdrawal + "\nYour remaining balance is £" + balance);
        } else if (balance < withdrawal){
            System.out.println("Sorry you don't have the available funds.");
        } else{
            System.out.println("Error, please seek help.");
        }
    }

// accrue interest method:
    public void accrueInterest(){
        Double payment = balance * interestRate;
        balance += payment;
        System.out.println("You have accrued £" + payment + " of interst.");
    }

}
