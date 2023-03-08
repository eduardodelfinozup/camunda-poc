package application.camunda;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBase {

	@Test
	public void flagTest() {
		String flag = "false";
		boolean isBoolean = getBooleano( flag);
		System.out.println(isBoolean);
		Assert.assertEquals(isBoolean, false);

	}
	private boolean getBooleano(String flag){
		return flag.equalsIgnoreCase("true") ? true : false;
	}
}

