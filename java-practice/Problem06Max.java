public class Problem06Max {
    public static void main(String[] args) {
        int[] nums = {3, 7, 2, 9, 1};
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println(max);
    }
}
