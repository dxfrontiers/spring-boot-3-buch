package de.springboot3.java.mixed;

class GreetingService {

    private final UserDatabase userDatabase;

    public GreetingService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public String greet(Integer userId) {
        User user = userDatabase.findUser(userId);
        return "Hello " + user.getName();
    }

}
