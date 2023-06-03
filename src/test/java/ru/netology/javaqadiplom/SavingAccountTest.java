package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test  //пополнение баланса меньше максимального значения
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test  //рассчет пополнения по готовой ставке
    public void shouldCalculateYearChange() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(450, account.yearChange());
    }

    @Test  //проверка оплаты в допустимом диапазоне
    public void shouldPayMoreMinBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertTrue(account.pay(1_000));
    }

    @Test  //проверка оплаты с остатком меньше минимального
    public void shouldPayAboveMinBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertFalse(account.pay(4000));
    }

    @Test  //установка отрицательного значения годовой ставки
    public void shouldThrowRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }

    @Test  ///проверка пополнения баланса больше макисмального значения
    public void shouldAddAboveThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test  //установка положительной годовой ставки
    public void shouldFindYearChange() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(15, account.getRate());
    }

    @Test  //проверка пополнения баланса до максимального значения
    public void shouldAddIntoMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }


    @Test //проверка оплаты до минимального значения
    public void shouldPayToMinBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertTrue(account.pay(2_000));
    }

    @Test  //расчет годовой ставки при отрицательном балансе
    public void shouldFindYearChangeWithUnderZeroBalance() {
        SavingAccount account = new SavingAccount(
                -200,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test  //сравнение минимального и максимального балансов
    public void shouldThrowMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    11_000,
                    10_000,
                    5
            );
        });
    }
    @Test  //сравнение минимального и максимального балансов
    public void shouldThrowInitialBalanceAboveZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -1_000,
                    11_000,
                    10_000,
                    5
            );
        });
    }
}
