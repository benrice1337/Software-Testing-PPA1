import java.util.Scanner;

public class PPA1 {
  public static void main(String[] args) {
    while (true) {
      System.out.println("Pick a function:");
      System.out.println("1. Body Mass Index");
      System.out.println("2. Retirement");
      System.out.println("3. Shortest Distance");
      System.out.println("4. Split the Tip");
      System.out.println("5. Exit");

      Scanner s = new Scanner(System.in);
      int choice = s.nextInt();

      switch (choice) {
      case 1:
    	System.out.print("How many feet tall are you (integer only)? ");
    	int f = s.nextInt();
    	System.out.print("And how many inches (integer only)? ");
    	int i = s.nextInt();
    	System.out.print("How many pounds do you weigh (integer only)? ");
    	int p = s.nextInt();
    	System.out.println("Your BMI is " + bmiCalculator(f, i, p) + ", making you" + bodyMassIndex(f, i, p));
    	break;
      case 2:
    	System.out.println("How old are you (integer only)? ");
    	int a = s.nextInt();
    	System.out.println("What is your salary? ");
    	int sal = s.nextInt();
    	System.out.println("What percentage of that do you save (integer only)? ");
    	int sav = s.nextInt();
    	System.out.println("What is your goal? ");
    	int g = s.nextInt();
    	System.out.println(retirement(a, sal, sav, g));
    	break;
      case 3:
    	System.out.println(shortestDistance());
    	break;
      case 4:
    	System.out.println(splitTip());
    	break;
      case 5:
    	System.out.println("Bye!");
    	return;
      default:
    	System.out.println("Not a valid choice. Try again.");
    	break;
      }
    }
  }

  public static String bodyMassIndex(int feet, int inches, int pounds) {
    if (feet < 0 || inches < 0 || pounds < 0) return "Invalid input";
    if (feet == 0 && inches == 0) return "Invalid input";
    if (pounds == 0) return "Invalid input";
    
	double bmi = bmiCalculator(feet, inches, pounds);
    if (bmi < 18.5) return "Underweight";
    else if (bmi < 25) return "Normal";
    else if (bmi < 30) return "Overweight";
    else return "Obese";
  }
  
  public static double bmiCalculator(int feet, int inches, int pounds) {
	double kilos = pounds * 0.45;
	double meters = ((feet * 12) + inches) * 0.025;
	meters *= meters;
	double bmi = kilos / meters;
	return bmi;
  }

  public static String retirement(int age, int salary, int saved, int goal) {
    if (age >= 100) return "Invalid input";
    if (age <= 0 || salary <= 0 || saved <= 0 || goal <= 0) return "Invalid input";
    
    int goalAge = retCalculator(age, salary, saved, goal);
    if (goalAge >= 100) return "You'll be dead before you reach your goal!";
	return "You'll reach your goal at age " + goalAge;
  }
  
  public static int retCalculator(int age, int salary, int saved, int goal) {
	//Employer matches 35% of what you save
	double percent = saved * 1.35/ 100.0;
	double savings = 0;
	int goalAge = age;
	
	while (savings < goal) {
		savings += salary * percent;
		++goalAge;
	}
	return goalAge;
  }

  public static String shortestDistance() {
    //TODO: Function body here
	return "";
  }

  public static String splitTip() {
    //TODO: Function body here
	return "";
  }
}
