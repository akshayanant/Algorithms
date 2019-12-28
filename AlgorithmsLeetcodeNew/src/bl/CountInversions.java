package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/26/2019.
 */
public class CountInversions {

    private int count = 0;
    public int inversions(List<Integer> nums){
        devide(nums,0,nums.size()-1);
        return count;
    }

    private List<Integer> devide(List<Integer> nums,int l, int r){
        if(l==r){
            List<Integer> res = new ArrayList<>();
            res.add(nums.get(l));
            return res;
        }
        List<Integer> left = devide(nums,l,(l+r)/2);
        List<Integer> right = devide(nums,(l+r)/2+1,r);
        return mergeAndCount(left,right);
    }

    private List<Integer> mergeAndCount(List<Integer> left, List<Integer> right){
        List<Integer> res = new ArrayList<>();
        while (!left.isEmpty()&&!right.isEmpty()){
            if(left.get(0)>right.get(0)){
                res.add(right.get(0));
                right.remove(0);
                count+=left.size();
            }
            else{
                res.add(left.get(0));
                left.remove(0);
            }
        }
        if(!left.isEmpty()){
            res.addAll(left);
        }
        else {
            res.addAll(right);
        }
        return res;
    }

    private int usingSearch(List<Integer> nums){
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = nums.size()-1; i >-1; i--) {
            count+=insertIndex(list,nums.get(i));
        }
        return count;
    }

    private int insertIndex(List<Integer> list,int num){
        int index = 0;
        if(list.size()>0){
            int l = 0;
            int r = list.size()-1;
            while (l<=r){
                int mid = (l+r)/2;
                if(list.get(mid)==num){
                    break;
                }
                if(list.get(mid)>num){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            index = l;
        }
        list.add(index,num);
        return index;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(0);
        input.add(0);
        System.out.println(new CountInversions().inversions(input));
    }
}
