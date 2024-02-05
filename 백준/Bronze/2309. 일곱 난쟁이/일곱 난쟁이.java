import java.util.*;

public class Main {
    static int[] arr = new int[9];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int tall = scanner.nextInt();
            arr[i] = tall;
        }
        for (int z = 0; z < arr.length; z++) {
            sum += arr[z];
        }
        Arrays.sort(arr);
        erase(sum - 100);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (arr[i] != 0) {
                str.append(arr[i]).append("\n") ;
            }
        }
        System.out.println(str);
    }

    private static void erase(int target) {
        int left = 0;
        int right = arr.length -1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                arr[left] = 0;
                arr[right] = 0;
                return;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}