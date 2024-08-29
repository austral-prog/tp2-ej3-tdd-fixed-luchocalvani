package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }
    @Test
    void testNegativeDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "juan", -5);
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    void testNoAccountDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "pedro", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void test1Withdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }
    @Test
    void test2Withdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", 20);
        assertEquals(0, updatedAccounts.get("juan"));
    }
    @Test
    void testNegativeWithdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", -5);
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    void testNoAmountWithdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 15);
        assertEquals(10, updatedAccounts.get("mati"));
    }
    @Test
    void testNoAccountWithdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "pedro", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void test1Transfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        assertEquals(25, updatedAccounts.get("juan"));
    }
    @Test
    void test2Transfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 10);
        assertEquals(0, updatedAccounts.get("mati"));
        assertEquals(30, updatedAccounts.get("juan"));
    }
    @Test
    void testNegativeTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", -5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    void testNoAmountTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 15);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    void testNoAccount1Transfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "pepe", "juan", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void testNoAccount2Transfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "pedro", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void testSameAccountTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

}
