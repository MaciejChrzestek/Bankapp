
public class AccountBalanceOperations extends  AccountOperations {
    //deposit money
    public void deposit(String account, Integer amount){
        Integer sum = Client.database.setBalance(account) + amount;
        Client.database.getChangeBalance(account,sum);
    }
    // withdraw money
    public void withdraw(String account, Integer amount){
        Integer sum = Client.database.setBalance(account) - amount;
        if(sum<0){
            System.out.println("Not enough money to withdraw.");
        }
        else {
            Client.database.getChangeBalance(account, sum);
        }
    }
    // transfer money from one account to another
    public void transfer(String account1, String account2, Integer amount){
        if(Client.database.setBalance(account1)< amount){
            System.out.println("Not enough money to transfer.");
        }
        else{
             Integer balance1 = Client.database.setBalance(account1) - amount;
             Client.database.getChangeBalance(account1, balance1);
             Integer balance2 = Client.database.setBalance(account2) + amount;
             Client.database.getChangeBalance(account2, balance2);
        }
    }

}
