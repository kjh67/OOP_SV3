package uk.ac.cam.kjh67.q51;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentMarks {
    TreeMap<String, Double> marks;

    StudentMarks() { marks = new TreeMap<>(); }

    public void addEntry(String student, double percentage) {
        marks.put(student, percentage);
    }

    public List<String> getStudents() {
        return marks.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<String> getTopPPercentStudents(double p) {
        int number_of_students = (int) Math.floor(marks.size() * (p/100));
        return marks.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).map(Map.Entry::getKey).limit(number_of_students).collect(Collectors.toList());
    }

    public double medianScore() {
        // First, get a sorted array of the scores
        List<Double> scores = marks.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getValue).collect(Collectors.toList());
        return scores.get(scores.size()/2);
    }


    public static void main(String[] args) {
        StudentMarks marks = new StudentMarks();
        marks.addEntry("B", 32.8);
        marks.addEntry("E", 44.4);
        marks.addEntry("C", 58.6);
        marks.addEntry("A", 83.0);
        marks.addEntry("D", 98.1);

        System.out.println(marks.getStudents());
        System.out.println(marks.getTopPPercentStudents(80));
        System.out.println(marks.medianScore());

        // OUTPUT:
//          [A, B, C, D, E]
//          [D, A, C, E]
//          58.6
    }
}
