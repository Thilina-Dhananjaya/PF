import java.util.Scanner;

class Largest{
	

	public static void main(String[] args){
	
		Scanner obj = new Scanner(System.in);
		
		System.out.print("Enter the size of the number list : ");
		int size = obj.nextInt();
	
		
		int [] num = new int[size];
		
		for(int i=0;i<size;i++){
			
			System.out.print("Enter the number "+ (i+1)+ " : " );
			
			num[i]= obj.nextInt();
			
		}
		
		largest(num,size);
		
	}
	
	public static void largest(int[] num,int size){
		
		int larg=0;
		int sLarg=0;
		
		for(int i=0;i<size;i++){
			
			if(num[larg]<num[i]){
				larg = i;
			}
			
		}
		
		for(int i=0;i<size;i++){
			
			if((num[sLarg]<num[i]) && (i!=larg)){
				sLarg = i;
			}
			
		}
		
		if(num[sLarg]==num[larg]){
			
			System.out.print("Both Largest and second Largest is : "+ num[larg]);
		
			
		}
		else{
			System.out.println("Largest is : "+num[larg]);
			System.out.print("Second Largest is : "+num[sLarg]);			
		}
		
		
		
	}
	
	
}