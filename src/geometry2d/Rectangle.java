package geometry2d;

import exceptions.InvalidFigureException;

public class Rectangle implements Figure {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) throws InvalidFigureException {
        if (width <= 0 || height <= 0) {
            throw new InvalidFigureException("Ширина и высота должны быть положительными");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник (ширина = %.2f, высота = %.2f, площадь = %.2f, периметр = %.2f)",
                width, height, area(), perimeter());
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}