package Travel.Makemytrip;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestClassMakemyTrip {
	
	
	
	
	@Test()
	public void test1()
	{
		Baseclass bx = new Baseclass();
		String confrim = bx.getDatafromProperties();
		Assert.assertEquals(confrim, "Review Details");
	}
	
	
	

}
