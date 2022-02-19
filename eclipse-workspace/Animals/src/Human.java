
public class Human extends Mammal{
	private String LastName;
	private String Nationality;
	



	public Human(String name,String LastName, int age, char gender,String Nationality)  {
		super(name,age,gender);
		this.LastName = LastName;
		this.Nationality=Nationality;
	}






	public String getLastName() {
		return LastName;
	}




	public void setLastName(String lastName) {
		LastName = lastName;
	}




	public String getNationality() {
		return Nationality;
	}




	public void setNationality(String nationality) {
		Nationality = nationality;
	}


}
