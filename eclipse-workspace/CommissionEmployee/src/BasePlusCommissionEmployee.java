
public class BasePlusCommissionEmployee extends CommissionEmployee{

	private double baseSalary;
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate,double Salary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		setBaseSalary(Salary);
		// TODO Auto-generated constructor stub
	}
	
	public void setBaseSalary(double salary) {
		baseSalary=(salary<0.0)?0.0:salary;
	}

}
