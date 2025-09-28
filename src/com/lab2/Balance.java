package com.lab2;

/**
 * Класс для представления весов с двумя чашами
 */
public class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addLeft(int weight) {
        if (weight > 0) {
            leftWeight += weight;
        }
    }

    public void addRight(int weight) {
        if (weight > 0) {
            rightWeight += weight;
        }
    }

    public String result() {
        if (leftWeight == rightWeight) {
            return "=";
        } else if (rightWeight > leftWeight) {
            return "R";
        } else {
            return "L";
        }
    }

    public int getLeftWeight() {
        return leftWeight;
    }

    public int getRightWeight() {
        return rightWeight;
    }
}