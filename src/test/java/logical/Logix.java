package logical;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.globalUtils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logix extends Utils {
	//String input1;
	//String input2;
	//String url;
	WebDriver driver;
	WebDriverWait wait;
	@FindBy (id="districtCode")
	public WebElement dd_district;
	@FindBy (id="talukCode")
	public WebElement dd_taluk;
	@FindBy (id="villageCode")
	public WebElement dd_village;
	
	String input1 = propertyFileReader("Word1");
	String  input2 = propertyFileReader("Word2");
	String  url = propertyFileReader("url");
	
	@Test
	public  void reverseLetterInString() {
		String s2="";
		String rev ="";
		String[] split = input1.split(" ");
		
		for (int i = 0; i < split.length; i++) {
			s2=split[i];
			String s3="";
			for (int j = s2.length()-1; j >=0; j--) {
				char c = s2.charAt(j);
			s3=s3+c;
			}
			
			rev=rev+s3+" ";
		}
		System.out.print(rev);
	}
			
	@Test
	public  void reverseWordsAndLetter(){
	String rev ="";
	String letRev="";
	String[] split = input2.split(" ");
	
	for (int i = split.length-1; i >=0; i--) {
		
		rev=split[i];
		String s1="";
		for (int j = rev.length()-1; j >=0; j--) {
			char c = rev.charAt(j);
		s1=s1+c;
		}	
		letRev=letRev+s1+" ";
	}
	System.out.println(letRev);
	}
@Test
  public void randomOrderSelection() {
		System.out.println(url);
		Actions act=new Actions(driver);
		Random rand= new Random();
	driver.get(url);
//	WebElement searchField = driver.findElement(By.xpath("//textarea[@title='Search']"));
//	searchField.sendKeys("tn patta chitta");
//	WebElement btn_googleSearch = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//child::input[@value='Google Search']"));
//    btn_googleSearch.click();
//	WebElement st_googleSearch = driver.findElement(By.xpath("(//span[text()='tn patta chitta'])[1]"));
//	st_googleSearch.click();
//    
	//act.sendKeys(Keys.ENTER).perform();
  //  driver.findElement(By.xpath("//a[@href='https://eservices.tn.gov.in/eservicesnew/index.html']")).click();
    WebElement btn_viewPatta_Chitta = driver.findElement(By.xpath("//a[contains(@href,'land/chittaCheckNewRural_en.html')]"));
    
    act.moveToElement(btn_viewPatta_Chitta).perform();
    btn_viewPatta_Chitta.click();
    for (int i = 0; i < 5; i++) {
		
	
  //  WebElement dd_district = driver.findElement(By.id("districtCode"));
    	//driver.findElement(By.id("talukCode")) driver.findElement(By.id("villageCode"))
   wait.until(ExpectedConditions.visibilityOf(dd_district));
     Select select = new Select(dd_district);
     dd_district.click();
     int dist_count = select.getOptions().size();
     System.out.println("The District Count is: "+ dist_count);
     
     int ran_dist = (int) Math.floor(rand.nextInt(dist_count));
     System.out.println("The District Index is: "+ ran_dist);
     if(ran_dist==0) {
    
    	 ran_dist=ran_dist+1;
    	// dd_district.click();
    	 select.selectByIndex(ran_dist); 
     }
     else {
    	// dd_district.click();
    	 select.selectByIndex(ran_dist); 
     }
    wait.until(ExpectedConditions.visibilityOf(dd_taluk));
    Select select1 = new Select(dd_taluk);
    dd_taluk.click();
    int taluk_count = select1.getOptions().size();
    int ran_taluk = (int) Math.floor(rand.nextInt(taluk_count));
    System.out.println("The Taluk Count is: "+ taluk_count);
    System.out.println("The Taluk Index is: "+ ran_taluk);
    if(ran_taluk==0) {
  //  dd_taluk.click();
    select1.selectByIndex(ran_taluk+1);
    }
    else {
    	//dd_taluk.click();
    	select1.selectByIndex(ran_taluk);
    }
    wait.until(ExpectedConditions.visibilityOf(dd_village));
    Select select2 = new Select(dd_village);
    dd_village.click();
    int village_count = select2.getOptions().size();
    System.out.println("The Village Count is: "+ village_count);
    int ran_village = (int) Math.floor(rand.nextInt(village_count));
    System.out.println("The Village Index is: "+ ran_village);
    if(ran_village==0) {
    	//dd_village.click();
    select2.selectByIndex(ran_village+1);
    }
    else {
    	//dd_village.click();
    	select2.selectByIndex(ran_village);
    }
    }
    

}

	}


