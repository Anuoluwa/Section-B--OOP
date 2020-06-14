package com.cogrammar.transaction;

public class Withdrawal extends Transaction {
  private int amount;
  private Keypad keypad;
  private CashDispenser cashDispenser;

  private final static int CANCELED = 6;

  public Withdrawal( int userAccountId, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
    super(userAccountId, atmScreen, atmBankDatabase);
    keypad = atmKeypad;
    cashDispenser = atmCashDispenser;
  }

  @Override
  public void execute() {
    boolean cashDispensed = false;
    double totalBalance;

    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();

    do {
      amount = displayMenuOfAmounts();

      if(amount != CANCELED) {
        totalBalance = bankDatabase.getTotalBalance( getAccountId() );

        if(amount <= totalBalance) {
          if(cashDispenser.isSufficientCashAvailable( amount )) {
            bankDatabase.withdraw( getAccountId(), amount );

            cashDispenser.dispenseCash( amount );
            cashDispensed = true;

            screen.displayMessageLine("\nCash dispensed, kindly take your cash.");
          }
          else
            screen.displayMessageLine("Insufficient fund");
        }
        else {
          screen.displayMessageLine("Insufficient fund, try other amounts");
        }
      }
      else {
        screen.displayMessageLine("\nCancelling transaction");
      }
    }  while(!cashDispensed);

  }


  private int displayMenuOfAmounts() {
    int userchoice = 0;
    Screen screen = getScreen();

    int [] amounts = { 0, 50, 100, 150, 200, 250};

    while (userchoice = 0) {
      screen.displayMessageLine("\nWithdrawal Menu");
      screen.displayMessageLine("1 - $50");
      screen.displayMessageLine("2 - $100");
      screen.displayMessageLine("3 - $150");
      screen.displayMessageLine("4 - $200");
      screen.displayMessageLine("5 - $250");
      screen.displayMessageLine("6 - Cancel transaction");
      screen.displayMessage("\nOthers");

      int input = keypad.getInput();

      switch( input ) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
          userChoice = amounts[ input ];
          break;
        case  CANCELED:
          userChoice = CANCELED;
          break;
        default:
          screen.displayMessageLine("\nInvalid selection, Try again");
      }
    }
    return userChoice;
  }
}