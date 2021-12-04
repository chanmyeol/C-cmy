import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args){
//        java练习题第一题
        System.out.println(reverse(123));

//        java练习题第二题
        System.out.println(Upstairs(3));

//        java练习题第三题

        int[] nums = new int[]{1,2,3};
        System.out.println(SubSet(nums));

    }
    public static int reverse(int a){
        if(a == 0) return 0;
        long res = 0;
        while (a != 0 ){
            res = res * 10 + a % 10;
            a = a / 10;
        }
        if(res > Math.pow(2,31)||res < Math.pow(-2,31) ){
            return 0;
        }
        return (int) res;


    }
    public static int Upstairs(int x){
        int ways[] = new int[x+1];
        for(int i = 0;i < x+1;i++){
            if(i < 3){
                ways[i] = i;
            }else {
                ways[i] = ways[i-1] + ways[i-2];
            }
        }
        return ways[x];
    }
    public static List<List<Integer>> SubSet(int[] nums){
        int len = nums.length;
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i = 0; i < (1 << len);++i){
            t.clear();
            for(int j = 0;j < len;++j){
                if((i &(1 << j)) != 0){
                    t.add(nums[j]);
                }
            }
            ans.add(new ArrayList<Integer>(t));

        }
        return ans;
    }
}
