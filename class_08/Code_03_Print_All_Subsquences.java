package class_08;

import java.util.ArrayList;
import java.util.List;

public class Code_03_Print_All_Subsquences {

    /*public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }
        //i是到达第几步，res是上次决策决定的res
    public static void process(char[] chs, int i, List<Character> res) {
        //i已经到最后了，直接打印
        if (i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        //下一步，以可进行2中决策，要不要当前i所指的char；
        process(chs, i + 1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(chs, i + 1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list) {
        return null;
    }


    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);
        printAllSub(str, i + 1,res + String.valueOf(str[i]));
    }*/

    public static void main(String[] args) {
        String test = "abc";
        //printAllSubsquence(test);
        System.out.println("=================================");
        printAllSub(test.toCharArray(), 0, "");
    }

    private static void printAllSub(char[] toCharArray, int i, String s) {
        if(i==toCharArray.length){
            System.out.println(s);
        }else {
            printAllSub(toCharArray,i+1,s);
            printAllSub(toCharArray,i+1,s+toCharArray[i]);
        }
    }

}
