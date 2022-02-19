
public class ConstructorTest {
		
	public static void main (String args[])
	{
		CommissionEmployee employee=new CommissionEmployee("Bob","Lewis","90993212",5000,0.4);
		System.out.println(employee.getLastName());
		CommissionEmployee employee2=new BasePlusCommissionEmployee("Boba","Lew","90993212",5000,0.4,800);
		System.out.println(employee2.getLastName());
	}
}
