import java.util.Scanner;
class PrimeorNot{
	static boolean isPrime(int n){
		if(n<=1){
			return false;
			}
		
			for(int i=2; i<n; i++){
				if(n%i == 0){
				return false;
				}
			}
			return true;
			
		}
		
		
		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter a Number : ");
			int num = sc.nextInt();
			
			
			if (isPrime(num))
            System.out.println(" prime number");
			else
            System.out.println(" not a prime number");
		}
	}