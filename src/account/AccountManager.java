package account;

import student.StudentMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountManager  implements Serializable {
    public static Scanner scanner = new Scanner(System.in);
StudentMenu studentMenu = new StudentMenu();
    public List<Account> accountList;

    private final AccountDao accountDao;


    public AccountManager() {
        accountList = new ArrayList<>();
        accountDao = new AccountDao();
        accountList = accountDao.read();

    }

    private static final String USERNAME_REGEX="^[_a-z0-9]{6,}$";
    public boolean checkUsername(String regex) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public ArrayList<Account> register(Scanner scanner){
        System.out.println("Nhập tên đăng nhập (chỉ chưa kí tự viết thường , tối thiếu 6 kí tự và số từ 0 đến 9):");
        String username=scanner.nextLine();
        for (Account p: accountList){
            if(p.getUsername().equals(username)){
                System.out.println("Tài khoản đã tồn tại!");
                System.out.println("Nhập lại:");
                username=scanner.nextLine();
            }
        }
        while (checkUsername(username)==false){
            System.out.println("Nhập lại tài khoản theo đúng định dạng!");
            username=scanner.nextLine();
        }
        System.out.println("Nhập mật khẩu của bạn:");
        String password=scanner.nextLine();
        Account account=new Account(username,password);
        accountList.add(account);
        accountDao.write(accountList);
        return (ArrayList<Account>) accountList;
    }
    public int logIn(Scanner scanner,String username){
        while (checkUsernameInList(username) == false) {
            System.out.println("Tài khoản không tồn tại trong hệ thống!");
            System.out.println("Nhập lại tài khoản");
            username=scanner.nextLine();
        }
        return indexAccount(username);
    }



    public boolean checkPasswordToLogIn(Scanner scanner,String username){
        System.out.println("Nhập mật khẩu của bạn:");
        String password=scanner.nextLine();
        while (!accountList.get(logIn(scanner,username)).getPassword().equals(password)){
            System.out.println("Mật khẩu của bạn không đúng! Xin hãy thử lại!");
            password=scanner.nextLine();
        }
        studentMenu.menuAccount();
        return true;
    }

    private boolean checkUsernameInList(String username){
        boolean check =false;
        for(Account p:accountList){
            if (p.getUsername().equals(username)){
                check =true;
                break;
            }
        }
        return check;
    }
    public int indexAccount(String username){
        int index =-1;
        for(int i=0;i<accountList.size();i++){
            if(accountList.get(i).getUsername().equals(username)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean checkEmpty(){
        return  accountList.isEmpty();
    }

    public boolean checkAdmin(Scanner scanner,String username){
        boolean check=false;
        if (username.equals("admin")){
            System.out.println("Nhập mật khẩu quản trị!");
            String password=scanner.nextLine();
            studentMenu.menuAdmin();
            while (!password.equals("admin")){
                System.out.println("Sai mật khẩu quản lí! Nhập lại");
                password=scanner.nextLine();
            }
            check= true;
        }
        return check;
    }


}
