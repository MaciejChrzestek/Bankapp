import java.util.Objects;

public class View implements ViewInterface {

    public void start(){

        System.out.println("Press 1 to login, 2 to register or 3 to exit.");
        if(Main.accountO.inputChoice() == 1){
            System.out.print("You can only chose numbers between 1 and 3.\n");
            start();

        }
        if(Objects.equals(AccountInput.choice, "1")){
           accountLogin();
        }
        else if (Objects.equals(AccountInput.choice, "2")){
            accountRegister();
        }
        else{
            Main.accountO.exitApp();
        }
    }

    public void operationsOnAccount(){
        System.out.printf("Your account balance: %1$2s \n", Main.accountO.accountbalance());
        System.out.println("Press 1 to deposit, 2 to withdraw, 3 to transfer money to other accounts or 4 to logout.");
        if (Main.accountBO.inputChoice() == 1){
            System.out.print("You can only chose numbers between 1 and 4.");
            operationsOnAccount();
        }

        if(Objects.equals(AccountInput.choice, "1")){
            accountDeposit();
        }
        else if (Objects.equals(AccountInput.choice, "2")) {
            accountWithdraw();

        }
        else if(Objects.equals(AccountInput.choice, "3")){
            accountTransfer();
        }
        else{
            Main.accountO.logout();
        }
    }

    public void credentials(){
        System.out.println("Enter your login.");
        Main.accountO.inputUsername();
        System.out.println("Enter your password");
        Main.accountO.inputPassword();
    }
    public void accountLogin(){
        credentials();
        if (Main.accountO.login()) {
            System.out.println("Successful login.");
            operationsOnAccount();
        } else {
            System.out.println("Wrong username or password.");
            start();
        }
    }
    public void accountRegister(){
        credentials();
        if(Main.accountO.register()) {
            System.out.println("Successful registration, you can login now.");
            accountLogin();
        }
        else{
            System.out.println("Username is already taken.");
            start();
        }

    }
    public void accountDeposit(){
        System.out.println("Input amount to deposit: ");
        Main.accountBO.inputAmount();
        Main.accountBO.deposit();
        System.out.println("Amount successfully deposited.");
        operationsOnAccount();
    }
    public void accountWithdraw(){
        System.out.println("Input amount to withdraw: ");
        Main.accountBO.inputAmount();
        if(Main.accountBO.withdraw()){
            System.out.println("Amount successfully withdrawn.");
            operationsOnAccount();
        }
        else{
            System.out.println("Not enough money to withdraw.");
            operationsOnAccount();
        }
    }
    public void accountTransfer(){
        System.out.println("Write name of the account you want to transfer money to.");
        Main.accountBO.inputUsername();
        System.out.println("Input amount to transfer: ");
        Main.accountBO.inputAmount();
        if (Main.accountBO.transfer() == 1){
            System.out.println("Wrong account name.");
            operationsOnAccount();
        }
        else if (Main.accountBO.transfer() == 2){
            System.out.println("Not enough money to transfer.");
            operationsOnAccount();
        }
        else{
            System.out.printf("Transfer %1s to %2s completed.", Main.accountBO.getAmount(), Main.accountBO.getUsername2());
            operationsOnAccount();
        }
    }
}
