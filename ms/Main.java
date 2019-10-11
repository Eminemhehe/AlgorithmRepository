package ms;

/**
 * Created by wz on 2019/9/17.
 */
public class Main {
   public static int reve(int n){
       int res = 0;
       int max= Integer.MAX_VALUE;
       int min = Integer.MIN_VALUE;
       while(n != 0) {
           int temp = n % 10;
           n =n/10;
           //判断是否正溢出
           if(res > max/ 10 || (res ==max / 10 && temp > 7)) {
               return 0;
           }
           //判断是否负溢出
           if(res < min/ 10 || (res == min / 10 && temp < -8)) {
               return 0;
           }
           res = res * 10 + temp;    //求出反转整数
       }

       return res;

   }
}
