// You are using Java
import java.util.*;

class MaxOfMins {
    
    // Function to find the maximum of minimums of all contiguous subarrays of size k
    public static int maxOfMins(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; // Invalid case

        Deque<Integer> dq = new LinkedList<>();
        List<Integer> minInWindows = new ArrayList<>();

        // Process the first k elements
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        // Process the rest of the elements
        for (int i = k; i < n; i++) {
            // The front of the deque contains the index of the minimum for the last window
            minInWindows.add(arr[dq.peekFirst()]);

            // Remove elements that are out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Add the current element and maintain the deque properties
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        // Add the minimum for the last window
        minInWindows.add(arr[dq.peekFirst()]);

        // Find the maximum of minimums
        int maxMin = Collections.max(minInWindows);

        return maxMin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt(); // Length of segment
        int n = scanner.nextInt(); // Size of the array

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // Input array elements
        }

        // Get the result and print it
        System.out.println(maxOfMins(arr, k));
    }
}
