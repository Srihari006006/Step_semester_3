package week_7.class_problems;

class Name {
    private final String firstName;
    private final String lastName;

    Name(String fullName) {

        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class NameTag {
    public static void main(String[] args) {

        NameTagExample tag = new NameTagExample("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}

class NameTagExample {
    private final String firstName;
    private final String lastName;

    NameTagExample(String fullName) {

        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}