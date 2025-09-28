package com.lab2;

/**
 * Класс для представления кнопки с подсчетом нажатий
 */
public class Button {
    private int clickCount;

    /**
     * Конструктор по умолчанию
     */
    public Button() {
        this.clickCount = 0;
    }

    /**
     * Метод для имитации нажатия на кнопку
     * Увеличивает счетчик нажатий и выводит текущее значение
     */
    public void click() {
        clickCount++;
        System.out.println("Количество нажатий: " + clickCount);
    }

    /**
     * Геттер для получения количества нажатий
     * @return текущее количество нажатий
     */
    public int getClickCount() {
        return clickCount;
    }
}