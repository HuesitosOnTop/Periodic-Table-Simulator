package Handlers;

import Handlers.FileHandler;

public class User {
    private static String[] data = {};
    private static String username = "";
    private static boolean isNew = true;

    public static void LoadUser() {
        data = FileHandler.LoadData(2, FileHandler.GetFile(2));
        username = data[0];
        isNew = Boolean.parseBoolean(data[1]);
    }

    public static boolean return_userstate() {
        return isNew;
    }

    public static String return_username() {
        return username;
    }
}
