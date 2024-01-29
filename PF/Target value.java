import java.util.Scanner;

public class assessment_03{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the array size : ");
        int size = sc.nextInt();

        int [] arr = new int[size];

        System.out.print("Enter the array Elements : ");
        for(int i=0; i<size ;i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the target value : ");
        int targetValue = sc.nextInt();

        sc.close();

        calculation(targetValue, size, arr);
    }

    private static void calculation(int targetValue, int size, int [] arr){

        int sum = 0;
        boolean say = false;

        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                sum = arr[i] + arr[j];
                if(sum == targetValue){
                    System.out.println("Index of numbers : " + i + " , " + j);
                    say = true;
                    break;
                }
            }
        }

        if(say == false){
            System.out.println("None of value not generate target value");
        }
    }

}