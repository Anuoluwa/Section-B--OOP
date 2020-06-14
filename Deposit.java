package com.cogrammar.transaction;

public class Deposit extends Transaction{
  private double amount;
  private Keypad keypad;
  private DepositSlot depositSlot;
  private final static int CANCELED = 0;

  public Deposit( int userAccountId, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot ) {
    super(userAccountId, atmScreen, atmBankDatabase);
    keypad = atmKeypad;
    depositSlot = atmDepositSlot;
  }

  @Override
  public void execute() {
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();

    amount = promptForDepositAmount();
    if (amount != CANCELED) {
      screen.displayMessage("\nKindly insert your amount ");
      screen.displayDollarAmount( amount );
      screen.displayMessageLine(".");

      boolean cashReceived = depositSlot.isCashReceived();

      if( cashReceived ) {
        screen.displayMessageLine("\nCash received, check later, while we verify");
        bankDatabase.deposit(getAccountId(), amount);
      } else {
        screen.displayMessageLine("\nNo cash received, transaction canceled ");
      }
    } else {
        screen.displayMessageLine("\nCanceling transaction");
    }
  }

  private double promptForDepositAmount() {
    Screen screen = getScreen();
    screen.displayMessage("\nEnter amount in cents (or to cancel): ");
    int input = keypad.getInput();

    if( input == CANCELED) {
      return CANCELED;
    } else {
      return ( double ) input / 100;
    }
  }
}