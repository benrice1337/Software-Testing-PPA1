import static org.junit.Assert.*;

import org.junit.*;

public class Tests {
  @Test
  public void testBodyMassIndex() {
    assertEquals("Negative values should not be allowed", "Invalid input", PPA1.bodyMassIndex(5, -8, 140));
    assertEquals("Zero height should not be allowed", "Invalid input", PPA1.bodyMassIndex(0, 0, 140));
    assertEquals("Zero weight should not be allowed", "Invalid input", PPA1.bodyMassIndex(5, 8, 0));
    
	assertEquals("100 lbs at my height should be underweight", "Underweight", PPA1.bodyMassIndex(5, 8, 100));
	assertEquals("My weight and height should be normal", "Normal", PPA1.bodyMassIndex(5, 8, 140));
	assertEquals("180 lbs at my height should be overweight", "Overweight", PPA1.bodyMassIndex(5, 8, 180));
	assertEquals("300 lbs at my height should be obese", "Obese", PPA1.bodyMassIndex(5, 8, 300));
	
	//No need to test return types; code wouldn't compile if return type wasn't correct
	assertEquals("bmiCalculator() should calculate BMI correctly", 21.3, PPA1.bmiCalculator(5, 8, 140), 0.5);
  }

  @Test
  public void testRetirement() {
    assertEquals("Age >= 100 should not be allowed", "Invalid input", PPA1.retirement(100, 1, 1, 1));
	assertEquals("Negative values should not be allowed", "Invalid input", PPA1.retirement(-1, -1, -1, -1));
	assertEquals("Zero values should not be allowed", "Invalid input", PPA1.retirement(0, 0, 0, 0));
	
	assertEquals("Result >= 100 should have special output", "You'll be dead before you reach your goal!", PPA1.retirement(99, 100, 100, 200));
	assertEquals("Calculation should be correct", "You'll reach your goal at age 24", PPA1.retirement(23, 100, 100, 100));
  }

  @Test
  public void testShortestDistance() {
	assertEquals("This seems right", "The distance is 0.0", PPA1.shortestDistance(100, 100, 100, 100));
	assertEquals("distCalc() should return the distance between two coordinates", 316.227766, PPA1.distCalc(100, 100, 200, 400), .5);
  }

  @Test
  public void testSplitTip() {
	assertEquals("Thats too many people", "Number of guests exceeds 50", PPA1.splitTip(51, 100));
	assertEquals("Rounding appropriately is important", 38.33, PPA1.splitter(3, 100), .5);
    assertEquals("Everyone pays their part.", "guest1-38.34\nguest2-38.33\nguest3-38.33\n", PPA1.splitTip(3, 100.00));
  }
}
