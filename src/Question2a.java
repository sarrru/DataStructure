//
//        To solve this problem, we can use the following approach:
//
//        Calculate the sum of dresses across all sewing machines.
//        If the total sum is not divisible by the number of sewing machines, return -1 because it's not possible to equalize the dresses.
//        Calculate the target number of dresses each sewing machine should have (the average).
//        Iterate through the sewing machines and calculate the moves required to equalize the dresses.
//Input: [2, 1, 3, 0, 2]
//
//        The sum of dresses = 2 + 1 + 3 + 0 + 2 = 8.
//
//        Since there are 5 sewing machines, the target number of dresses for each machine is 8 / 5 = 1.6. However, since the dresses must be integers, equalizing is not possible, and the correct output should be -1.
public class Question2a {

    public static int minMovesToEqualize(int[] dresses) {
        int n = dresses.length;

        // Calculate the sum of dresses
        int sum = 0;
        for (int dress : dresses) {
            sum += dress;
        }

        // Calculate the target number of dresses each sewing machine should have
        int targetDresses = sum / n;

        // Check if equalization is possible
        if (sum % n != 0) {
            return -1; // Equalization is not possible if the sum is not divisible by the number of machines
        }

        int moves = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the difference between the current dresses and the target
            int diff = dresses[i] - targetDresses;
            // Update the current sum
            currentSum += diff;
            // Accumulate the absolute difference to calculate total moves
            moves += Math.abs(currentSum);
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] dresses = {2, 1, 3, 0, 2};
        int result = minMovesToEqualize(dresses);
        System.out.println(result); // Output: 5
    }
}
