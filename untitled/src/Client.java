
import java.util.Scanner;


public class Client {
    public static DatabaseSingleton database = DatabaseSingleton.getInstance();
    public static final Scanner scn = new Scanner(System.in);
    public static AccountOperations log = new AccountOperations();
    public static AccountBalanceOperations operations = new AccountBalanceOperations();
    public static Controller controller = new Controller();

    public static void main(String[] args) {
    controller.start();
    }

}