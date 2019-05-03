
/**
 * GetRandomInfo
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetRandom {

    public GetRandom() {
    }

    private String readFile(String fileName, int lineNumber) throws Exception {
        // Construct BufferedReader from FileReader
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = null;
        int dstLine = 0; // destination line number
        while ((line = br.readLine()) != null && dstLine <= lineNumber) {
            dstLine++;
        }
        br.close();

        return line;

    }

    private int getLineCount(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lines = 0;
        while (reader.readLine() != null)
            lines++;
        reader.close();
        return lines;
    }

    public int randInt(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    public double randDouble(int min, int max) {
        return ((int) ((Math.random() * max) + min) * 100) / 100.0;
    }

    public String name() {
        String path = "txtFiles/names.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Josh";
    }

    public String phoneNumber() {
        String path = "txtFiles/phoneNumbers.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "412-555-555";
    }

    public String adress() {
        String path = "txtFiles/address.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "836 Hillcrest Ave. ";
    }

    public String companyName() {
        String path = "txtFiles/companies.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sony";
    }
}