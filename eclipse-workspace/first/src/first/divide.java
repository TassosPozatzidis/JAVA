package first;
import java.util.Scanner;
import java.util.InputMismatchException;

public class divide {

	private static final Scanner input = new Scanner(System.in);
	private static int sum;
	static int[] myIntArray = new int[2];
	public static void main(String args[]){
		/*String foo;
		foo="Welcome";
		String text=foo+" To the machine ";
		System.out.println(text);
		System.out.printf("%s\n","to the machine")1;*/
		//Scanner input=new Scanner(System.in);
		int sum=0;
		String f;
		System.out.println("Enter 'exit' if you want to exit else:");
		System.out.println("Press '1' for Divide");
		System.out.println("Press '2' for Addition");
		System.out.println("Press '3' for multiplication");
		System.out.println("Press '4' for Subtract");
		System.out.println("Press '5' for Square");
		System.out.print("-->");
		f=input.next();

		do {
			switch(f) {
			case "1":
				System.out.println("You selected Divide");
				myIntArray=getNumbers();
				division(myIntArray[0],myIntArray[1]);
				break;
				
		
			case "2":
				System.out.println("You selected Addition");
				myIntArray=getNumbers();
				addition(myIntArray[0],myIntArray[1]);

									break;	
			case "5":
				System.out.println("You selected square");
				System.out.print("enter integer:");
				int num1=input.nextInt();
			
									sum=num1*num1;
									System.out.println("Sum is :"+sum); 
									break;				
			case "3":
				System.out.println("You selected Multiply");
				myIntArray=getNumbers();
				multiply(myIntArray[0],myIntArray[1]);
									break;

			case "4":
				System.out.println("You selected Subtract");
				myIntArray=getNumbers();
				subtract(myIntArray[0],myIntArray[1]);
									break;

									default:
									System.out.println("Not a valid letter please try again...");
			}
			
				
							
			System.out.println("Enter 'exit' if you want to exit else:");
			System.out.println("Press '1' for Divide");
			System.out.println("Press '2' for Addition");
			System.out.println("Press '3' for multiplication");
			System.out.println("Press '4' for Subtract");
			System.out.println("Press '5' for Square");
			System.out.print("-->");
			f=input.next();

			
		}while (!"exit".equals(f));
		input.close();
	}
	public static int[] getNumbers(){
		
		int[] numbers=new int[2];
		Scanner input=new Scanner(System.in);
		
		System.out.print("enter first integer:");
		numbers[0]=input.nextInt();
		System.out.print("enter second integer:");
		numbers[1]=input.nextInt();
		
		return numbers;
		
	}
	public static void addition(int sum1,int sum2) {	
							
							sum=sum1+sum2;
							System.out.println("Sum is :"+sum);
	}
	public static void subtract(int sum1,int sum2) {	
		
		sum=sum1-sum2;
		System.out.println("Sum is :"+sum);
	}
	public static void multiply(int sum1,int sum2) {	
		
		sum=sum1*sum2;
		System.out.println("Sum is :"+sum);
	}
	public static void division(int sum1,int sum2) {	
		
		if (sum2!=0){
			try {
				sum=sum1/sum2;
				System.out.println("Sum is "+sum); // throw Exception
				
				}
			catch (ArithmeticException e) {
// Exception handler
				System.out.println("Divided by zero operation cannot possible\n");
										}
				return;

		}else 
		{
		System.out.println("Divided by zero operation cannot possible/n");
		}
	}
	}


