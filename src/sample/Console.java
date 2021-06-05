package sample;

import java.net.UnknownHostException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws UnknownHostException {
        //loop state variable
        boolean loopState = true;

        //creating the object for MyGymManager class
        MyGymManager myGymManager = new MyGymManager();
        Scanner scanner = new Scanner (System.in);
        System.out.println("-----Gym Management System-----");

        //looping to get the inputs

        do{
            System.out.println("\n -----Select the option from the menu-----");
            System.out.println("\n A - Add a new member \n D - Delete a member \n P - Print the list of member details \n W - Write details to a file \n O - Open the interface \n Q - Quit the program");
            System.out.print("\n Select your option - ");

            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "a" : myGymManager.add(option);
                    break;
                case "d" : myGymManager.delete();
                    break;
                case "o" : myGymManager.open();
                    break;
                case "p" : myGymManager.printConsole();
                    break;
                case "w" : myGymManager.write();
                    break;
                case "q" : myGymManager.quit();
                    break;
                default:
                    System.out.println("Value you have entered is not valid!");
            }
        } while (loopState);

    }
}
