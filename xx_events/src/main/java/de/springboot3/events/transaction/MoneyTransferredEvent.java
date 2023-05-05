package de.springboot3.events.transaction;

public record MoneyTransferredEvent(int sourceAccountId, int targetAccountId, int amount) {
}
