package week_5.class_problems;

public class podiumfinder {
    
    static String findPodium(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second && score < first) {
                third = second;
                second = score;
            } else if (score > third && score < second) {
                third = score;
            }
        }

        return "Podium: 1st: " + first + ", 2nd: " + second + ", 3rd: " + third;
    }

    public static void main(String[] args) {

        int[] scores = {45,82,79,90,30,90,61};

        System.out.println(findPodium(scores));
    }   
    
}
