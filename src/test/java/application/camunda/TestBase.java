package application.camunda;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class TestBase {

	@Test
	public void flagTest() {
		String flag = "false";
		boolean isBoolean = getBooleano( flag);
		System.out.println(isBoolean);
		Assert.assertEquals(isBoolean, false);

	}

	@Test
	public void randomTest() {
		if(getFlag() == true){
			System.out.println("O valor e > 0");
			System.out.println("flag = true");
		}else{
			System.out.println("O valor e < 0");
			System.out.println("flag = false");
		}
	}

	private boolean getBooleano(String flag){
		return flag.equalsIgnoreCase("true") ? true : false;
	}

	private int gerarValor(){
		Random gerador = new Random();
		return gerador.nextInt();
	}
	private boolean getFlag(){
		int valor = gerarValor();
		System.out.println(valor);
		return valor > 0 ? true : false;
	}
}

