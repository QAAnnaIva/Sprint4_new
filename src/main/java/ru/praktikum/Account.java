package ru.praktikum;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */


        String trimmedName = name.trim();

        if (trimmedName.length() >= 3 && trimmedName.length() <= 19) {

            int num = 0;
            for (int i = 0; i < trimmedName.length(); i++) {
                char ch = trimmedName.charAt(i);
                if (ch == ' ')
                    num++;

            }
            System.out.println(num);
            if (num == 1) {
                return true;
            }

        }


        return false;
    }
}
