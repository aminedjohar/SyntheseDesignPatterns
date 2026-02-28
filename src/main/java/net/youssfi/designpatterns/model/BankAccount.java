package net.youssfi.designpatterns.model;

public class BankAccount implements Cloneable {
    private String accountId;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;

    // Constructeur privé pour forcer l'utilisation du Builder
    private BankAccount() {}

    // Les Getters et Setters classiques (raccourcis ici pour la lisibilité)
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    // --- PATTERN PROTOTYPE ---
    @Override
    public BankAccount clone() throws CloneNotSupportedException {
        return (BankAccount) super.clone();
    }

    // --- PATTERN BUILDER ---
    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder {
        private BankAccount bankAccount = new BankAccount();

        public AccountBuilder accountId(String accountId) {
            bankAccount.accountId = accountId;
            return this;
        }

        public AccountBuilder balance(double balance) {
            bankAccount.balance = balance;
            return this;
        }

        public AccountBuilder currency(String currency) {
            bankAccount.currency = currency;
            return this;
        }

        public AccountBuilder type(AccountType type) {
            bankAccount.type = type;
            return this;
        }

        public AccountBuilder status(AccountStatus status) {
            bankAccount.status = status;
            return this;
        }

        public BankAccount build() {
            return this.bankAccount;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{id='" + accountId + "', balance=" + balance + "}";
    }
}
