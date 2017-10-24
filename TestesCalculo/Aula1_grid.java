package TestesCalculo;

//Testes para estudo do Selenium Grid. OBS: geckodriver deve ser versao 0.17 ou inferior 

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

public class Aula1_grid {
  private StringBuffer verificationErrors = new StringBuffer();
  private WebDriver driver;
  private String baseUrl;
  /* Configurar os ips, portas e afins de acordo com a configuração do grid
  private String nodeAll = "http://192.168.163.1:5555/wd/hub"; //grid node All
  private String nodeChrome = "http://192.168.163.1:5556/wd/hub"; //grid node Chrome
  private String nodeFirefox = "http://192.168.163.1:5557/wd/hub"; //grid node Firefox
  */
  
  private String nodeUrl = "http://192.168.163.1:5557/wd/hub"; //grid node generico para efeito de estudos
  
  //definição de qual navegador utilizar
  //DesiredCapabilities caps = DesiredCapabilities.chrome();
  DesiredCapabilities caps = DesiredCapabilities.firefox();

  @Before
  public void setUp() throws MalformedURLException {
	driver = new RemoteWebDriver(new URL(nodeUrl), caps);
    baseUrl = "http://somatematica.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_001_adicao() throws Exception { //Teste da adição
    //nome e caminho padrão onde grava os printscreens
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[1]")).click(); //escolhe o operador adiçao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
    System.out.println("Resultado da Adição: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
    tiraScreenshot("c:\\temp\\CT_001_a.jpg");
    driver.findElement(By.name("envia")).click();
    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
    tiraScreenshot("c:\\temp\\CT_001_b.jpg");
 }
 
  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_002_subtracao() throws Exception { //teste da subtração
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[2]")).click(); //escolhe o operador adiçao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
    System.out.println("Resultado Subtração: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
    tiraScreenshot("c:\\temp\\CT_002_a.jpg");
    driver.findElement(By.name("envia")).click();
    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
    tiraScreenshot("c:\\temp\\CT_002_b.jpg");
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_003_multiplicacao() throws Exception { //teste da multiplicação
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[3]")).click(); //escolhe o operador adiçao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
    System.out.println("Resultado da Multiplicação: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
    driver.findElement(By.name("envia")).click();
    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_004_divisao() throws Exception { //teste da divisão
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[4]")).click(); //escolhe o operador adiçao
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    int resultado;
    resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
    System.out.println("Resultado da Divisão: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
    driver.findElement(By.name("envia")).click();
    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void CT_005_aleatorio() throws Exception { //teste do aleatório
    driver.get(baseUrl + "/matkids/game.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Sullivan");
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/center/p/font[2]/input[5]")).click(); //escolhe a opção Todos
    driver.findElement(By.name("envia")).click();
    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
    String operador = driver.findElement(By.xpath("//td[2]/div/center/table/tbody/tr/td/p/font/b")).getText(); //obtém o operador
    int resultado = 0;
    
    switch (operador) {
    	case "+": resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
    	break;
    	case "-": resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
    	break;
    	case "x": resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
    	break;
    	case "÷": resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
    	break;
    }
    System.out.println("Resultado: " + resultado);
    driver.findElement(By.name("resposta")).clear();
    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
    driver.findElement(By.name("envia")).click();
    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
  }
  
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
