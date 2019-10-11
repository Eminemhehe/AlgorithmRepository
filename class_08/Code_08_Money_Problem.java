package class_08;

public class Code_08_Money_Problem {

    public static boolean money1(int[] arr, int aim) {
        return process1(arr, 0, 0, aim);
    }

    public static boolean process1(int[] arr, int i, int sum, int aim) {
        if (sum == aim) {
            return true;
        }
        // sum != aim
        if (i == arr.length) {
            return false;
        }
        return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
    }

    public static boolean money2(int[] arr, int aim) {

        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        //在i=0，处于最后一行的时候，除了sum==aim（turn），其他位置都是flase
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }
    //来到的位置是i，之前形成的和是sum，目标是aim（arr和aim固定，i和sum形成2维表）
    public static boolean isSum(int[] arr, int i, int sum, int aim) {
        //base 来到最后的位置==aim
        if (i == arr.length) {
            return sum == aim;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));


        isSum(arr, 0, 0, aim);
    }

}
