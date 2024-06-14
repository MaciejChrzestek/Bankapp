import java.util.Objects;

public class AccountOperations extends AccountInput {

    public boolean login(){
        return Objects.equals(password, Main.database.getPassword(username));
    }

    public boolean register(){
        return Main.database.setNewAccount(username, password);

    }
    public Integer accountbalance(){
         return Main.database.getBalance(username);
    }
    public void logout(){
        username = null;
        password = null;
        amount = null;
        Main.accountO.changeChoice();
        Main.vw.start();
    }
}