package ru.praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {


    // Имя содержит 19 символов, среди которых 1 пробел
    @Test
    public void checkUpperLimit()  {

        Account account = new Account(" РиMский-КорSаков NA ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(true, actual);
        System.out.println(actual);

    }

    // Имя содержит 1 пробел и 2 символа
    @Test
    public void checkLowerLimit()  {

        Account account = new Account("      М Л          ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(true, actual);
        System.out.println(actual);

    }

    // Имя содержит минимальное допустимое количество символов, но нет обязательного пробела
    @Test
    public void check0Space()  {

        Account account = new Account("   Te                  ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(false, actual);
        System.out.println(actual);

    }

    // Имя выходит за границу верхнего диапазона по кол-ву символов
    @Test
    public void nameContains1SpaceAnd19Symbols()  {

        Account account = new Account("          Риmский-Корsаков N.A                  ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(false, actual);
        System.out.println(actual);

    }

    // Имя содержит допустимое количество символов, но среди них 2 пробела, что недопустимо
    @Test
    public void check2Spaces()  {

        Account account = new Account("          T  e                  ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(false, actual);
        System.out.println(actual);

    }


    // Только пробелы
    @Test
    public void checkSpaces()  {

        Account account = new Account("                           ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(false, actual);
        System.out.println(actual);

    }

    // не стала писать тест на граничное значение в 2 символа, т.к. в одном тесте нужно проверять что-то одно
    // а у нас в таком случае не ясно что проверяется: или отсутствие пробела, или выход за нижнюю границу диапазона


}
