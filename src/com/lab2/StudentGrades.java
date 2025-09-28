package com.lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentGrades {

    public static class StudentStats {
        private final String name;
        private final double averageGrade;
        private final List<Integer> grades;

        public StudentStats(String name, List<Integer> grades) {
            this.name = name;
            this.grades = new ArrayList<>(grades);
            this.averageGrade = calculateAverage(grades);
        }

        private double calculateAverage(List<Integer> grades) {
            if (grades.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }

        public String getName() {
            return name;
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        @Override
        public String toString() {
            return String.format("%s: %.2f", name, averageGrade);
        }
    }

    private final Map<String, StudentStats> students;

    public StudentGrades() {
        students = new HashMap<>();
    }

    public Map<String, StudentStats> analyze(String filename) {
        students.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processStudentLine(line);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден!");
            return null;
        }

        return new HashMap<>(students);
    }

    private void processStudentLine(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            return;
        }

        String name = parts[0];
        List<Integer> grades = new ArrayList<>();

        for (int i = 1; i < parts.length; i++) {
            try {
                int grade = Integer.parseInt(parts[i]);
                if (grade >= 1 && grade <= 5) {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                // Пропускаем некорректные оценки
            }
        }

        if (!grades.isEmpty()) {
            students.put(name, new StudentStats(name, grades));
        }
    }

    public String bestStudent() {
        if (students.isEmpty()) {
            return null;
        }

        return students.values().stream()
                .max((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()))
                .map(StudentStats::getName)
                .orElse(null);
    }

    public String worstStudent() {
        if (students.isEmpty()) {
            return null;
        }

        return students.values().stream()
                .min((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()))
                .map(StudentStats::getName)
                .orElse(null);
    }

    public void printAllStudents() {
        for (StudentStats student : students.values()) {
            System.out.println(student);
        }
    }
}