import java.util.Scanner;


public abstract class AccountInput {

        public static final Scanner scn = new Scanner(System.in);

        protected static String choice;
        protected static String username;
        protected static String password;
        protected static Integer amount;

        abstract Integer inputChoice();


        public void inputUsername(){
            try{
                username = scn.nextLine();
            }catch(Exception e){
                System.out.println("You can only input letters.");
            }

        }
        public void inputPassword(){
            try{
                password = scn.nextLine();
            }catch(Exception e){
                System.out.println("You can only input letters.");
            }
        }

    public void exitApp(){
            System.exit(1);
    }
}

