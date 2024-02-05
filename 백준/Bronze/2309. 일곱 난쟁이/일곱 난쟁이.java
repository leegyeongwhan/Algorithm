
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int tall = scanner.nextInt();
            arr[i] = tall;
        }
        for (int z = 0; z < arr.length; z++) {
            sum += arr[z];
        }
        Arrays.sort(arr);
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (100 == sum - (arr[i] + arr[j])) {
                    for (int z = 0; z < 9; z++) {
                        if (z == i || z == j) {
                            continue;
                        }
                        System.out.println(arr[z]);
                    }
                    return;
                }
            }
        }
    }

}
