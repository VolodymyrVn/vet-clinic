package main.java.com.magicvet.service;

import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.java.com.magicvet.Main.SCANNER;
import static main.java.com.magicvet.Main.validateName;

public class ClientService {


    public Client registerNewClient() {
        Client client = null;
        System.out.println("Pleas provide client details.");
        System.out.println("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
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
}
