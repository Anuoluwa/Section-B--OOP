package com.cogrammar.account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {

  LocalDateTime myDateObj = LocalDateTime.now();
  DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
  String formattedDate = myDateObj.format(myFormatObj);

  public int id;
  public double balance;
  private String dateCreated;

  public Account(int accountId, double totalBalance) {
    id = accountId;
    balance = totalBalance;
    dateCreated = formattedDate;
  }

  public int getAccountId() {
    return id;
  }

  public double getTotalBalance() {
    return balance;
  }

  public String getTransactionDate() {
    return dateCreated;
  }

  public void setAccountId(int id) {
    id = newId;
  }

  public void setTotalBalance(double balance) {
    balance = newBalance;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public void deposit(double amount) {
    balance += amount;
  }
}
