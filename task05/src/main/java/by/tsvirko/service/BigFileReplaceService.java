package main.java.by.tsvirko.service;

import java.io.*;

public class BigFileReplaceService {
    private final String FILE_PATH = "task05/src/main/resources/files/";

    public String removeNonAlphanumeric(String str) {
        str = str.replaceAll("[^\\p{L}\\s]", "");
        str = str.replaceAll("\\s{2,}", " ").trim();
        return str;
    }

    public void removeNonAlphanumericFile(String filename) throws IOException {
        readBigFile(filename);
    }

    private void readBigFile(String fileName) throws IOException {
        File file = new File(FILE_PATH.concat(fileName));
        File temp = File.createTempFile(file.getName(), null);
        BufferedReader reader = null;
        PrintStream writer = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            writer = new PrintStream(temp);

            String line;
            while ((line = reader.readLine()) != null) {
                line = removeNonAlphanumeric(line);
                writer.println(line);
            }
        } finally {
            if (writer != null) writer.close();
            if (reader != null) reader.close();
        }
        if (!file.delete()) throw new IOException("Failed to remove " + file.getName());
        if (!temp.renameTo(file)) throw new IOException("Failed to replace " + file.getName());
    }
}
