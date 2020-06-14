package com.cogrammar.transaction;

// This will be called only by the subclasses
public abstract class Transaction {
  private int accountId;
  private Screen screen;
  private BankDatabase bankDatabase;

  public Transaction( int userAccountId, Screen atmScreen, BankDatabase atmBankDatabase) {
    accountId = userAccountId;
    screen = atmScreen;
    bankDatabase = atmBankDatabase;
  }

  public int getAccountId() {
    return accountId;
  }

  public Screen getScreen() {
    return screen;
  }

  public BankDatabase getBankDatabase() {
    return bankDatabase;
  }

  abstract public void execute();
}