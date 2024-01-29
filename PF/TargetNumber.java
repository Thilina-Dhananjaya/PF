public class TargetNumber {
	
    public static int[] findSum(int[] nums, int targetnum) {
		
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (nums[i] + nums[j] == targetnum) {
                    return new int[] { i, j };
                }
            }
        }
		// If no result is found
        return new int[] { -1, -1 }; 
    }

    public static void main(String[] args) {
		
        int[] nums = { 4, 2, 1, 5};
        int targetnum = 7;
		
	System.out.print("Original array :");
		for(int i=0; i<4; i++){
		System.out.print( nums[i]+ " " );
		}
		System.out.println();
		
		System.out.println("Target value :"+ targetnum);
			

        int[] Result = findSum(nums, targetnum);

        if (Result[0] != -1 && Result[1] != -1) {
			
            System.out.println("Indices Value: " + Result[0] + ", " + Result[1]);
            System.out.println("Numbers: " + nums[Result[0]] + ", " + nums[Result[1]]);
			
        } else {
            System.out.println("No solution found.");
        }
    }
}