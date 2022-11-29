package zoo;

import food.*;
import mobility.*;
import animals.*;
import privateutil.*;
import java.util.*;
import java.math.*;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 */

public class ZooActions {

	/**
	 * This function receives predator and prey and if there is a match is done eating 
	 * @param animal-Kind of an animal
	 * @param food-type of food (MEAT\ NOTFOOD\ VEGETABLE)
	 * @return true if it is done, and false if not
	 */
	public static boolean eat(Object animal, IEdible food) {
		if(animal instanceof Lion)
			return (((Lion) animal).eat(food));
		if(animal instanceof Bear)
			return (((Bear) animal).eat(food));
		if(animal instanceof Elephant)
			return (((Elephant) animal).eat(food));
		if(animal instanceof Giraffe)
			return (((Giraffe) animal).eat(food));
		if(animal instanceof Turtle)
			return (((Turtle) animal).eat(food));
		return false;
	}
	
	/**
	 * This function receives an animal and a point of position 
	 * and moves the animal to the requested location 
	 * @param animal-Kind of an animal
	 * @param point-location 
	 * @return true if it is done, and false if not
	 */
	public static boolean move(Object animal, Point point) {
		if(animal instanceof Lion){
			if(Point.cheackBounderies(point)) {
				((Lion) animal).move(point); 
				return true;
			}
		}
		if(animal instanceof Bear){
			if(Point.cheackBounderies(point)) {
				((Bear) animal).move(point);
				return true;
			}
		}
		if(animal instanceof Elephant){
			if(Point.cheackBounderies(point)) {
				((Elephant) animal).move(point);
				return true;
			}
		}
		if(animal instanceof Giraffe){
			if(Point.cheackBounderies(point)) {
				((Giraffe) animal).move(point);
				return true;
			}
		}
		if(animal instanceof Turtle){
			if(Point.cheackBounderies(point)) {
				((Turtle) animal).move(point);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return an integer number \Exception
	 */
	public static int GetInt()
	 {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			try
			{
				return sc.nextInt();
				}
			catch (InputMismatchException e)
			{
				sc.next();
				System.out.println("Invalid input Please insert an integer");
			}
		}
	}
	
	
	/**
	 * @return double number \Exception
	 */
	public static double GetDouble()
	 {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			try
			{
				return sc.nextDouble();
				}
			catch (InputMismatchException e)
			{
				sc.next();
				System.out.println("Invalid input Please insert a double number");
			}
		}
	}
	
	
	/**
	 * This is the main function and it starts the program 
	 * (Builds an array of animals and realizes the functions of eating and moving )
	 * @param args
	 */
	/*public static void main(String[] args) {
		System.out.println("********************************************");
		System.out.println("\t\tInitilize");
		System.out.println("********************************************");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		
		int size=GetInt();
		
		if (size<3)
			size=3;
		Animal arrAnimal[]=new Animal[size];
		int chois;
		double weight;
		String name;
		Point location;
		
		for(int i=0; i<size; ++i) {
			do {
				
				System.out.println("\nEnter your chois:\n1.Lion\n2.Bear\n3.Elephant\n4.Giraffe\n5.Turtle");
				chois=GetInt();

				switch(chois) {
				case 1:
					System.out.println("Enter please name of animal");
					name=sc.next();
					System.out.println("Enter please weight of animal");
					weight=GetDouble();
					System.out.println("\nPress the X value and the Y value of the new location");
					location =new Point(GetInt(),GetInt());
					if(Point.cheackBounderies(location))
						arrAnimal[i]=new Lion(name,weight,location);
					else
						arrAnimal[i]=new Lion(name,weight);
					break;
				case 2:
					System.out.println("Enter please name of animal");
					name=sc.next();
					System.out.println("Enter please weight of animal");
					weight=GetDouble();
					System.out.println("\nPress the X value and the Y value of the new location");
					location =new Point(GetInt(),GetInt());
					System.out.println("Enter please fur color");
					String furColor=sc.next();
					if(Point.cheackBounderies(location))
						arrAnimal[i]=new Bear(name,location,furColor);
					else
						arrAnimal[i]=new Bear(name,furColor);
					break;
				case 3:
					System.out.println("Enter please name of animal");
					name=sc.next();
					System.out.println("Enter please weight of animal");
					weight=GetDouble();
					System.out.println("\nPress the X value and the Y value of the new location");
					location =new Point(GetInt(),GetInt());
					System.out.println("Enter please Length of trunk");
					double trunk=GetDouble();
					if(Point.cheackBounderies(location))
						arrAnimal[i]=new Elephant(name,location,trunk);
					else
						arrAnimal[i]=new Elephant(name,trunk);
					break;
				case 4:
					System.out.println("Enter please name of animal");
					name=sc.next();
					System.out.println("Enter please weight of animal");
					weight=GetDouble();
					System.out.println("\nPress the X value and the Y value of the new location");
					location =new Point(GetInt(),GetInt());
					double neckLenght;
					System.out.println("Enter please neck Length");
					neckLenght=GetDouble();

					if(Point.cheackBounderies(location))
						arrAnimal[i]=new Giraffe(name,location,neckLenght,size,col);
					else
						arrAnimal[i]=new Giraffe(name,neckLenght,size,col);
					break;
				case 5:
					System.out.println("Enter please name of animal");
					name=sc.next();
					System.out.println("Enter please weight of animal");
					weight=GetDouble();
					System.out.println("\nPress the X value and the Y value of the new location");
					location =new Point(GetInt(),GetInt());
					int age;
					System.out.println("Enter please Age of turtle");
					age = sc.nextInt();
					if(Point.cheackBounderies(location))
						arrAnimal[i]=new Turtle(name,location,age);
					else
						arrAnimal[i]=new Turtle(name,age);
					break;
				default:
					System.out.println("Error enter another number");
					break;
				}
			}while(chois<1||chois>5);

		}
		System.out.println();
		System.out.println("********************************************");
		System.out.println("\t\tMove");
		System.out.println("********************************************");
		for(int i=0;i<size;++i) {
			int x,y;
			System.out.println("\nPress the X value and the Y value of the new location");
			x= GetInt();
			y=GetInt();
			move(arrAnimal[i], new Point (x,y));
		}
		System.out.println("********************************************");
		System.out.println("\t\tFeed");
		System.out.println("********************************************");
		for(int i=0;i<=size/2;++i) {
			sc.nextInt();
			System.out.println("********************************************");
			Random rand = new Random();
			int rand1= rand.nextInt(size);
			int rand2= rand.nextInt(size);
			if(eat(arrAnimal[rand1], arrAnimal[rand2])){
				arrAnimal[rand2]=null;
			}	
		}
	}*/
}
