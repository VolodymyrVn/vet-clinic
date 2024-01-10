package main.java.com.magicvet;
import main.java.com.magicvet.component.ApplicationRunner;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        ApplicationRunner runner = new ApplicationRunner();
        runner.run();
    }



    static String NAME_PATTERN = "^[a-zA-Z]{3,}$";


    public static String validateName(String name, String fieldName) {
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

