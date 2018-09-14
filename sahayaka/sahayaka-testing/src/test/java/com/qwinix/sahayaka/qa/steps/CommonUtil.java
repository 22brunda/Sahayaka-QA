package com.qwinix.sahayaka.qa.steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qwinix.sahayaka.qa.BaseDriver;


public class CommonUtil {
	
		//click on MAIN Menu
		public static BaseDriver objBD = new BaseDriver();
		public static WebDriver driver= objBD.driver;

		public void navigateToCommunity(String navigateText) 
		{
			try
			{
			driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')])[5]")).click();
			}
			catch(Exception e)
			{
				return;
			}
		}
		public void navigateToManage(String navigateText)
		{
			try
			{
			driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')])[3]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
		}
		//click on Community Sub Menu 
		public void navigateToCommunitySubMenu(String navigateText)
		{
			try
			{
				driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')])[3]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
			
		}
		//click on Manage Sub menu
		public void navigateToManageSubMenu(String navigateText)
		{
			try
			{
			 driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')])[3]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
		}
		//click on Add spaces(resident,staff,spaces.....)
		public void navigateToAddManageSubMenu(String navigateText)
		{
			try
			{
			driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')])[1]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
		}
		//click on Rentals
		public void navigateToRentals(String navigateText)
		{
			try
			{
			driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')])[5]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
		}
		//click on Spaces sub Menu
		public void navigateToSpacesSubMenu(String navigateText)
		{
			try
			{
			driver.findElement(By.xpath("(//span[contains(.,'"+navigateText+"')]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
			
		}
		//click on any schedule buttons
		public void navigateToCreateAnySchedule(String navigateText)
		{
			try
			{
			driver.findElement(By.xpath("(//a[contains(.,'"+navigateText+"')])[2]")).click();
			}
			catch(Exception e)
			{
				return ;
			}
			
		}
		
		
		
//		public void selectAnyEvent()
//		{
//			
//			List<WebElement> month = StepsDefinitions.driver.findElements(By.xpath("//div[@class='fc-day-grid fc-unselectable']//td"));
//			waitForPageLoaded();
//			System.out.println(month.size());
//			//List<WebElement> rows = StepsDefinitions.driver.findElements(By.xpath("//div[@class='fc-day-grid fc-unselectable']//tr"));
//			
//			
//			for(WebElement ele:month)
//			{
//				String date = ele.getText();
//				System.out.println("------date is--"+date);
//				if(date.equalsIgnoreCase("13"))
//				{
//					System.out.println(date);
//					
//				}
//				else
//				{
//					System.out.println("not found");
//					
//				}
//				break;
//			}
//		       for(WebElement ele:month)
//		       {
//		    	   //StepsDefinitions.driver.findElements(By.xpath("//td");
//		    	   
//		    	   List<WebElement> dates =  ele.findElements(By.xpath("//td"));
//		    	   
//		    	   for(WebElement date: dates)
//		    	   {
//		    		   
//		    	   
//		    	   if(date.getText().equals("13"))
//		    	   {
//		    	   System.out.println(ele.getText());
//		    	   }
//		    	   else
//		    	   {
//		    		  System.out.println("not found"); 
//		    	   }
//		    	   }
//		       }
	//	
		
		
		//}
		
		public void SelectAnyScheduledDates(String date,String name)
		{
			
			WebElement select = driver.findElement(By.xpath("(//div[@class='fc-day-grid fc-unselectable']//td[contains(.,'"+date+"')]/../../../../../..//span[contains(text(),'"+name+"')])[1]"));
			
	        if(select.isDisplayed())
	        {
	        	select.click();
	        }
	        else
	        {
	        	System.out.println("events not scheduled");
	        }
			
		}
		
		//select the dropdown using "select by visible text", pass VisibleText 
		public static void selectByVisibleText(WebElement WE, String VisibleText)
		{
			try
			{
			Select selObj=new Select(WE);
			selObj.selectByVisibleText(VisibleText);
			}
			catch(Exception e)
			{
				return ;
			}
		}
		 
		//select the dropdown using "select by index", so pass IndexValue '
		public static void selectByIndex(WebElement WE, int IndexValue)
		{
			try
			{
			Select selObj=new Select(WE);
			selObj.selectByIndex(IndexValue);
			}
			catch(Exception e)
			{
				return ;
			}
		}
		 
		//select the dropdown using "select by value", so pass Value 
		public static void selectByValue(WebElement WE, String Value)
		{
			try
			{
			Select selObj=new Select(WE);
			selObj.selectByValue(Value);
			}
			catch(Exception e)
			{
				return ;
			}
		}
		
		//To upload images
		public static void uploadImage(WebElement WE,String path) 
		{
			try
			{
			StringSelection sel = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
			WE.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			}
			catch(AWTException e)
			{
				e.printStackTrace();
			}
		}
		
		
		//validate Success Message
		public static void validate(String expRes,WebElement WE)
		{
			try
			{
			Assert.assertEquals(expRes, WE.getText());
			}
			catch(AssertionError e)
			{
				e.printStackTrace();
			}
		}
		
		//Wait for the Element
		public static void waitForElement(WebElement WE)
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(WE));
		}
		//Wait for the Element to be found
		public void waitTillElementFound(WebElement ElementTobeFound,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
				
		}
		
		public static void waitTillPresenceElement(By locator)
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				
		}
		public static void waitTillElementVisibility(By locator)
		{
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}
		public static void implicitWait()
		{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		 
		 
		    public static void waitForPageLoaded()
		    {
		        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
		        {
		                    public Boolean apply(WebDriver driver) 
		                    {
		                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
		                    }
		                };
		        try {

		        	Thread.sleep(5000);
		        	WebDriverWait wait = new WebDriverWait(driver, 60);
		            wait.until(expectation);
		        } 
		        catch (Throwable error)
		        {
		            Assert.fail("Timeout waiting for Page Load Request to complete.");
		        }
		    }
		       
		    
	//To Select the FromDate	    
		    
		    public static void selectDate(String year,String month,String date) 
		    {
		    	try
		    	{    
	    		String currentYear= driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-years-pagination']//a[contains(.,'"+year+"')])[1]")).getText();
	        	//System.out.println(currentYear);
	        	if(currentYear.equalsIgnoreCase(year))
	        	{
	        		WebElement ele = driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-years-pagination']//a[contains(.,'"+year+"')])[1]"));
//	        		JavascriptExecutor executo = (JavascriptExecutor)driver;
//	        		executo.executeScript("arguments[0].click()", ele);	
	        		ele.click();
	        		Thread.sleep(2000);
	        	}
	        	else
	    		{
	    			do{
	    				driver.findElement(By.xpath("(//b[contains(.,'⟩')])[2]")).click();
	    				Thread.sleep(1000);
	    			}
	    			while(!driver.findElement(By.xpath("//div[@class='_720kb-datepicker-calendar-years-pagination']//a[@ng-click='setNewYear(y)']")).getText().equals(year));
	    			
	    		}
	    	
	      	     
	    		// Select desired month after selecting desired year
	    		
	    		String currentMonth=driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[1]")).getText();
	    		String currentMonthYear=month+ " "+currentYear;
	    		System.out.println(currentMonthYear);
	    		System.out.println(currentMonth);
	    		if(currentMonth.equalsIgnoreCase(currentMonthYear))
	    		{
	    			WebElement ele1 = driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[1]"));
//	    			JavascriptExecutor executo = (JavascriptExecutor)StepsDefinitions.driver;
//	        		executo.executeScript("arguments[0].click()", ele1);
	    			ele1.click();
	    			Thread.sleep(2000);
	    		}
	    		else
	    		{
	    			do{
	    				driver.findElement(By.xpath("(//b[contains(.,'⟩')])[1]")).click();
	    				Thread.sleep(1000);
	    			}while(!driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[1]")).getText().equalsIgnoreCase(currentMonthYear));
	    			
	    		}
	    	
	    	    //Select desired date of the month 
	    		
	    		List<WebElement> currdate = driver.findElements(By.xpath("(//div[@class='_720kb-datepicker-calendar-body'])[1]//a[@ng-click='setDatepickerDay(item)']"));
	    		//System.out.println(currdate);
	    		for(WebElement d:currdate)
	    		{
	    			if(d.getText().trim().equalsIgnoreCase(date))
	    			{
	    				d.click();
	    				break;
	    			}
	    		}	
		    	}
		    	catch(Exception e)
		    	{
		    		return;
		    	}
		    }
		    
		    
		  //To Select the EndDate 
		    
		    
		    public static void selectEndDate(String year,String month,String date) 
		    {
		    	try
		    	{
	    		String currentYear= driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-years-pagination']//a[contains(.,'"+year+"')])[2]")).getText();
	        	
	        	if(currentYear.equalsIgnoreCase(year))
	        	{
	        		WebElement element = driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-years-pagination']//a[contains(.,'"+year+"')])[2]"));
	        		element.click();
	        	}
	        	else
	    		{
	    			do{
	    				driver.findElement(By.xpath("(//b[contains(.,'⟩')])[4]")).click();
	    			}
	    			while(!driver.findElement(By.xpath("//div[@class='_720kb-datepicker-calendar-years-pagination']//a[@ng-click='setNewYear(y)']")).getText().equals(year));
	    			
	    		}
	    	
	    		// Select desired month after selecting desired year
	    		
	    		String currentMonth= driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[2]")).getText();
	    		String currentMonthYear=month+ " "+currentYear;
	    		System.out.println(currentMonthYear);
	    		System.out.println(currentMonth);
	    		if(currentMonth.equalsIgnoreCase(currentMonthYear))
	    		{
	    			WebElement ele2 = driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[2]"));
	    		//	JavascriptExecutor executo = (JavascriptExecutor)driver;
	        	//	executo.executeScript("arguments[0].click()", ele1);
	    			ele2.click();
	    		}
	    		else
	    		{
	    			do
	    			{
	    				driver.findElement(By.xpath("(//b[contains(.,'⟩')])[3]")).click();

	    			}
	    			while(!driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[2]")).getText().equalsIgnoreCase(currentMonthYear));
	  
	 }
	    	
	    	    //Select desired date of the month 
	    		
	    		List<WebElement> currdate = driver.findElements(By.xpath("(//div[@class='_720kb-datepicker-calendar-body'])[2]//a[@ng-click='setDatepickerDay(item)']"));
	    		//System.out.println(currdate);
	    		for(WebElement d:currdate)
	    		{
	    			if(d.getText().trim().equalsIgnoreCase(date))
	    			{
	    				d.click();
	    				break;
	    			}
	    		}
		    	}
		    	catch(Exception e)
		    	{
		    		return;
		    	}
		    }
		    

		    //datepickerfor blockslot
		    
			public static void blockslotselectDate(String year,String month,String date) 
		    {
	    	try
		    	{              		
	    		String currentYear= driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-years-pagination']//a[contains(.,'"+year+"')])[3]")).getText();
	    		if(currentYear.equalsIgnoreCase(year))
	        	{
	        		WebElement ele = driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-years-pagination']//a[contains(.,'"+year+"')])[3]"));
	       		ele.click();
	        	}
	        	else
	    		{
	    			do{
	    				driver.findElement(By.xpath("(//b[contains(.,'⟩')])[5]")).click();
	    			}
	    			while(!driver.findElement(By.xpath("//div[@class='_720kb-datepicker-calendar-years-pagination']//a[@ng-click='setNewYear(y)']")).getText().equals(year));
	    			
	    		}   	     	     
	    		
	    		String currentMonth=driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[3]")).getText();
	    		String currentMonthYear=month+ " "+currentYear;
	    		System.out.println(currentMonthYear);
	    		System.out.println(currentMonth);
	    		if(currentMonth.equalsIgnoreCase(currentMonthYear))
	    		{
	    			WebElement ele1 = driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[3]"));
	    			JavascriptExecutor executo = (JavascriptExecutor)driver;
	        		executo.executeScript("arguments[0].click()", ele1);
	    			ele1.click();
	    		}
	    		else
	    		{
	    			do{
	    				driver.findElement(By.xpath("(//b[contains(.,'⟩')])[5]")).click();
	    			}while(!driver.findElement(By.xpath("(//div[@class='_720kb-datepicker-calendar-header-middle _720kb-datepicker-calendar-month ng-binding'])[3]")).getText().equalsIgnoreCase(month));
	    			
	    		}
	    	


	    	    		
	    		List<WebElement> currdate = driver.findElements(By.xpath("(//div[@class='_720kb-datepicker-calendar-body'])//a[@ng-click='setDatepickerDay(item)']"));
	    		for(WebElement d:currdate)
	    		{
	    			if(d.getText().trim().equalsIgnoreCase(date))
	    			{
	    				d.click();
	    				break;
	    			}
	    		}	
		    	}
		    	catch(Exception e)
		    	{
		    		return;
		    	}
		    }	

		    //To Select Calendar to Increment Date
		    
		    public void getStartDate(String startDate) throws ParseException {  
		        Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.DAY_OF_MONTH, 1);
	//
//		        Date tommrrow = cal.getTime();
//		        String tommarrowDate= toddMMyy(tommrrow);
	//
		        Date futuredate = cal.getTime();
		        System.out.println("time= "+futuredate);
		        String tommarrowDate= toddMMyy(futuredate);

		        System.out.println(tommarrowDate); 
		        String[] dateParts = tommarrowDate.split(" ");
		        String Day = dateParts[0]; 
		        String [] date =  {"01","02","03","04","05","06","07","08", "09"};
		        for (int i = 0; i < date.length; i++) {
		    		 	if(date[i].equalsIgnoreCase(Day)) {
		    		 		Day = Day.replaceFirst("0", "");
		    		 		break;
			    	 }
		        }
		    	 String Month = dateParts[1];
		    	 String Year = dateParts[2]; 	 
		    	 if(startDate.equalsIgnoreCase("startdate")) {
		    	 selectDate(Year, Month, Day);
		    	 }else
		    	 {
		    		 selectEndDate(Year, Month, Day);
		    	 }
		    }
		    public static String toddMMyy(Date day){
		        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		        String date = formatter.format(day);
		        return date;
		    }
		    static public String addDay(String date, int no_days) {
		        return LocalDate.parse(date).plusDays(no_days).toString();
		      }
		    public void getBlockslotStartDate(String startDate) throws ParseException {
		        Date today = new Date();   
		        Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.DAY_OF_MONTH, 0);
		        Date tommrrow = cal.getTime();
		        String tommarrowDate= toddMMyy(tommrrow);
		        System.out.println(tommarrowDate); 
		    	 String[] dateParts = tommarrowDate.split(" ");
		    	 String Day = dateParts[0]; 
		    	  String [] date =  {"01","02","03","04","05","06","07","08", "09"};
			        for (int i = 0; i < date.length; i++) {
			    		 	if(date[i].equalsIgnoreCase(Day)) {
			    		 		Day = Day.replaceFirst("0", "");
			    		 		break;
				    	 }
			        }
		    	 String Month = dateParts[1];
		    	 String Year = dateParts[2]; 	 
		    	 if(startDate.equalsIgnoreCase("startdate")) {
		    	 blockslotselectDate(Year, Month, Day);
		    	 }else
		    	 {
		    		 selectEndDate(Year, Month, Day);
		    	 }
		    }
		    
			
			public void confirmationCode() {
				String confirmCode=driver.findElement(By.xpath("(//div[@style='text-align:left'])[2]")).getText();
				String[] parts = confirmCode.split("the Confirmation Code");
				System.out.println(parts);
		        String part2 = parts[1]; 
		        parts = part2.split("and the Employee Activation ");
		        part2 = parts[0]; 
		        System.out.println(part2);
		    }
			
			public void activationCode() {
				String activeCode=driver.findElement(By.xpath("(//div[@style='text-align:left'])[2]")).getText();
				String[] parts = activeCode.split("the Employee Activation Code");
				System.out.println(parts);
		        String part2 = parts[1]; 
		        parts = part2.split("to access the Community");
		        part2 = parts[0]; 
		        System.out.println(part2);
		    }
	}



