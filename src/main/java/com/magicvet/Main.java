package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z]{3,}$";



    public static void main(String[] args) {
        run();
    }
    static void run() {
        if (auth()) {
            registerNewClient();
        }

    }

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");

            }
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");

        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Pleas provide client details.");
        System.out.println("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            Client client = buildClient(email);
            System.out.println("New client: " + client.firstName + " " + client.LastName + " (" +client.email + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
    }

     static Client buildClient(String email) {
         Client client = new Client();
         client.email = email;

         System.out.println("First name: ");
         client.firstName  = validateName(SCANNER.nextLine(), "First name");

         System.out.println("Last name: ");
         client.LastName  = validateName(SCANNER.nextLine(), "Last name");
         return client;
    }

     static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    static String validateName(String name, String fieldName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);

        if (matcher.matches()) {
            return name;
        } else {
            System.out.println("Invalid " + fieldName + ". Pleas enter a valid " + fieldName + ".");
            return validateName(SCANNER.nextLine(), fieldName);
        }
    }
}