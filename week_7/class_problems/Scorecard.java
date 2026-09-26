package week_7.class_problems;

class Quiz {
    private boolean[] answers;
    private int count;

    Quiz(int totalQuestions) {
        answers = new boolean[totalQuestions];
        count = 0;
    }

    void recordAnswer(boolean correct) {
        if (count < answers.length) {
            answers[count] = correct;
            count++;
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (answers[i] == true) {
                score++;
            }
        }

        return score;
    }
}

public class Scorecard {
    public static void main(String[] args) {

        Quiz sc = new Quiz(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}