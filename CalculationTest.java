import static org.junit.Assert.*;

import org.junit.Test;


public class CalculationTest {

	@Test
	public void testGet_deflection() {
		
				String output1;
						
				Calculation cal = new Calculation();
				output1 = Calculation.get_deflection(460, 240, "120");
				assertEquals("Right", output1 );
				
			}

		}
