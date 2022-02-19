package first;
import java.util.Scanner;

public class GradeBook {
	private String courseName;
	
	public GradeBook(String name)
	{
		courseName=name;
	}
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		
		GradeBook myGradeBook=new GradeBook("CS01");
		
		System.out.println("Please enter Course Name:");
		String Name =input.nextLine();
		myGradeBook.setCourseName(Name);
		
		System.out.println();
		myGradeBook.displayMessage();
		System.out.println("Determine Average Grades:");
		myGradeBook.determineClassAverage();
		
	}
	
	
	public void determineClassAverage() {
		Scanner input =new Scanner(System.in);
		int total;
		int gradeCounter;
		int grade;
		int average;
		
		total=0;
		gradeCounter=1;
		while (gradeCounter<=10)
		{
			System.out.print("Enter grade:");
			grade=input.nextInt();
			total=total+grade;
			gradeCounter=gradeCounter+1;
			
		}
		average=total/10;
		
		System.out.printf("\nTotal of All Grades is:%d", total);
		System.out.printf("\nAverage is:%s", average);
		
	}
	public void setCourseName(String  name)
	{
		courseName=name;
		
	}
	public String getCourseName() {
		return courseName;
	}
	public void displayMessage() {
		System.out.printf("My Course Name is:\n%s", getCourseName());
	}
	
	
}
