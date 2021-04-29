package hu.nive.ujratervezes.io.phonebook;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {

        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        List<String> names = new ArrayList<>(contacts.keySet());
        File csvOutputFile = new File(output);

        try (FileWriter fw = new FileWriter(csvOutputFile, true)) {

            for (int i = 0; i < names.size(); i++) {

                if (i == contacts.size() - 1) {
                    fw.append(names.get(i)).append(": ").append(contacts.get(names.get(i)));
                    fw.flush();
                } else {
                    fw.append(names.get(i)).append(": ").append(contacts.get(names.get(i))).append("\n");
                    fw.flush();
                }

            }

        } catch (Exception e) {
            System.out.println("An error occurred while exporting");
        }

    }
}