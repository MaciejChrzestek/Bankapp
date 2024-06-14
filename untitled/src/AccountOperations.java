import java.util.Objects;

//Handles operations on bank accounts
public class AccountOperations  {
     private String username;
     private Integer amount;

    public Integer amount(){
        this.amount = Client.scn.nextInt();
        Client.scn.nextLine();
        return this.amount;
    }

     public boolean login(){
        System.out.println("Enter your login.");
        this.username = Client.scn.nextLine();
        System.out.println("Enter your password");
        String password = Client.scn.nextLine();
        if (Objects.equals(password, Client.database.setPassword(this.username))){
            System.out.println("Your account balance is: " + Client.database.setBalance(this.username));
            return true; // for successful login
            }
        else{
            return false; // for unsuccessful login
        }

     }
    public boolean register(){
        System.out.println("Enter your login: ");
        this.username = Client.scn.nextLine();
        System.out.println("Enter your password: ");
        String newPassword = Client.scn.nextLine();
        if(Client.database.getNewAccount(this.username, newPassword)){
             // for successful registration
            System.out.println("Enter an amount you want to deposit: ");
            Integer newBalance = Client.scn.nextInt();
            Client.scn.nextLine();
            Client.operations.deposit(this.username, newBalance);
            return true;

        }
        else {  // for successful registration
            return false;
        }

    }
    public void balanceOperations(){
        System.out.println("Press 1 to deposit, 2 to withdraw or 3 to transfer money to another account.");
        Integer choice = Client.scn.nextInt();
        Client.scn.nextLine();
        if(choice == 1){
          System.out.println("Amount to deposit: ");

        }
        else if(choice == 2){

        }
        else{

        }
    }
}

