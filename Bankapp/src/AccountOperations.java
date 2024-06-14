import java.util.Objects;

public class AccountOperations extends AccountInput {
    //input between 1-3
    public Integer inputChoice(){
            Integer error = 0;

            String input = scn.nextLine();
                    if (Objects.equals(input, "1") || Objects.equals(input, "2") || Objects.equals(input, "3")) {
                        choice = input;

                    }
                    else {
                        error = 1;
                }
            return error;


    }
    //checks credentials
    public boolean login(){
        return Objects.equals(password, Main.database.getPassword(username));
    }
    //register new user
    public boolean register(){return Main.database.setNewAccount(username, password);}
    //checks account balance
    public Integer accountbalance(){
         return Main.database.getBalance(username);
    }
    //logout user
    public void logout(){
        username = null;
        password = null;
        amount = null;
        Main.vw.start();
    }
}