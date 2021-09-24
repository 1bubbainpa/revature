package two;

public class PrivateMain {

	public static void main(String[] args) 
	{
		PrivatePerson me = new PrivatePerson();
		me.setAge(22);
		me.setName("Michael");
		System.out.println(me.getAge());
		System.out.println(me.getName());
	}

}
