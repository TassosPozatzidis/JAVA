import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Dogs mydog=new Dogs("Azor",3,"french bulldog",'M');
		Cats mycat=new Cats("Meowth",7,"Persian",'F');
		Human me=new Human("Brick","Tamland",38,'F',"Greek");
		ArrayList<Mammal> list=new ArrayList<Mammal>();
		list.add(me);
		list.add(mycat);
		list.add(mydog);
		for(int i=0;i<list.size();i++) {
			if (list.get(i) instanceof Human) {
				System.out.println(((Human)(list.get(i))).getLastName());
			}
		}
		
		
		
		
//		System.out.println("My dogs age is : "+mydog.getAge()+"--My dogs name is : "+mydog.getName());
//		System.out.println("My cats age is : "+mycat.getAge()+"--My cats name is : "+mycat.getName());
//		System.out.println("My age is : "+me.getAge()+"--My name is : "+me.getName());
	}

}
