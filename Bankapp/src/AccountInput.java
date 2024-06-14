import java.util.Scanner;

public abstract class AccountInput {

        public static final Scanner scn = new Scanner(System.in);

        Integer choice;
        //Integer choiceNumber = 3;
        protected static String username;
        protected static String password;
        protected static Integer amount;

        abstract void inputChoice();


        public void inputUsername(){
            try{
                this.username = scn.nextLine();
            }catch(Exception e){
                System.out.println("You can only input letters.");
            }

        }
        public void inputPassword(){
            try{
                this.password = scn.nextLine();
            }catch(Exception e){
                System.out.println("You can only input letters.");
            }
        }

    public void exitApp(){
            System.exit(1);
    }
}

