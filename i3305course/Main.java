package i3305course;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import i3305course.WebpageList.*;
public class Main {

	public static void main(String[] args)
	{
		MyFrame frame = new MyFrame("Test");
		BMI bmiApp = new BMI("BMI");
		MyColor myColor = new MyColor("Color Test");
		Pizza pizzaApp = new Pizza("Pizza Topping Test");
		Calculator calculator = new Calculator("Simple Calculator");
		paintDraw oval = new paintDraw("Graphics");
		WebpageList webPage = new WebpageList();
		webPage.createPage(frame);webPage.createPage(bmiApp);webPage.createPage(myColor);webPage.createPage(pizzaApp);webPage.createPage(calculator);
		webPage.createPage(oval);
		webPage.initiateWeb();
		//<key=username, value=pin>
		/*HashMap<String,ArrayList<Integer>> map1 = new HashMap<String, ArrayList<Integer>>();
		map1.put("rana", new ArrayList<Integer>());
		map1.put("fadi", new ArrayList<Integer>());
		map1.put("sarah", new ArrayList<Integer>());
		map1.put("fadi", new ArrayList<Integer>());
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Username");
			String username = scan.next();
			System.out.println("Enter Password");
			int pin = scan.nextInt();
		}*/
		
		/*HashSet<Person> set1 = new HashSet<Person>();
		set1.add(new Person("rana","dagher", 18));
		set1.add(new Person("joe","dagher", 19));
		set1.add(new Person("aline","sfeir", 18));
		set1.add(new Person("joe","dagher", 19));
		System.out.print(set1);
		
		LinkedList<Person> list1 = new LinkedList<Person>(set1);
		list1.add(new Person("joe","dagher",19));
		System.out.println(list1);
		
		Collections.sort(list1);
		System.out.println(list1);
		

		Student s1 = new Student("Jess","Lahoud", 20);
		Student s2 = new Student("Georgio","Wakim", 21);
		System.out.println(s1.compareTo(s2));
		AgeComparator compare = new AgeComparator();
		System.out.println(compare.compare(s1, s2));
		Rectangle rectangle = new Rectangle(3,2);
		Circle circle = new Circle(2); 
		 System.out.println("Same area? "
		+Main.<GeometricObject>equalArea(rectangle, circle));
		*/
		
	}
	/*public static <T extends Comparable<T>> T getMaximum(T[] array)
	{
		T max = array[0];
		for (int i=0; i< array.length; i++)
		{
			if (array[i].compareTo(max) > 0)
				max = array[i];
		}
		return max;
	}
	public static <E extends GeometricObject> 
	boolean equalArea(E object1, E object2)
	{
		return object1.getArea() == object2.getArea();
	}*/
}
