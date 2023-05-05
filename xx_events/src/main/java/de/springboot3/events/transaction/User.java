package de.springboot3.events.transaction;

public record User(int id, boolean locked) {

    public static final Boolean LOCKED = Boolean.TRUE;
    public static final Boolean UNLOCKED = Boolean.FALSE;
}
