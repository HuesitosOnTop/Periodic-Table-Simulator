package Handlers;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandler {
    private static File data_folder = new File(".\\Data");
    private static File elements_folder = new File(".\\Elements");
    private static File user_data = new File(data_folder.getAbsolutePath() + "\\user.dat");

    private static File[] all_files = {
        data_folder,
        elements_folder,
        user_data
    };

    public static void CreateDependecies() {
        ArrayList<String> paths = new ArrayList<String>();

        // Adds the paths of files that do not exist
        for (int i = 0; i < all_files.length; i++) {
            if (!all_files[i].exists()) {
                paths.add(all_files[i].getAbsolutePath());
            }
        }

        if (!paths.isEmpty()) {
        // Creates the files based off of it's path
            for (int i = 0; i < paths.size(); i++) {
                File to_create = new File(paths.get(i));

                // Check to see if it's a dat file, else create a folder
                if (paths.get(i).contains(".dat")) {
                    try {
                        to_create.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    to_create.mkdir();
                }
            }
            System.out.println("All files created");
        } else {
            System.out.println("All files here");
        }
    }
    // Saves to the specified file
    public static void SaveFile(File file, String lock, String key) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(lock + "=" + key + ";" + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[] LoadData(int amount, File file) {
        String[] values = new String[amount];

        try {
            Scanner file_reader = new Scanner(file);
            int index = 0;

            while (file_reader.hasNextLine() && index < amount) {
                String data = file_reader.nextLine();

                int equals_location = data.indexOf("=");
                int semicolon_location = data.indexOf(";");

                String unlocked_data = data.substring(equals_location+1, semicolon_location);

                values[index] = unlocked_data;
                index++;
            }
            file_reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return values;
	}

    public static File GetFile(int array_location) {
        return all_files[array_location];
    }

    public static boolean DoesFileExists(int array_location) {
        return all_files[array_location].exists();
    }
}
