package TestesCalculo;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;

public class Aula1 {
  private WebDriver driver = new FirefoxDriver();
  //private WebDriver driver = new InternetExplorerDriver(); //ATENCAO: Para automatizar em IE, desabilitar a op��o "Protected Mode" em Security. N�o esque�a de ativar ap�s seus testes!!!
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
    baseUrl = "http://somatematica.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.manage().window().maximize(); //so funciona no chrome*/
    
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_001_adicao() throws Exception { //Teste da adi��o
    //nome e caminho padr�o onde grava os printscreens
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[1]")).click(); //escolhe o operador adi�ao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
    System.out.println("Resultado da Adi��o: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o m�todo sendKeys do selenium funcionar
    tiraScreenshot("c:\\temp\\CT_001_a.jpg");
    driver.findElement(By.name("envia")).click();
    assertEquals("Voc� acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
    tiraScreenshot("c:\\temp\\CT_001_b.jpg");
 }
 
  //////////////////////////////////////////////////////////////////////////////////////////////////

 /*
  @Test
  public void CT_002_subtracao() throws Exception { //teste da subtra��o
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[2]")).click(); //escolhe o operador adi�ao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
    System.out.println("Resultado Subtra��o: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o m�todo sendKeys do selenium funcionar
    tiraScreenshot("c:\\temp\\CT_002_a.jpg");
    driver.findElement(By.name("envia")).click();
    assertEquals("Voc� acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
    tiraScreenshot("c:\\temp\\CT_002_b.jpg");
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_003_multiplicacao() throws Exception { //teste da multiplica��o
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[3]")).click(); //escolhe o operador adi�ao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
    System.out.println("Resultado da Multiplica��o: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o m�todo sendKeys do selenium funcionar
    driver.findElement(By.name("envia")).click();
    assertEquals("Voc� acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_004_divisao() throws Exception { //teste da divis�o
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[4]")).click(); //escolhe o operador adi�ao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
    System.out.println("Resultado da Divis�o: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o m�todo sendKeys do selenium funcionar
    driver.findElement(By.name("envia")).click();
    assertEquals("Voc� acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_005_aleatorio() throws Exception { //teste do aleat�rio
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[5]")).click(); //escolhe a op��o Todos
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    String operador = driver.findElement(By.xpath("//td[2]/div/center/table/tbody/tr/td/p/font/b")).getText(); //obt�m o operador
    int resultado = 0;
    
    switch (operador) {
    	case "+": resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
    	break;
    	case "-": resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
    	break;
    	case "x": resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
    	break;
    	case "�": resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
    	break;
    }
    System.out.println("Resultado: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o m�todo sendKeys do selenium funcionar
    driver.findElement(By.name("envia")).click();
    assertEquals("Voc� acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
  }
*/
  //////////////////////////////////////////////////////////////////////////////////////////////////

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////
 
  public void tiraScreenshot (String scrShot_arq) throws Exception {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(scrShot_arq));
	} //tiraScreenshot

  //////////////////////////////////////////////////////////////////////////////////////////////////
  
}// fim Aula1
