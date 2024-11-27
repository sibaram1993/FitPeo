package fitPeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentWithoutTestNg {

	public static void main(String[] args) throws InterruptedException {
		
				// ====================SETTING UP FIREFOX BROWSER====================
				System.setProperty("webdriver.gecko.driver",""C:\\Users\\user\\git\\FitPeo\\assignment\\rc\\geckodriver.exe"");
				WebDriver dr = new FirefoxDriver();
				Thread.sleep(3000);
				
				//====================1.Navigate to the FitPeo Homepage:====================
				dr.get("https://www.fitpeo.com");
				Thread.sleep(3000);
				dr.manage().window().maximize();
				
				//====================2. Navigate to the Revenue Calculator Page:====================
				Thread.sleep(3000);
				dr.navigate().to("https://www.fitpeo.com/revenue-calculator");
				Thread.sleep(3000);
				
				//====================3.Scroll Down to the Slider section::====================
				WebElement scrool = dr.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/h4"));
				JavascriptExecutor js = (JavascriptExecutor) dr;
				js.executeScript("arguments[0].scrollIntoView(true);", scrool);
				Thread.sleep(3000);
				
				//====================4.1.Adjusting the Slider value 820::====================
				Actions act = new Actions(dr);
				WebElement slider = dr.findElement(By.xpath("//input[@type=\"range\"]"));
				int currentXvalue=slider.getLocation().getX();
				int targetValue=820;
				int travelValue=targetValue-currentXvalue;
				act.dragAndDropBy(slider,travelValue, 0).perform();
				
				//====================4.2.Validating Textfield value::====================
				WebElement textbox =dr.findElement(By.xpath("//input[@id=\":R57alklff9da:\"]"));
				int actualValue= Integer.parseInt(textbox.getAttribute("Value"));
				if(targetValue==actualValue) {
					System.out.println("Q4.The textBox value is matched to slider value."+"\n"+"The value is ="+" "+actualValue);
				}
				else
				{
					System.out.println("Q4.The textBox value is Not matched to slider value."+"\n"+"The value is ="+" "+actualValue);
				}
				Thread.sleep(3000);
				
				//====================5.Update the Text Field:::====================
				
				act.click(textbox);//5.1Clicking on the text field associated with the slider.
				act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
				Thread.sleep(3000);
				act.sendKeys(textbox,"560").perform();//5.2Enter the value 560 in the text field
				
				//====================6.Validate Slider Value:::====================
				int expectedSliderValue=560;
		        int actualSliderValue=Integer.parseInt(slider.getAttribute("value")); 
		        if(actualSliderValue==expectedSliderValue) {
		        	System.out.println("Q6.The  Sliedr Position is Updated to the Textbox value."+"\n"+"The Testcase is passed . Slidervalue is ="+" "+actualSliderValue);
		        }
		        else
				{
					System.out.println("Q6.The  Sliedr Position is not Updated to the Textbox value."+"\n"+"The Testcase is failed .Slider value is ="+" "+actualSliderValue);
				}
				
		        //====================8.Select CPT Codes:====================
		        
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
				
				//====================8.Validate Total Recurring Reimbursement:====================
				
				String TRR=	dr.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 inter css-12bch19\"])[3]")).getText();
						
				System.out.println("Q8.The Total Recurring Reimbursement is = "+" "+TRR);
				
				//====================9.Verify that the header displaying Total Recurring Reimbursement:====================
				
				//Validating the  Total Recurring Reimbursement while slider value is 560.
				String headerValue=	dr.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 inter css-1bl0tdj\"])[4]")).getText();
				String expectedValue="$110700";
				if(headerValue==expectedValue) {
					System.out.println("Q9. Tset case is passed.");
				}
				else {
					System.out.println(" Q9.Tset case is failed for slider value 560.");
					
				}
				Thread.sleep(3000);
								
				//Validating the  Total Recurring Reimbursement while slider value is 820.
				
				WebElement up = dr.findElement(By.xpath("//*[@class=\"MuiTypography-root MuiTypography-h3 crimsonPro css-k7aeh2\"]"));
				js.executeScript("arguments[0].scrollIntoView(true);", up);
				Thread.sleep(3000);
				int cv = slider.getLocation().getX();
				int travelVal=targetValue-cv;
				Thread.sleep(2000);
				act.dragAndDropBy(slider,travelVal, 0).perform();
				Thread.sleep(3000);
				String hValue=dr.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 inter css-1bl0tdj\"])[4]")).getText();
				System.out.println(hValue);
				Thread.sleep(3000);
				
				if(hValue.equals(expectedValue)) {
					System.out.println("Q9. Tset case is passed for silder value 820."+"\n"+"The header value is = "+hValue);
				}
				else {
					System.out.println(" Q9.Tset case is failed for slider value 820.");
					
				}
				
				
				
				}
	
	

	}


