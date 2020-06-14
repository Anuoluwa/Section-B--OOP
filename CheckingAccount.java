package com.cogrammar.account;

public class CheckingAccount extends Account {
  public double overdraft;

  public CheckingAccount(int id, double balance, double overdraft) {
    super(id, balance);
    overdraft = overdraft;
  }

  public double getOverdraft() {
    return overdraft;
  }
}