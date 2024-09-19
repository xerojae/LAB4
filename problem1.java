import java.util.Arrays;

public class problem1{

    public int[] searchRange(int[] nums, int target){
        int[] result = {-1, 1};

        //Find the leftmost index
        int leftIndex = findLeftMostIndex(nums, target);
        if(leftIndex == -1){
            return result;
        }

        //Find the rightmost index
        int rightIndex = findRightMostIndex(nums, target);

        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }

    private int findLeftMostIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                index = mid;        //Found target, continue searching left
                right = mid - 1;
            }
        }

        return index;

    }

    private int findRightMostIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left) /2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                index = mid;        //found target, continue searching right
                left = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args){
        problem1 p1 = new problem1();

        //Example input 
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        //Calling the searchRange method
        int[] result = p1.searchRange(nums, target);

        //Output the result
        System.out.println("The starting and ending postions of " + target + " are: " + Arrays.toString(result));

        //Another example input
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;

        //Calling the searchRange method
        int[] result2 = p1.searchRange(nums2, target2);

        //Output the result
        System.out.println("The starting and ending postions of " + target2 + " are: " + Arrays.toString(result2));

        //Another example input
        int[] nums3 = {};
        int target3 = 0;

        //Calling the searchRange method
        int[] result3 = p1.searchRange(nums3, target3);

        //Output the result
        System.out.println("The starting and ending postions of " + target3 + " are: " + Arrays.toString(result3));

    }

}