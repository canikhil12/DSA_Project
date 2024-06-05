import com.weather.stats.YearAvg;
import java.io.File; 
import java.io.FileNotFoundException; 

import java.io.IOException;
import java.io.PrintStream;

import java.util.Arrays;
import java.util.Scanner; 

/**
 * Create the Main Java Class and Create Collection Data Structures based on the CSV data.
 * 
 */
public class Main {

    public static void main(final String[] args) {
        // Create Class -Class name matches Filename
        // PSVM method required to run this as an application
        // starting point for the desktop application.

        // The YearAvg class is Based on CSV file data
        final int SZ = 66;

        YearAvg yearAvg = new YearAvg(10.0f, 1955, 12.3f);

        System.out.println(yearAvg);
        
        YearAvg[] yearAvgs = new YearAvg[SZ];

        yearAvgs[0] = new YearAvg(10.0, 1955, 12.3);
        yearAvgs[1] = new YearAvg(20.0, 1975, 22.0);
        System.out.println(yearAvgs[0]);
        System.out.println(yearAvgs[1]);
        System.out.println(yearAvgs[2]);
        String header = "";
        int size = 0;
        try {
            File file = new File("yearly.csv");
            Scanner fileIn = new Scanner(file);
            header = fileIn.nextLine();
            while (fileIn.hasNextLine()) {
                String data = fileIn.nextLine();
                System.out.println(data);
                String [] strArray = data.split(",");
                
                yearAvgs[size] = 
                 new YearAvg(Double.parseDouble(strArray[0]), 
                 Integer.parseInt(strArray[1]),
                 Double.parseDouble(strArray[2]));
                size++;
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read the file.");
            e.printStackTrace();
        }
        System.out.println(yearAvgs.length);
        
        Arrays.sort(yearAvgs);
        try {
            PrintStream fileStream = new PrintStream(new File("sorted.txt"));
            fileStream.println(header);
            for (YearAvg yearAvg2 : yearAvgs) {
                fileStream.println(yearAvg2.toCSV());
                System.out.println(yearAvg2.toCSV());
            }
            fileStream.close();
          } catch (IOException e) {
            System.out.println("Falied to write the file.");
            e.printStackTrace();
          }
        
        System.out.println(size);


    }
}