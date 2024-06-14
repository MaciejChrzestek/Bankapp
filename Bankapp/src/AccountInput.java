import java.util.Scanner;

public class AccountInput {

        public static final Scanner scn = new Scanner(System.in);

        Integer choice;
        Integer choiceNumber = 3;
        protected static String username;
        protected static String password;
        protected static Integer amount;

        public void inputChoice(){
            changeChoice();
            try {
                Integer input = scn.nextInt();
                scn.nextLine();

                if (input > choiceNumber) {
                    System.out.print("You can only chose number between 1 and "+ choiceNumber);
                } else {
                    this.choice = input;
                }
            } catch (Exception e) {
                System.out.println("You can only input numbers.");
            }
        }

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
    public void changeChoice(){
        choiceNumber = 3;
    }
    public void exitApp(){
            System.exit(1);
    }
}

