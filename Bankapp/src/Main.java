

public class Main {
    public static DatabaseSingleton database = DatabaseSingleton.getInstance();
    public static AccountOperations accountO = new AccountOperations();
    public static AccountBalanceOperations accountBO = new AccountBalanceOperations();
    public static View vw = new View();
    public static void main(String[] args) {
        vw.start();
    }

}