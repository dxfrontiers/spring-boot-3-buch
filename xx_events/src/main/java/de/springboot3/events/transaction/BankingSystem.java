package de.springboot3.events.transaction;

import org.springframework.stereotype.Component;

@Component
public class BankingSystem {

    public void doTransfer(int sourceAccountId, int targetAccountId, int amount) {
        // some very secure and safe money transaction logic ...
    }
}
