package Handlers;

// This class is random QOL methods for arrays

public class ArrayHelper {
    // This method takes an array and lists it out in a numerical order
    public static void ListArray(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println((i+1) + ". " + strings[i]);
        } 
    }

    // This method is supposed to find a string in an array and return the string
    public static String FindString(String[] strings, String find) {
        return "";
    }
}
