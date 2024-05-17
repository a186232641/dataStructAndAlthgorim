package Althgorim.First.ArrayAlthgorim;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class twoSum {

    public int[] twoSum(int[] numbers, int target) {
       int i =0,j=numbers.length-1;
       while(i<j){
           if(numbers[i]+numbers[j]>target){
               j--;
           }else if(numbers[i]+numbers[j]<target){
               i++;
           }else{
            return    new int[]{i+1,j+1};
           }
       }
       return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        twoSum twoSum = new twoSum();
        int numbers[] = new int[]{2,7,11,15};
        int target = 9;
        twoSum.twoSum(numbers,target);
    }

}

