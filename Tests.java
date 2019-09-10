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
    //TODO: Tests go here
  }

  @Test
  public void testSplitTip() {
    //TODO: Tests go here
  }
}
