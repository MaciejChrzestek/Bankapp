import java.util.HashMap;


//Simple Database model
public class DatabaseSingleton {
    private final HashMap<String, String> userLogin;
    private final HashMap<String, Integer> userBalance;

    private DatabaseSingleton() {
        userLogin = new HashMap<>();
        userBalance = new HashMap<>();
        userLogin.put("admin", "admin1");
        userBalance.put("admin", 1000);
        userLogin.put("a", "a");
        userBalance.put("a", 600);
    }

    public static DatabaseSingleton getInstance() {
        return DatabaseSingletonholder.INSTANCE;
    }

    private static class DatabaseSingletonholder {
        private static final DatabaseSingleton INSTANCE = new DatabaseSingleton();
    }

    //take out account password from database
    public String getPassword(String key) {
        return userLogin.get(key);
    }

    //take out account balance from database
    public Integer getBalance(String key) {
        return this.userBalance.get(key);
    }

    // checks if username is taken and create new account
    public boolean setNewAccount(String key, String value) {
        boolean b;
        try {
            userLogin.putIfAbsent(key, value);
            userBalance.put(key, 0);
            b = true;
        } catch (Exception e) {
            System.out.println("error");
            b = false;
        }
        return b;
    }
    //change account balance
    public void setChangeBalance(String key, Integer value){
        userBalance.put(key, value);
    }
    //check if account exist in database
    public boolean getAccount(String key){
        return userBalance.containsKey(key);
    }
}