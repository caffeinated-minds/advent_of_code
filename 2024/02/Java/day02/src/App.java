import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> reports = new ArrayList<>();
        int howManySafe = 0;

        String pathToInput = "day02/lib/reports.txt";
        
        try {
        reports = Files.readAllLines(Paths.get(pathToInput));
        } catch (IOException e) {
            System.out.println("Text file of reports not found." + e.getMessage());
        };
        
        Assess newAssessObject = new Assess();

        // divide the reports

        for (String report : reports) {
            if (newAssessObject.assessSafety(report)) {
                howManySafe++;
            };
        }
        System.out.println(howManySafe);

    }
}