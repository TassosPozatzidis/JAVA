
public class CommissionEmployee {
		private String firstName;
		private String lastName;
		private String socialSecurityNumber;
		private double grossSales;
		private double commissionRate;
		public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
				double commissionRate) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.socialSecurityNumber = socialSecurityNumber;
			this.grossSales = grossSales;
			this.commissionRate = commissionRate;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getSocialSecurityNumber() {
			return socialSecurityNumber;
		}
		public void setSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
		}
		public double getGrossSales() {
			return grossSales;
		}
		public void setGrossSales(double grossSales) {
			this.grossSales = grossSales;
		}
		public double getCommissionRate() {
			return commissionRate;
		}
		public void setCommissionRate(double commissionRate) {
			this.commissionRate = commissionRate;
		}
		
		
}
