package main.java.com.magicvet.service;

import main.java.com.magicvet.model.Client;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Client registerNewClient() {
        Client client;
        System.out.println("Please provide client details.");

        String email;
        do {
            System.out.println("Email: ");
            email = SCANNER.nextLine();
            if (isEmailValid(email)) {
                System.out.println("Provided email is invalid. Please enter a valid email.");
            }
        } while (!isEmailValid(email));

        client = buildClient(email);
        System.out.println("New client: " + client.getFirstName() + " "
                + client.getLastName() + " ("
                + client.getEmail() + ")");
        return client;
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.println("First name: ");
        client.setFirstName(validateName(SCANNER.nextLine(), "First name"));

        System.out.println("Last name: ");
        client.setLastName(validateName(SCANNER.nextLine(), "Last name"));
        return client;
    }

    private static boolean isEmailValid(String email) {
        String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static String validateName(String name, String fieldName) {
        String NAME_PATTERN = "^[a-zA-Z]{3,}$";
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);

        if (matcher.matches()) {
            return name;
        } else {
            System.out.println("Invalid " + fieldName + ". Please enter a valid " + fieldName + ".");
            return validateName(SCANNER.nextLine(), fieldName);
        }
    }
}

