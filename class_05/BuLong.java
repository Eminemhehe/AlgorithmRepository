package class_05;

/**
 * Created by wz on 2019/5/7.
 */
public class BuLong {
    public static void main(String[] args) {
        int[] arr = new int[1000];//32000bit
        int index = 30000;
        int intIndex = index / 32;
        int bitIndex = index % 32;
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }
}
