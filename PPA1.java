import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*; 

public class PPA1 {
  public static void main(String[] args) {
	Statement stmt;
	ResultSet rs;
	Connection con;
    while (true) {
  	  try
  	  {  
		  Class.forName("com.mysql.jdbc.Driver");  
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PPA2DB","root","root");    
		  stmt = con.createStatement();  
		  rs = stmt.executeQuery("select * from BMI");
		  ResultSetMetaData metaData = rs.getMetaData();
		  System.out.println
		  (metaData.getColumnLabel(1)+" "+metaData.getColumnLabel(2)+" "
		  +metaData.getColumnLabel(3)+" "+metaData.getColumnLabel(4));
		  while(rs.next()) {  
			  System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+" "+rs.getString(4));  
		  }
		  rs = stmt.executeQuery("select * from Distance");
		  metaData = rs.getMetaData();
		  System.out.println
		  (metaData.getColumnLabel(1)+" "+metaData.getColumnLabel(2)+" "
		  +metaData.getColumnLabel(3)+" "+metaData.getColumnLabel(4)+" "+metaData.getColumnLabel(5));
		  while(rs.next()) {  
			  System.out.println(rs.getDouble(1)+"  "+rs.getDouble(2)+"  "+
		  rs.getDouble(3)+" "+rs.getDouble(4)+" "+rs.getString(5));  
		  }
		  con.close();  
	  } catch(Exception e) { System.out.println(e); }  
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
    	System.out.println("x1 coordinate: ");
	    double x1 =s.nextDouble();
	    System.out.println("y1 coordinate: ");
	    double y1 =s.nextDouble();
	    System.out.println("x2 coordinate: ");
	    double x2 =s.nextDouble();
	    System.out.println("y2 coordinate: ");
	    double y2 =s.nextDouble();
    	System.out.println(shortestDistance(x1, y1, x2, y2));
    	break;
      case 4:
    	System.out.println("Number of Guests?");
    	int guests = s.nextInt();
    	System.out.println("Total bill excluding tax comes to?");
    	double bill = s.nextDouble();
    	bill = Math.round(bill*100)/100;
    	System.out.println(splitTip(guests, bill));
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
	
	try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/PPA2DB","root","root");    
		Statement stmt = con.createStatement();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();
		String currTime = sdf.format(dt);
		String query = "insert into BMI("+feet+","+inches+","+pounds+","+currTime+")";
		ResultSet rs = stmt.executeQuery(query);  
		con.close();  
	} catch(Exception e) { System.out.println(e); }
	
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

  public static String shortestDistance(double x1, double y1, double x2, double y2) {
	double distance = distCalc(x1, y1, x2, y2);
	
	try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/PPA2DB","root","root");    
		Statement stmt = con.createStatement();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();
		String currTime = sdf.format(dt);
		String query = "insert into BMI("+x1+","+x2+","+y1+","+y2+","+currTime+")";
		ResultSet rs = stmt.executeQuery(query);  
		con.close();  
	} catch(Exception e) { System.out.println(e); }
	
	return "The distance is " + distance;
  }
  public static double distCalc(double x1, double y1, double x2, double y2) {
	  double distanceCalculated = Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
	  return distanceCalculated;
	  }

  public static String splitTip(int guests, double bill) {
	  String guestPay = "";
	  if(guests > 50) {
		  guestPay = "Number of guests exceeds 50";
		  return guestPay;
	  }
	  double [] guestdist = new double[guests];
	  double split = splitter(guests, bill);
	  bill = (Math.round(100*(bill*1.15)))/100;
	  double difference = bill - (guests*split);
	  difference = (Math.floor(100*difference))/100;
	  for(int i=0; i < guests; i++) 
	  {
		  guestdist[i] = split;
	  }
	  int j = 0;
	  while(difference > 0) {
		  guestdist[j] += .01;
		  guestdist[j] = Math.ceil(100*guestdist[j])/100;
		  if(j<guests) {
			  j++;
		  }
		  else {j=0;}
		  difference = difference - .01;
	  }
	  for(int i=0; i < guests; i++) {
		  guestPay += ("guest" + (i+1) + "-$" + guestdist[i] + "\n");
	  }
	  return guestPay;
  }
  public static double splitter(int guests, double bill) {
	  double split = Math.floor(100*((bill*1.15)/guests));
	  split = split/100;
	  return split;
  }
}
