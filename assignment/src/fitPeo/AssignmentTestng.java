package fitPeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssignmentTestng {
	WebDriver dr;
	Actions act ;
	int targetValue;
	WebElement textbox;
	WebElement slider ;
	JavascriptExecutor js;
	String expectedValue;
	
	
	@BeforeTest
	public void browserSetup() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\git\\FitPeo\\assignment\\rc\\geckodriver.exe");
		 dr = new FirefoxDriver();
		Thread.sleep(3000);
	}
	
	@Test(description="Q.1.Navigate to the FitPeo Homepage",priority=1)
	public void NavigatingFitpeo() throws Throwable {
		dr.get("https://www.fitpeo.com");
		Thread.sleep(3000);
		dr.manage().window().maximize();
	}
	
	@Test(description="Q.2.Navigate to the Revenue Calculator Page",priority=2)
	public void RevenueCalculatorPage() throws Throwable {
		Thread.sleep(3000);
		dr.navigate().to("https://www.fitpeo.com/revenue-calculator");
		Thread.sleep(3000);
		}
	
	@Test(description="Q.3.Scroll Down to the Slider section",priority=3)
	public void ScrollToSlider() throws Throwable {
		WebElement scrool = dr.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/h4"));
		js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", scrool);
		Thread.sleep(3000);
	}
	
	@Test(description="Q.4.1.Adjusting slider value to 820",priority=8)
	public void AdjustingTheSlider () throws Throwable {
	
	targetValue=820;
		act= new Actions(dr);
		WebElement up = dr.findElement(By.xpath("//*[@class=\"MuiTypography-root MuiTypography-h3 crimsonPro css-k7aeh2\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", up);
		Thread.sleep(3000);
		slider = dr.findElement(By.xpath("//input[@type=\"range\"]"));
		int cv = slider.getLocation().getX();
		int travelVal=targetValue-cv;
		Thread.sleep(2000);
		act.dragAndDropBy(slider,travelVal, 0).perform();
		Thread.sleep(3000);
			}
	
	@Test(description="Q.4.2.Validating the text field value as per the slider value 820",priority=9)
	public void ValidatTextfieldValue() throws Throwable {
		textbox =dr.findElement(By.xpath("//input[@id=\":R57alklff9da:\"]"));
		targetValue=820;
		int actualValue= Integer.parseInt(textbox.getAttribute("Value"));
		if(targetValue==actualValue) {
			Reporter.log("Q4.The textBox value is matched to slider value."+"\n"+"The value is ="+" "+actualValue,true);
		}
		else
		{
			Reporter.log("Q4.The textBox value is Not matched to slider value."+"\n"+"The value is ="+" "+actualValue,true);
		}
		Thread.sleep(3000);
	}
	
	@Test(description="Q.5.Inserting the vlaue 560 in textbox",priority=4)
	public void UpdateTextField () throws Throwable {
		textbox =dr.findElement(By.xpath("//input[@id=\":R57alklff9da:\"]"));
		act = new Actions(dr);
		act.click(textbox);//5.1Clicking on the text field associated with the slider.
		Thread.sleep(3000);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);
		act.sendKeys(textbox,"560").perform();//5.2Enter the value 560 in the text field
			}
	
	@Test(description="Q.6.Validating the Slider Position as per the Textbox Value",priority=5)
	public void ValidateSliderValue () {
		slider = dr.findElement(By.xpath("//input[@type=\"range\"]"));
		int expectedSliderValue=560;
        int actualSliderValue=Integer.parseInt(slider.getAttribute("value")); 
        if(actualSliderValue==expectedSliderValue) {
        	Reporter.log("Q6.The  Sliedr Position is Updated to the Textbox value."+"\n"+"The Testcase is passed . Slidervalue is ="+" "+actualSliderValue,true);
        }
        else
		{
        	Reporter.log("Q6.The  Sliedr Position is not Updated to the Textbox value."+"\n"+"The Testcase is failed .Slider value is ="+" "+actualSliderValue,true);
		}
	}
	
	
	@Test(description="Q.7.Select CPT Codes",priority=6)
	public void SelectCPTCodes() throws Throwable {
		Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,420)","");//scrooling to CPT_99091
        
        Thread.sleep(3000);
        WebElement CPT99091= dr.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[1]"));
		CPT99091.click(); // Checking on CPT99091 checkbox
		
		Thread.sleep(3000);
		WebElement CPT99453= dr.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[2]"));
		CPT99453.click();// Checking on CPT99453 checkbox
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,440)","");//scrooling to CPT_99454
		Thread.sleep(3000);
		WebElement CPT99454= dr.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[3]"));
		CPT99454.click();// Checking on CPT99454 checkbox
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,600)","");//scrooling to CPT_99474
		Thread.sleep(3000);
		WebElement CPT99474= dr.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[8]"));
		CPT99474.click();
		Thread.sleep(3000);// Checking on CPT99474 checkbox
	}
	
	
	
	@Test(description="Q.8.Validate Total Recurring Reimbursement",priority=7)
	public void TotalRecurringReimbursement() throws Throwable {
		String TRR=	dr.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 inter css-12bch19\"])[3]")).getText();
		
		Reporter.log("Q8.The Total Recurring Reimbursement is = "+" "+TRR,true);
	}
	
	
	
	@Test(description="Q.9.Verify that the header Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.",priority=10)
	public void HeaderTotalRecurringReimbursement() throws Throwable {
		
		//Validating the  Total Recurring Reimbursement while slider value is 820.
		
		String hValue=dr.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 inter css-1bl0tdj\"])[4]")).getText();
		Thread.sleep(3000);
		expectedValue="$110700";
		
		if(hValue.equals(expectedValue)) {
			Reporter.log("Q9.The header value is Matched with the required value."+"\n"+"The header value is = "+hValue,true);
		}
		else {
			Reporter.log(" Q9.Tset case is failed for slider value 820.",true);
			
		}
		dr.close();
		
		

	}
}
	

