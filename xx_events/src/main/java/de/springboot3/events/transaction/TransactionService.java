package de.springboot3.events.transaction;

import org.springframework.stereotype.Component;

@Component
public class TransactionService {

    private final TransactionDatabase database;
    private final BankingSystem bankingSystem;

    public TransactionService(TransactionDatabase database, BankingSystem bankingSystem) {
        this.database = database;
        this.bankingSystem = bankingSystem;
    }

    public void transferMoney(int userId, int sourceAccountId, int targetAccountId, int amount) {
        User user = database.getUser(userId);

        if (user == null) {
            throw new RuntimeException(String.format("user with id %d doesn't exist!", userId));
        }

        if (!user.locked()) {
            // transfer the money!
            bankingSystem.doTransfer(sourceAccountId, targetAccountId, amount);
        } else {
            throw new RuntimeException(String.format("user with id %d is locked", userId));
        }
    }


}
