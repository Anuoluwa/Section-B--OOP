package com.cogrammar.transaction;

public class CheckBalance extends Transaction {
  public CheckBalance( int userAccountId, Screen atmScreen, BankDatabase atmBankDatabase) {
    super(userAccountId, atmScreen, atmBankDatabase);
  }

  @Override
  public void execute() {
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();

  double totalBalance = bankDatabase.getTotalBalance( getAccountId() );

  screen.displayMessageLine("\nAccount Details");
  screen.displayMessage(" * Account Balance");
  screen.displayDollarAmount( totalBalance );

  }

}