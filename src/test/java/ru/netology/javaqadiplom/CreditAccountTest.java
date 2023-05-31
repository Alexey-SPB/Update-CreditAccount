package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {

    @Test // пополнение счета при нулевом балансе
    public void testAdd1() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        account.add(3_000);
        assertEquals(3_000, account.getBalance());
    }

    @Test // пополнение счета при ненулевом балансе
    public void testAdd2() {
        CreditAccount account = new CreditAccount(1000, 5_000, 15);
        account.add(3_000);
        assertEquals(4_000, account.getBalance());
    }

    @Test // пополнение счета при отрицательном значении amount
    public void testAdd3() {
        CreditAccount account = new CreditAccount(1000, 5_000, 15);
        account.add(-3_000);
        assertEquals(1_000, account.getBalance());
    }

    @Test // пополнение счета при нулевом значении amount
    public void testAdd4() {
        CreditAccount account = new CreditAccount(1000, 5_000, 15
        );
        account.add(0);
        assertEquals(1_000, account.getBalance());
    }

    @Test // пополнение счета при отрицательном значении balance
    public void testAdd5() {
        CreditAccount account = new CreditAccount(-1000, 5_000, 15
        );
        account.add(3_000);
        assertEquals(2_000, account.getBalance());
    }

    @Test //проверка исключения при положительных параметрах
    public void testException1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(5000, 1_000, 15);
        });
    }

    @Test // проверка исключения при отрицательной rate
    public void testException2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(5000, 1_000, -15);
        });
    }

    @Test // проверка исключения при отрицательной initialBalance
    public void testException3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-500, 1_000, 15);
        });

    }

    @Test // проверка исключения при отрицательной creditLimit
    public void testException4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(500, -1_000, 15);
        });
    }

    @Test // проверка оплаты при положительном balance (amount<balance)
    public void testPay1() {
        CreditAccount account = new CreditAccount(500, 1000, 15);
        account.pay(200);
        assertEquals(300, account.getBalance());
    }

    @Test // проверка оплаты при положительном balance (amount>balance)
    public void testPay2() {
        CreditAccount account = new CreditAccount(500, 1000, 15);
        account.pay(700);
        assertEquals(-200, account.getBalance());
    }

    @Test // проверка оплаты при отрицательном amount
    public void testPay3() {
        CreditAccount account = new CreditAccount(500, 1000, 15);
        account.pay(-700);
        assertEquals(500, account.getBalance());
    }

    @Test // проверка оплаты при отрицательном balance не превышающий creditLimit
    public void testPay4() {
        CreditAccount account = new CreditAccount(-500, 1000, 15);
        account.pay(500);
        assertEquals(-1000, account.getBalance());
    }

    @Test // проверка оплаты при превышении creditLimit
    public void testPay5() {
        CreditAccount account = new CreditAccount(1000, 1000, 15);
        account.pay(3000);
        assertEquals(1000, account.getBalance());
    }
    @Test //расчет ставки при задолженности
    public void testRate1() {
        CreditAccount account = new CreditAccount(-500, 1000, 15);
               assertEquals(-75, account.yearChange());
    }

    @Test //расчет ставки при нулевом balance
    public void testRate2() {
        CreditAccount account = new CreditAccount(0, 1000, 15);
        assertEquals(0, account.yearChange());
    }

    @Test //расчет ставки при положительном balance
    public void testRate3() {
        CreditAccount account = new CreditAccount(100, 1000, 15);
        assertEquals(0, account.yearChange());
    }
}