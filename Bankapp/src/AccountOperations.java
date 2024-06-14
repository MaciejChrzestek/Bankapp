import java.util.Objects;

public class AccountOperations extends AccountInput {
    public Integer inputChoice(){
        {
            Integer error = 0;
                try {

                    Integer input = scn.nextInt();
                    scn.nextLine();

                    if (input > 3) {
                        error = 1;
                    } else {
                        choice = input;

                    }
                } catch (Exception e) {
                    error = 2;

                }
            return error;
        }

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