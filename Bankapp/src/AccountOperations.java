import java.util.Objects;

public class AccountOperations extends AccountInput {
    public void inputChoice(){
        {

            try {
                Integer input = scn.nextInt();
                scn.nextLine();

                if (input > 3) {
                    System.out.print("You can only chose number between 1 and 3.\n");
                } else {
                    this.choice = input;
                }
            } catch (Exception e) {
                System.out.println("You can only input numbers.");
            }
        }
    }

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
        Main.vw.start();
    }
}