package one;

public class Application {

	public static void main(String[] args) 
	{
		Person someone = new Person("Michael", 22);
		print(someone.getName());
		print(someone.getAge());
	}
	
	public static void print(Object o)
	{
		System.out.println(o);
	}
}
