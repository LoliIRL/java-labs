package geometry2d;

import exceptions.InvalidFigureException;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) throws InvalidFigureException {
        if (radius <= 0) {
            throw new InvalidFigureException("Радиус должен быть положительным");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Круг (радиус = %.2f, площадь = %.2f, периметр = %.2f)",
                radius, area(), perimeter());
    }

    public double getRadius() {
        return radius;
    }
}