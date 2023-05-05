package de.springboot3.events;

import de.springboot3.events.transaction.BankingSystem;
import de.springboot3.events.transaction.TransactionService;
import de.springboot3.events.user.User;
import de.springboot3.events.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@SpringBootTest
class EventsApplicationTests {

    @MockBean
    private BankingSystem bankingSystem;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Test
    void transfersMoneyWhenUserUnlocked() {
        userService.createUser(new User(42, "Bob"));
        transactionService.transferMoney(42, 1, 2, 1_000_000);
        verify(bankingSystem).doTransfer(eq(1), eq(2), eq(1_000_000));
    }

    @Test
    void doesNotTransfersMoneyWhenUserLocked() {
        userService.createUser(new User(42, "Bob"));
        userService.lockUser(42);

        assertThrows(RuntimeException.class, () -> {
            transactionService.transferMoney(42, 1, 2, 1_000_000);
        });

        verifyNoInteractions(bankingSystem);
    }

}
