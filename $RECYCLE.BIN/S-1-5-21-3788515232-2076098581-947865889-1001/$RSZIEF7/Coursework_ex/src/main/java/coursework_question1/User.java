package coursework_question1;

public class User {
    private String fullName;

    public String getName() {
        return fullName.substring(0, fullName.indexOf(' '));
    }

    public User(String fullName) {
        this.fullName = fullName;
    }

    public User() {
    }

    @Override
    public String toString() {
        return fullName;
    }
}
