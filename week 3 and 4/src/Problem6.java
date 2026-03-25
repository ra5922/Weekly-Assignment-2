public class Problem6 {

    static int floor(int[] arr, int target) {
        int res = -1;
        for (int x : arr) {
            if (x <= target) res = x;
        }
        return res;
    }

    static int ceiling(int[] arr, int target) {
        int res = -1;
        for (int x : arr) {
            if (x >= target) {
                res = x;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println("Floor: " + floor(arr, 30));
        System.out.println("Ceiling: " + ceiling(arr, 30));
    }
}