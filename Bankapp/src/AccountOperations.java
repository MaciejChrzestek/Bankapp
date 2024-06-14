import java.util.Objects;

public class AccountOperations extends AccountInput {
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

    public boolean login(){
        return Objects.equals(password, Main.database.getPassword(username));
    }

    public boolean register(){return Main.database.setNewAccount(username, password);}

    public Integer accountbalance(){
         return Main.database.getBalance(username);
    }
    public void logout(){
        username = null;
        password = null;
        amount = null;
        Main.vw.start();
    }
}