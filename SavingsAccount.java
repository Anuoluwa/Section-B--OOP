// The SavingsAccount class should contain:
public class SavingsAccount extends Account {
  // • A double data field named annualInterestRate that stores the current annual interest rate.
  private double annualInterestRate;

  public void setAnnualInterestRate(double newAnnualInterestRate) {
    annualInterestRate = newAnnualInterestRate;
  }

  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  double getMonthlyInterestRate() {
    return annualInterestRate / 12;
  }

  public getMonthlyInterest() {
    return balance * ( monthlyInterestRate / 100)
  }

}