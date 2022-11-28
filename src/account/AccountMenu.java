package account;

import java.util.Scanner;

public class AccountMenu {
    public static Scanner scanner =new Scanner(System.in);
    AccountManager  accountManager = new AccountManager();

    public void menuAccount(){
        String choose = null;
        boolean exit = false;
        do {
            System.out.println("┌-----------MENU--------------┐");
            System.out.println("│▶ 1.Register an account      │");
            System.out.println("│▶ 2. Login.                  │");
            System.out.println("│▶ 0. Exit.                   │");
            System.out.println("└-----------------------------┘");
            System.out.print("Please choose: ");

            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    accountManager.register(scanner);
                    break;
                case "2":
                    System.out.println("Enter username to login:");
                    String username = scanner.nextLine();
                    if (accountManager.checkAdmin(scanner, username)) {

                        break;
                    } else if (accountManager.checkEmpty()) {
                        System.out.println("No accounts yet!");
                    }
                    while (accountManager.indexAccount(username) == -1) {
                        System.out.println("Account does not exist in the system!");
                        System.out.println("Re-enter account:");
                        username = scanner.nextLine();
                        if (accountManager.checkAdmin(scanner, username)) {

                            break;
                        }
                    }
                    if (accountManager.indexAccount(username) != -1 && accountManager.checkPasswordToLogIn(scanner, username)) {

                    }
                    break;
                case "0":
                    System.out.println("Exited");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu: ");
            } if (exit){
                break;
            }
        } while (choose != null);
    }
}

