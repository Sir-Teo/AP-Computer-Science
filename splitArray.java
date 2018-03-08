
//this file is used for testing 
import java.util.*;
class splitArray{

    public boolean splitarray(int[] nums) {
        Arrays.sort(nums);
        int sum = getSum(0,nums,0);
        int halfSum = sum/2;
        nums = cleanNumbers(nums,0,halfSum);
        Arrays.sort(nums);
        sum = getSum(0,nums,0);
        if(nums.length==0)
        return true;
        if(sum%2!=0)
        return false;
        return checker(sum/2,0,nums,0);
    }   
    
    public int getSum(int sum, int[]nums, int index){
        if(index==nums.length)
        return sum;
        sum = sum + nums[index];
        return getSum(sum, nums, index+1);
    }
    
    public boolean checker(int halfsum, int group1, int[] numbers,int index){
        if(index<numbers.length-1){
        if((group1+numbers[index])==halfsum)
            return true; 
        if((group1+numbers[index])<halfsum)
            return checker(halfsum, group1+numbers[index], numbers, index+1);
        }
            return false;
    }
public int[] cleanNumbers(int[] numbers, int index, int halfsum){
    if(index<numbers.length-1){
    if(numbers[index]==numbers[index+1]){
        halfsum=halfsum-numbers[index];
        numbers[index]=0;
        numbers[index+1]=0;
    }
    return cleanNumbers(numbers, index+1,halfsum);
}
return numbers;
}

//testing 
public static void main(String[] args){
    int[] numbers1 = {1,2,3,10,10,1,1};
    int[] numbers2 = {1,2,3};
    Arrays.sort(numbers2);
    splitArray test = new splitArray();
    System.out.println(test.splitarray(numbers1));
    System.out.println(test.splitarray(numbers2));
    for(int i=0;i<numbers1.length;i++)
    System.out.print(numbers1[i]);
}
}