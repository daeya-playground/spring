public class Problem10Grade {
    public static void main(String[] args) {
        int score = 85;
        System.out.println(getGrade(score));
    }

    static String getGrade(int score) {
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 60) {
            return "D";
        }
        return "F";
    }
}
