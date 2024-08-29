package com.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        Map<String, Integer> new_accounts = new HashMap<String, Integer>(accounts);
        if (new_accounts.containsKey(account) && amount > 0) {
            new_accounts.replace(account, accounts.get(account) + amount);
        }
        else if (!new_accounts.containsKey(account)) {
            return new_accounts;
        }
        return new_accounts;
    }
    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {
        Map<String, Integer> new_accounts = new HashMap<String, Integer>(accounts);
        if (!new_accounts.containsKey(account)) {
            return new_accounts;
        }
        else if (amount < 0 || new_accounts.get(account) == 0) {
            return new_accounts;
        }
        else if (new_accounts.get(account) >= amount){
            new_accounts.replace(account, accounts.get(account) - amount);
        }
        return new_accounts;
    }
    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String fromAccount, String toAccount, int amount) {
        Map<String, Integer> new_accounts = new HashMap<String, Integer>(accounts);
        if (new_accounts.containsKey(fromAccount) && new_accounts.containsKey(toAccount)){
            if (amount > 0){
                if (!Objects.equals(fromAccount, toAccount)){
                    if (new_accounts.get(fromAccount) >= amount){
                        new_accounts.replace(fromAccount, accounts.get(fromAccount) - amount);
                        new_accounts.replace(toAccount, accounts.get(toAccount) + amount);
                    }
                }
            }
        }
        return new_accounts;
    }

}
