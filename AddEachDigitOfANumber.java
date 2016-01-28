public class AddEachDigitOfANumber{

	private static int a = 0;

	public final static void main(String args[]){
		
		a = 0;
		int num = 12345;

		System.out.println("Add digits of " + num);

		addEachOfMe(num);

		System.out.println(" = "+a);
		
		
	}

	private static void addEachOfMe(int num){
		int digit = 0;

		if(num>0){

		digit = num % 10;
		System.out.print(digit + " + ");
		a+=digit;
		num = num/10;
		addEachOfMe(num);

		}
	

	}


}
