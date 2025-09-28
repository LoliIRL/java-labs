package com.lab2;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import exceptions.InvalidFigureException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование лабораторной работы 2 ===");

        // Тестирование Button
        System.out.println("\n1. Тестирование Button:");
        Button button = new Button();
        button.click();
        button.click();
        button.click();

        // Тестирование Balance
        System.out.println("\n2. Тестирование Balance:");
        Balance balance = new Balance();
        balance.addLeft(10);
        balance.addRight(15);
        System.out.println("Результат: " + balance.result());
        balance.addLeft(5);
        System.out.println("Результат: " + balance.result());

        // Тестирование Bell
        System.out.println("\n3. Тестирование Bell:");
        Bell bell = new Bell();
        bell.sound();
        bell.sound();
        bell.sound();

        // Тестирование OddEvenSeparator
        System.out.println("\n4. Тестирование OddEvenSeparator:");
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);
        separator.even();
        separator.odd();

        // Тестирование Table
        System.out.println("\n5. Тестирование Table:");
        Table table = new Table(3, 3);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(0, 2, 3);
        table.setValue(1, 0, 4);
        table.setValue(1, 1, 5);
        table.setValue(1, 2, 6);
        table.setValue(2, 0, 7);
        table.setValue(2, 1, 8);
        table.setValue(2, 2, 9);

        System.out.println("Таблица:");
        System.out.println(table);
        System.out.printf("Среднее значение: %.2f\n", table.average());

        // Тестирование геометрических фигур
        System.out.println("\n6. Тестирование геометрических фигур:");
        try {
            Circle circle = new Circle(5.0);
            Rectangle rectangle = new Rectangle(4.0, 6.0);
            Cylinder cylinder = new Cylinder(circle, 10.0);

            System.out.println(circle);
            System.out.println(rectangle);
            System.out.println(cylinder);
        } catch (InvalidFigureException e) {
            System.out.println("Ошибка создания фигуры: " + e.getMessage());
        }

        // Тестирование FileAnalyzer
        System.out.println("\n7. Тестирование FileAnalyzer:");
        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        FileAnalyzer.FileStats stats = fileAnalyzer.analyze("test.txt");
        if (stats != null) {
            System.out.println(stats);
        }

        // Тестирование StudentGrades
        System.out.println("\n8. Тестирование StudentGrades:");
        StudentGrades studentGrades = new StudentGrades();
        studentGrades.analyze("grades.txt");
        studentGrades.printAllStudents();

        System.out.println("Лучший студент: " + studentGrades.bestStudent());
        System.out.println("Худший студент: " + studentGrades.worstStudent());
    }
}