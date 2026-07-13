public class Problem09Palindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("level"));
        System.out.println(checkPalindrome("java"));
    }

    static String checkPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return "아님";
            }
            left++;
            right--;
        }

        return "팰린드롬";
    }
}
