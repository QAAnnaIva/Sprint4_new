package ru.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String testData;
    private final boolean expected;

    public AccountTest(String testData, boolean expected) {
        this.testData = testData;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] checkString() {
        return new Object[][] {
                // Имя содержит 19 символов, среди которых 1 пробел
                { " РиMский-КорSаков NA ", true},

                // Имя содержит 1 пробел и 2 символа
                { "      М Л          ", true},

                // Имя содержит минимальное допустимое количество символов, но нет обязательного пробела
                { "   Te                  ", false},

                // Имя выходит за границу верхнего диапазона по кол-ву символов
                { "          Риmский-Корsаков N.A                  ", false},

                // Имя содержит допустимое количество символов, но среди них 2 пробела, что недопустимо
                { "          T  e                  ", false},

                // Только пробелы
                { "                           ", false},

                // пустая строка
                { "", false},

                // null
                { null, false},

                // не стала писать тест на граничное значение в 2 символа, т.к. в одном тесте нужно проверять что-то одно
                // а у нас в таком случае не ясно что проверяется: или отсутствие пробела, или выход за нижнюю границу диапазона

        };
    }



    // Имя содержит 19 символов, среди которых 1 пробел
    @Test
    public void testCases()  {

        Account account = new Account(testData);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
        System.out.println(actual);

    }



}
