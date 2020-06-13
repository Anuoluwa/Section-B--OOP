import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankDatabase {
  private Account[] accounts;

  LocalDateTime myDateObj = LocalDateTime.now();
  DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
  String formattedDate = myDateObj.format(myFormatObj);
  // no argument
  public BankDatabase(){
    accounts = new Account[ 10 ];
    accounts[ 0 ] = new SavingsAccount(0100, 100.0, formattedDate, 20.0);
    accounts[ 1 ] = new SavingsAccount(0101, 200.0, formattedDate, 20.0);
    accounts[ 2 ] = new SavingsAccount(0102, 300.0, formattedDate, 20.0);
    accounts[ 3 ] = new SavingsAccount(0103, 400.0, formattedDate, 20.0);
    accounts[ 4 ] = new SavingsAccount(0104, 500.0, formattedDate, 20.0);
    accounts[ 5 ] = new CheckingAccount(0200, 100000.0, formattedDate, 2000.0);
    accounts[ 6 ] = new CheckingAccount(0201, 200000.0, formattedDate, 1000.0);
    accounts[ 7 ] = new CheckingAccount(0202, 300000.0, formattedDate, 20000.0);
    accounts[ 8 ] = new CheckingAccount(0203, 400000.0, formattedDate, 400.0);
    accounts[ 9 ] = new CheckingAccount(0204, 500000.0, formattedDate, 89000.0);
  }

  private Account getAccount( int accountId ) {
    for (Account currentAccount: accounts) {
      if(currentAccount.getAccountId() == accountId) {
        return currentAccount;
      }
    }
    return "please enter a correct ID";
  }

  public boolean authenticateUser( int userAccountId ) {
    Account userAccount = getAccount( userAccountId )
    if (userAccount != null )
      return userAccount;
    else
      return false;
  }

  public double getTotalBalance( int userAccountId ) {
    return getAccount( userAccountId ).getTotalBalance();
  }

  public void deposit( int userAccountId, double amount) {
    getAccount( userAccountId ).deposit(amount)
  }

  public void withdraw( int userAccountId, double amount) {
    getAccount( userAccountId ).withdraw(amount)
  }
}