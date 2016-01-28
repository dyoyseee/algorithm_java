public class Fibonacci{

	public static final void main(String args[]){
	
		addMe(0,1,100);
	
	}
	
	private static void addMe(int a, int b, int lim){
		
		int c = a + b;
		
		if( c < lim ){
			System.out.println(a + " + " + b + " = " + c);
			addMe(b,c,lim);
		}
	
	}
	

}