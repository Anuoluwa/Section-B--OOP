package com.cogrammar.atm;

public class CashDispenser {
  private final static int INITIAL_COUNT = 1000000; // number of notes in the cash dispenser
  private int count; // remaining number of $50 notes

  public CashDispenser() {
    count = INITIAL_COUNT;
  }

  public void dispenseCash(int amount) {
    int billsRequired = amount / 50;
    count -= billsRequired;
  }

  public boolean isSufficientCashAvailable( int amount ) {
    int billsRequired = amount/ 50;

    if( count >= billsRequired ) {
      return true;
    }
    else
      return false;
  }
}