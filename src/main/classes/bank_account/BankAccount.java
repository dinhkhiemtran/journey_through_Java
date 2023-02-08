package main.classes.bank_account;

public class BankAccount {

    private int balance = 0;

    private boolean isAccountOpen = false;

    public void open() {
        this.isAccountOpen = true;
    }

    public void close() {
        isAccountOpen = false;
    }

    public synchronized int getBalance() throws BankAccountActionInvalidException {
        checkIfAccountIsNotClosed();
        return this.balance;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        checkIfAccountIsNotClosed();
        checkIsAmountIsPositive(amount);
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        checkIfAccountIsNotClosed();
        checkIsAmountIsPositive(amount);
        checkIfAccountIsNotEmpty();
        checkIfBalanceIsGreaterThenAmountToWithdraw(amount);
        this.balance -= amount;
    }

    private void checkIfAccountIsNotClosed() throws BankAccountActionInvalidException {
        if (!isAccountOpen) throw new BankAccountActionInvalidException("Account closed");
    }

    private void checkIsAmountIsPositive(int amount) throws BankAccountActionInvalidException {
        if (amount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
    }

    private void checkIfAccountIsNotEmpty() throws BankAccountActionInvalidException {
        if (this.balance == 0) throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
    }

    private void checkIfBalanceIsGreaterThenAmountToWithdraw(int amount) throws BankAccountActionInvalidException{
        if((this.balance - amount) < 0) throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
    }
}
