import java.util.HashMap;


//Simple Database
public class DatabaseSingleton {
    private volatile HashMap<String,String> userLogin = new HashMap<String,String>();
    private volatile HashMap<String,Integer> userBalance = new HashMap<String,Integer>();

    private DatabaseSingleton(){
        userLogin.put("admin","admin1");
        userBalance.put("admin",1000);
    }

    public static DatabaseSingleton getInstance() {
        return DatabaseSingletonholder.INSTANCE;
    }

    private static class DatabaseSingletonholder {
        private static final DatabaseSingleton INSTANCE = new DatabaseSingleton();
    }
    //get account password from database
    public String setPassword(String key){
        return userLogin.get(key);
    }
    //get account balance from database
    public Integer setBalance(String key){
        return userBalance.get(key);
    }
    // checks if username is taken and create new account
    public boolean getNewAccount(String key, String value){
        boolean b;
        try {
            userLogin.putIfAbsent(key, value);
            userBalance.put(key, 0);
            b = true;
        }catch (Exception e){
            System.out.println("error");
            b = false;
        }
        return b;
    }
    //set account balance
    public void getChangeBalance(String key, Integer value){
        userBalance.put(key, value);
    }
}
