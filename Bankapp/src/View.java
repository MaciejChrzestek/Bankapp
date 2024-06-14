public class View {

    void start(){

        System.out.println("Press 1 to login, 2 to register or 3 to exit.");
        if(Main.accountO.inputChoice() == 1){
            System.out.print("You can only chose number between 1 and 3.\n");

        }
        else if (Main.accountO.inputChoice() == 2) {
            System.out.println("You can only input numbers.");

        }

        if(Main.accountO.choice == 1) {
            usernameLogin();
            if (Main.accountO.login()) {
                System.out.println("Successful login.");
                operationsOnAccount();
            } else {
                System.out.println("Wrong username or password.");

            }
        }
        else if (Main.accountO.choice == 2){
            usernameLogin();
            if(Main.accountO.register()) {
                System.out.println("Successful registration, you can login now.");

            }

        }
        else{
            Main.accountO.exitApp();
        }
    }
    void operationsOnAccount(){
        System.out.printf("Your account balance: %1$2s \n", Main.accountO.accountbalance());
        System.out.println("Press 1 to deposit, 2 to withdraw, 3 to transfer money to other accounts or 4 to logout.");
        Main.accountBO.inputChoice();
        if (Main.accountBO.inputChoice() == 1){
            System.out.print("You can only chose number between 1 and 4.");
            operationsOnAccount();
        } else if (Main.accountBO.inputChoice() == 2) {
            System.out.println("You can only input numbers.");
            operationsOnAccount();
        }

        if(Main.accountBO.choice == 1){
            System.out.println("Input amount to deposit: ");
            Main.accountBO.inputAmount();
            Main.accountBO.deposit();
            System.out.println("Amount successfully deposited.");
            operationsOnAccount();
            }
        else if (Main.accountBO.choice == 2) {
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
        else if(Main.accountBO.choice == 3){
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
        else{
            Main.accountO.logout();
        }
    }

    void usernameLogin(){
        System.out.println("Enter your login.");
        Main.accountO.inputUsername();
        System.out.println("Enter your password");
        Main.accountO.inputPassword();
    }
}
