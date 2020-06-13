public class ATM {
  private boolean userAuthenticated;
  private int currentAccountId;
  private Screen screen;
  private Keypad keypad;
  private CashDispenser cashDispenser;
  private DepositSlot depositSlot;
  private BankDatabase bankDatabase;

  private static final int CHECK_BALANCE = 1;
  private static final int WITHDRAW = 2;
  private static final int DEPOSIT = 3;
  private static final int EXIT = 4;

  public ATM() {
    userAuthenticated = false;
    currentAccountId = 0;
    screen = new Screen();
    keypad = new Keypad();
    cashDispenser = new CashDispenser();
    depositSlot = new DepositSlot();
    bankDatabase = new BankDatabase();
  }

  public void run() {
    while (true) {
      while (!userAuthenticated) {
        screen.displayMessageLine("\nWelcome!");
        authenticateUser();
      }
      performTransactions();
      userAuthenticated = false;
      currentAccountId = 0;
      screen.displayMessageLine("\nGoodbye");
    }
  }

  private void authenticateUser() {
    screen.displayMessage("\nKindly enter your account ID: ");
    int accountId = keypad.getInput();
    userAuthenticated = bankDatabase.authenticateUser(accountId);
    if (userAuthenticated) {
      currentAccountId = accountId;
    } else
      screen.displayMessageLine("Please enter a correct account ID");
  }

  private void performTransactions() {
    Transaction currentTransaction = null;
    boolean userExited = false;

    while (!userExited) {
      int mainMenu = displayMainMenu();

      switch (mainMenu) {
      case CHECK_BALANCE:
      case WITHDRAW:
      case DEPOSIT:

        currentTransaction = createTransaction(mainMenu);
        currentTransaction.execute();
        break;
      case EXIT:
        screen.displayMessageLine("\nExiting...");
        userExited = true;
        break;
      default:
        screen.displayMessageLine("\nKindly enter a valid selection");
        break;
      }
    }
  }

  private int displayMainMenu() {
    screen.displayMessageLine("\nMain menu:");
    screen.displayMessageLine("1 - Check Balance");
    screen.displayMessageLine("2 - Withdraw");
    screen.displayMessageLine("3 - Deposit");
    screen.displayMessageLine("4 - Exit");
  }

}