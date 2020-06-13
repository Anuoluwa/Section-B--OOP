public class SavingsAccount extends Account {
  public double annualInterestRate;

  public SavingsAccount(int id, double balance, double annualInterestRate) {
    super(id, balance);
    annualInterestRate = annualInterestRate;
  }

  public void setAnnualInterestRate(double newAnnualInterestRate) {
    annualInterestRate = newAnnualInterestRate;
  }

  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  double getMonthlyInterestRate() {
    return annualInterestRate / 12;
  }

  public double getMonthlyInterest() {
    return balance * ( monthlyInterestRate / 100);
  }

  public double getTotalBalanceSavings() {
    return balance + getMonthlyInterest();
  }
}