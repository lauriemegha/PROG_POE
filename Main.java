import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        String phoneNumber;
        String firstName;
        String lastName;

        System.out.println(" ===============REGISTRATION=============== ");
        
        System.out.println("Please enter your first name: ");
        firstName = scanner.nextLine();

        System.out.println("Please enter your last name: ");
        lastName = scanner.nextLine();

        System.out.println("Please enter your username: ");
        username = scanner.nextLine(); 

        System.out.println("Please enter your password: ");
        password = scanner.nextLine(); 

        System.out.println("Please enter your phone number: ");
        phoneNumber = scanner.nextLine();

        


    }
}