package geometry3d;

import geometry2d.Figure;
import exceptions.InvalidFigureException;

public class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) throws InvalidFigureException {
        if (base == null) {
            throw new InvalidFigureException("Основание не может быть null");
        }
        if (height <= 0) {
            throw new InvalidFigureException("Высота должна быть положительной");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    public Figure getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("Цилиндр (основание: %s, высота = %.2f, объем = %.2f)",
                base.toString(), height, volume());
    }
}