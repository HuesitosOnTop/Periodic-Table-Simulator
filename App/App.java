package App;

// Personal packages
import Handlers.ArrayHelper;
import Handlers.FileHandler;
import Handlers.User;

// Java packages
import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        Scanner user_input = new Scanner(System.in);
        String input = "";
        File user_dat = new File("");

        // Checks to see if the user file exists, and if it doesnt, create all files
        if (FileHandler.DoesFileExists(2)) {
            user_dat = new File(FileHandler.GetFile(2).getAbsolutePath());
            User.LoadUser();
        } else {
            FileHandler.CreateDependecies();
            user_dat = new File(FileHandler.GetFile(2).getAbsolutePath());
        }
        
        if (User.return_userstate() == true) {
            System.out.print("It seems like you're new here, please enter your name: ");
            String name = user_input.next();
            FileHandler.SaveFile(user_dat, "name", name);
            FileHandler.SaveFile(user_dat, "isnew","false");
        } else {
            System.out.println("Welcome, " + User.return_username());
        }

        String[] choices = {
            "Simulations",
            "Elements",
            "Equations",
            "Help",
            "Config\n"
        };
        
        String[] config_choices = {
            "Add an Element",
            "Delete an Element",
            "Exit\n"
        };

        ArrayHelper.ListArray(choices);
        input = user_input.next();

        switch (input) {
            case "5":
                ArrayHelper.ListArray(config_choices);
                input = user_input.next();

                switch (input) {
                    case "1":
                        System.out.print("Enter the name of the element: ");
                        input = user_input.next();

                        //FileHandler.CreateFile(input, "../Elements", "element");
                    case "2":
                    case "3":
                        break;
                    default:
                        System.out.println("Another Error ts");
                }
            default:
                System.out.println("Error ts");
        }
        user_input.close();
    }
}

