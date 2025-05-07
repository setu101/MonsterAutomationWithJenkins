import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HomePageTest {
    public static WebDriver driver;
    public static Properties properties;

    public HomePageTest() {


        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("/Users/setu/IdeaProjects/BuildAutomaitonWithJenkins/src/test/java/secret.properties");
            properties.load(fileInputStream);
        } catch (
                FileNotFoundException var2) {
            FileNotFoundException e = var2;
            e.printStackTrace();
        } catch (
                IOException var3) {
            IOException e = var3;
            e.printStackTrace();
        }

    }

    @BeforeMethod
    public static void setUp() {
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();

        }else if (browserName.equals("FF")){
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.get(properties.getProperty("url"));

    }

    @Test
    public void FindJobsLinkTest(){

        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[1]/a")).click();

    }

    @Test
    public void SalaryToolLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[2]/a")).click();
    }

    @Test
    public void CareerAdviceLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[3]/a")).click();

    }


    @Test

    public void ResumeHelpLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[4]/a")).click();
    }

    @Test
    public void UploadResumeLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[5]/a")).click();

    }

  @Test
  public  void SignUpLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/div/div[4]/div/a[1]/span")).click();
  }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }


}
