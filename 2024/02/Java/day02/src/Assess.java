import java.util.ArrayList;

public class Assess {

    // these don't ever change
    public final int min_diff = 1;
    public final int max_diff = 3;

    // ArrayList instead of Array, as size needs to be dynamic.
    public ArrayList<Integer> parsedReportInts = new ArrayList<>();
    public boolean isSafe;
    public boolean isSequential;
    public boolean isMinMax;

    public boolean assessSafety(String report){
        ArrayList<Integer> convertedReport = convertReport(report);

        // check sequential 
        boolean sequential = sequential(convertedReport);

        if (sequential == true){
        // check gaps min-max diff
        boolean minMaxDiff = minMaxCheck(convertedReport);
                if (minMaxDiff) {
                    isSafe =  true;
                } else {
                    isSafe = false;
                }
        } else {
            isSafe = false;
        }
        return isSafe;
    }


    public boolean minMaxCheck(ArrayList<Integer> report){
        if (report.size() < 2) {
            return true; // A single element or empty list trivially satisfies the condition.
        }
    
        for (int i = 0; i < report.size() - 1; i++) {
            int diff = Math.abs(report.get(i) - report.get(i + 1));
            if (diff < min_diff || diff > max_diff) {
                return false; // Difference is out of bounds.
            }
        }
        return true;
    }

    public boolean sequential(ArrayList<Integer> report) {
        if (report.size() < 2) {
            return false; // A sequence with less than 2 elements cannot be sequential.
        }
    
        boolean increasing = report.get(0) < report.get(1);
    
        for (int i = 1; i < report.size() - 1; i++) {
            if (increasing && report.get(i) >= report.get(i + 1)) {
                return false; // Not strictly increasing.
            }
            if (!increasing && report.get(i) <= report.get(i + 1)) {
                return false; // Not strictly decreasing.
            }
        }
        return true;
    }

    public ArrayList<Integer> convertReport(String report){
        parsedReportInts.clear();
        String[] parsedReport = report.split(" ");

        // need to be able to compare the array elements. 
        for (int i = 0; i < parsedReport.length; i++) {
            int eachNum = Integer.parseInt(parsedReport[i]);
            parsedReportInts.add(eachNum);
        }
        System.out.println(parsedReportInts);
        return parsedReportInts;
    }


}
