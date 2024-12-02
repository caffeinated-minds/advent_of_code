import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathToText = "numbers.txt";

        List<Integer> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();
        List<String>  eachLine = new ArrayList<>();
        int absoluteDiff = 0;

        try {
            // Read file content into a list of lines
            eachLine = Files.readAllLines(Paths.get(pathToText));
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // split into two lists
        for (String line : eachLine) {
            // Split the line into two numbers
            String[] eachNum = line.split(" ");
            list01.add(Integer.parseInt(eachNum[0]));
            list02.add(Integer.parseInt(eachNum[1]));
        }

        Collections.sort(list01);
        Collections.sort(list02);

        for (int i = 0; i < list01.size(); i++) {

            int diff = Math.abs(list01.get(i) - list02.get(i));
            absoluteDiff = absoluteDiff + diff;
        }

        System.out.println(absoluteDiff);
        System.out.println(countList01(list01,list02));
    }

    // count how many times a number in list01 is in list02
    public static int countList01(List<Integer> l1, List<Integer> l2) {
        int absoluteSim = 0;
        for (int i = 0; i < l1.size(); i++) {
            int toCompare = l1.get(i);
            int sim = count02(toCompare, l2) * toCompare;
            absoluteSim = absoluteSim + sim;
            }
            return absoluteSim;
        }

    public static int count02(int c, List<Integer> l){
        int counter = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == c){
                counter++;
            }
        }
        return counter;
    }


}
