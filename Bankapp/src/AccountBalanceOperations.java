public class AccountBalanceOperations extends AccountInput{

    String username2;

    public Integer inputChoice(){
        {
            Integer error = 0;
            try {
                Integer input = scn.nextInt();
                scn.nextLine();
                if (input > 4) {
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
    @Override
    public void inputUsername(){
            this.username2 = scn.nextLine();
    }
    public void inputAmount(){

        try {
            amount = scn.nextInt();
            scn.nextLine();

        } catch (Exception e) {
            System.out.println("You can only input numbers.");
        }
    }

    public Integer getAmount(){
        return amount;
    }
    public String getUsername2(){
        return  this.username2;
    }
    public void deposit(){
        Integer sum = Main.database.getBalance(username) + amount;
        Main.database.setChangeBalance(username,sum);
    }

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


