import java.util.Objects;

public class Controller {
    //starts app
    void start(){
        System.out.println("Press 1 to login or 2 to register");
        Integer choice = Client.scn.nextInt();
        Client.scn.nextLine();
        if(Objects.equals(1,choice)){
            if(Client.log.login()){
                //in case of successful login moves to balance operations
                Client.log.balanceOperations();
            }
            //in case of unsuccessful login user can either try to log again or exit
            else{
                System.out.println("Wrong username or password. Press 1 to login again or 2 to exit.");
                Integer choice2 = Client.scn.nextInt();
                Client.scn.nextLine();
                if(Objects.equals(1, choice2)){
                  Client.log.login();
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            //in case of unsuccessful registration user can register again or exit
            if(Client.log.register()){
                Client.log.login();
            }
            else{
                System.out.println("Press 1 to register again or 2 to exit");
                Integer choice3 = Client.scn.nextInt();
                Client.scn.nextLine();
                if(Objects.equals(1, choice3)){
                    Client.log.login();
                }
                else{
                    System.exit(0);
                }
            }
        }
    }
}
