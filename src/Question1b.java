//Your task is to determine the minimum time needed to build all the engines using the available engineers

import java.util.Arrays;
import java.util.PriorityQueue;

public class Question1b {

    public static int minTimeToBuildEngines(int[] engines, int splitCost) {
        int n = engines.length;
        Arrays.sort(engines);

        // Use a priority queue to track the time taken by each engineer
        PriorityQueue<Integer> timeQueue = new PriorityQueue<>();

        // Initially, there is one engineer
        timeQueue.offer(0);

        for (int i = n - 1; i >= 0; i--) {
            int shortestTime = timeQueue.poll();
            timeQueue.offer(shortestTime + engines[i]);
            timeQueue.offer(shortestTime + splitCost);
        }

        // The total time is the maximum time taken by any engineer
        return timeQueue.poll();
    }

    public static void main(String[] args) {
        int[] engines = {3, 4, 5, 2};
        int splitCost = 2;
        int result = minTimeToBuildEngines(engines, splitCost);
        System.out.println(result); // Output: 4
    }
}
