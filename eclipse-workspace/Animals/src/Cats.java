
public class Cats extends Mammal{
	private String breed;



	public Cats(String name, int age, String breed, char gender)  {
		super(name,age,gender);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
}
