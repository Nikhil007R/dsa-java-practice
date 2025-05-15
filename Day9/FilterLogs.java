package Day9;

import java.util.*;

public class FilterLogs {

    public static List<String[]> ErrorAndCriticalLogs(String logs[][]){

        List<String[]> errorsOnly = new ArrayList<>();

//        add krdo jinka status error ya fir critical hai
        for(String[] log: logs){
            String status = log[2];

            if(status.equals("ERROR") || status.equals("CRITICAL")){
                errorsOnly.add(log);
            }
        }

        Collections.sort(errorsOnly, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {

//              [01, 01, 2023] date in form of array aa jaayegi
                String[] date1 = o1[0].split("-");
                String[] date2 = o2[0].split("-");

//              [14, 00] time in form of array HH:MM
                String[] time1 = o1[1].split(":");
                String[] time2 = o2[1].split(":");

//                2023 01 01 14 00 ye hai meri value date + time ki
                String dateAndTime1 = date1[2] + date1[1] + date1[0] + time1[0] + time1[1];
                String dateAndTime2 = date2[2] + date2[1] + date2[0] + time2[0] + time2[1];

                return dateAndTime1.compareTo(dateAndTime2);

            }
        });

        return errorsOnly;
    }

    public static void main(String[] args) {


        String logs[][] = {
                {"01-01-2023", "14:00", "ERROR", "failed"},
                {"01-01-2023", "15:00", "INFO", "established"},
                {"01-01-2023", "01:30", "ERROR", "failed"}
        };

        List<String[]> answer = ErrorAndCriticalLogs(logs);

        for(String[] ans: answer ){
            System.out.println(Arrays.toString(ans));
        }
    }
}
