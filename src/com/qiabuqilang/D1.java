package com.qiabuqilang;

//1. Two Sum
public class D1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        get_res:
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]= i;
                    res[1]= j;
                    break get_res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        D1 solution = new D1();
        int[] res = solution.twoSum(nums,target);

        for (int r:res){
            System.out.printf("%d\t",r);
        }

    }

}


