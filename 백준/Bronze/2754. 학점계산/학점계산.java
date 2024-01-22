import java.io.*;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();
        String score = "";

        if (grade.equals("A+")) {
            score = "4.3";
        } else if (grade.equals("A0")) {
            score = "4.0";
        } else if (grade.equals("A-")) {
            score = "3.7";
        } else if (grade.equals("B+")) {
            score = "3.3";
        } else if (grade.equals("B0")) {
            score = "3.0";
        } else if (grade.equals("B-")) {
            score = "2.7";
        } else if (grade.equals("C+")) {
            score = "2.3";
        } else if (grade.equals("C0")) {
            score = "2.0";
        } else if (grade.equals("C-")) {
            score = "1.7";
        } else if (grade.equals("D+")) {
            score = "1.3";
        } else if (grade.equals("D0")) {
            score = "1.0";
        } else if (grade.equals("D-")) {
            score = "0.7";
        } else {
            score = "0.0";
        }

        System.out.println(score);
    }
}