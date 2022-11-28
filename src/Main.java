import account.AccountMenu;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AccountMenu accountMenu = new AccountMenu();
        accountMenu.menuAccount();

    }
}