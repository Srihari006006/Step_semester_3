package week_7.class_problems;

class LockerData {
    private String code;
    private final int lockerNumber;

    LockerData(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    void changeCode(String oldCode, String newCode) {

        if (code.equals(oldCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        }
        else {
            System.out.println("Wrong code. Change rejected");
        }
    }
}

public class Locker {
    public static void main(String[] args) {

        LockerData l = new LockerData(101, "1234");

        l.changeCode("1234", "5678");

        l.changeCode("0000", "9999");
    }
}