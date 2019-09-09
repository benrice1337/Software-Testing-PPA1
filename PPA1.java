import java.util.Scanner;

public class PPA1 {
  public static void main(String[] args) {
    while(true) {
      System.out.println("Pick a function:");
      System.out.println("1. Body Mass Index");
      System.out.println("2. Retirement");
      System.out.println("3. Shortest Distance");
      System.out.println("4. Split the Tip");
      System.out.println("5. Exit");

      Scanner s = new Scanner(System.in);
      int choice = s.nextInt();

      if(choice == 1) System.out.println(bodyMassIndex());
      else if(choice == 2) System.out.println(retirement());
      else if(choice == 3) System.out.println(shortestDistance());
      else if(choice == 4) System.out.println(splitTip());
      else if(choice == 5) break;
      else System.out.println("Not a valid choice. Try again.");
    }
  }

  public static String bodyMassIndex() {
    //TODO: Function body here
	return "";
  }

  public static String retirement() {
    //TODO: Function body here
	return "";
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
