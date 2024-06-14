import java.util.Objects;

public class AccountBalanceOperations extends AccountInput{

    String username2;
    //input between 1-4
    public Integer inputChoice(){
        Integer error = 0;

        String input = scn.nextLine();
        if (Objects.equals(input, "1") || Objects.equals(input, "2") ||
                Objects.equals(input, "3") || Objects.equals(input,"4")) {
            choice = input;

        }
        else {
            error = 1;
        }
        return error;


    }

    //input username for transfer
    @Override
    public void inputUsername(){
            this.username2 = scn.nextLine();
    }
    //input amount
    public void inputAmount(){

        try {
            amount = scn.nextInt();
            scn.nextLine();
            if(amount < 0){
                System.out.println("Input only positive numbers.");
                amount = 0;
                inputAmount();
            }
        } catch (Exception e) {
            System.out.println("You can only input numbers.");
        }
    }
    //getter for view
    public Integer getAmount(){
        return amount;
    }
    //getter for view
    public String getUsername2(){
        return  this.username2;
    }
    //change balance by amount
    public void deposit(){
        Integer sum = Main.database.getBalance(username) + amount;
        Main.database.setChangeBalance(username,sum);
    }
    //change balance by amount
    public boolean withdraw(){
        Integer sum = Main.database.getBalance(username) - amount;
        if(sum > 0) {
            Main.database.setChangeBalance(username, sum);
            return true;
        }
        else{
            return false;
        }
    }
    //transfer money from username to username2
    public Integer transfer(){
        if(!Main.database.getAccount(this.username2)){
            return 1;
        }
        else if(Main.database.getBalance(username) - amount < 0){
            return 2;
        }
        else {

            Main.database.setChangeBalance(username, Main.database.getBalance(username) - amount/2);
            Main.database.setChangeBalance(this.username2, Main.database.getBalance(this.username2) + amount/2);

            return 3;
        }
    }
}


