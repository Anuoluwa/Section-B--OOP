public class Account {
  private int id;
  private double balance;
  private Date dateCreated;

  public Account(int accountId, double totalBalance, Date transactionDate ) {
    id = accountId;
    balance = totalBalance;
    dateCreated = transactionDate;
  }

  public int getAccountId() {
    return id;
  }

  public double getTotalBalance() {
    return balance;
  }

  public Date getTransactionDate() {
    return dateCreated;
  }

  public void setAccountId(int id) {
    return id = newId;
  }

  public void setTotalBalance(double balance) {
    return balance = newBalance;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public void deposit(double amount) {
    balance += amount;
  }
}
