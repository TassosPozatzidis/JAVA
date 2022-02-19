package first;
import java.util.Scanner;

public class FirstProgram {
	public static void main(String args[]){
		/*String foo;
		foo="Welcome";
		String text=foo+" To the machine ";
		System.out.println(text);
		System.out.printf("%s\n","to the machine")1;*/
		Scanner input=new Scanner(System.in);
		int num1;
		int num2;
		int sum;
		
		System.out.print("enter fisrt integer:");
		
		num1=input.nextInt();
		System.out.print("enter second integer:");
		num2=input.nextInt();
		sum=num1+num2;
		System.out.println(sum++);
		System.out.printf("Sum is :%d",sum);
		
		
		}
}
