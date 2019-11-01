
/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  This class read the text files in txtFiles directory and selectes random information (Address, phone number, name and etc..)
 *          It also returns random integers(for numbers) and doubles(for prices).
 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetRandom {
    // Empty constructor
    public GetRandom() {

    }

    /**
     * This program will read a text file and returns the string on the given line
     * This is used to select random name, phone nubmer or adress in txtFiles.
     * 
     * @param fileName   string Path
     * @param lineNumber int line number
     * @return String text
     * @throws Exception any
     */
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

    /**
     * This gets the number of lines in text file so when generating a number we do
     * not exceed the number of lines in text file
     * 
     * @param fileName String path
     * @return int total line number
     * @throws IOException
     */
    private int getLineCount(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lines = 0;
        while (reader.readLine() != null)
            lines++;
        reader.close();
        return lines;
    }

    /**
     * Get random int from given min to given max Used for selecting random line in
     * text files and to assign random number to agent and property
     * 
     * @param min int
     * @param max int
     * @return int
     */
    public int randInt(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    /**
     * Get random double from given min to given max. Used to generate random price
     * 
     * @param min
     * @param max
     * @return double
     */
    public double randDouble(int min, int max) {
        return (((Math.random() * max) + min) * 100.0) / 100.0;
    }

    /**
     * Gets random name from the txtFiles/names.txt
     * 
     * @return String
     */
    public String name() {
        String path = "JavaFiles/txtFiles/names.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Josh";
    }

    /**
     * Gets random phone number from the txtFiles/phoneNumbers.txt
     * 
     * @return String
     */
    public String phoneNumber() {
        String path = "JavaFiles/txtFiles/phoneNumbers.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "412-555-555";
    }

    /**
     * Gets random adress from the txtFiles/address.txt
     * 
     * @return String
     */
    public String adress() {
        String path = "JavaFiles/txtFiles/address.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "836 Hillcrest Ave. ";
    }

    /**
     * Gets random company name from the txtFiles/companies.txt
     * 
     * @return String
     */
    public String companyName() {
        String path = "JavaFiles/txtFiles/companies.txt";
        try {
            return readFile(path, randInt(0, getLineCount(path) - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sony";
    }
}