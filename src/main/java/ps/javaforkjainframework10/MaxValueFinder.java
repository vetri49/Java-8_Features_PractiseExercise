package ps.javaforkjainframework10;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class MaxValueFinder extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 500; // Adjust the threshold as needed
    private static final int[] array = new int[10000]; // Your array here
    private int start;
    private int end;

    public MaxValueFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // If the array size is small, perform sequential search
            int max = array[start];
            for (int i = start + 1; i < end; i++) {
                max = Math.max(max, array[i]);
            }
            System.out.println("Max value found: " + max + ", range: " + start + "-" + end);
            return max;
        } else {
            // If the array size is large, split into subtasks
            int mid = (start + end) / 2;
            MaxValueFinder leftTask = new MaxValueFinder(start, mid);
            MaxValueFinder rightTask = new MaxValueFinder(mid, end);

            // Fork both tasks
            leftTask.fork();
            rightTask.fork();

            // Join results
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Combine results
            int max = Math.max(leftResult, rightResult);
            System.out.println("Subtask result: " + max + ", range: " + start + "-" + end);
            return max;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MaxValueFinder task = new MaxValueFinder(0, array.length);

        int result = forkJoinPool.invoke(task);
        System.out.println("Final result: " + result);
        System.out.println("Max value of the array: " + findMax(array));
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
