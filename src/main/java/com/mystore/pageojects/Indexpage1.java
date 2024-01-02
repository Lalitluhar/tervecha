package com.mystore.pageojects;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v115.memory.Memory.GetDOMCountersResponse;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
import com.mystoreactiondriver.Action1;

public class Indexpage1 extends BaseClass {
	Action1 action = new Action1();
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement logobtn;
	
	@FindBy(className="Pke_EE")
	WebElement searchfield;
	
	@FindBy(className = "_2iLD__")
	WebElement searchBtn;
	
	public Indexpage1() {
		 PageFactory.initElements(driver,this);
	}

	public void clickonloginBtn() {
		action.click(driver,loginbtn);
	}
	public boolean Validatelogo() {
		return action.isDisplayed(getDriver(),logobtn);
	}

	private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	public void  searchProduct(String productName) throws InterruptedException {
		action.type(searchfield, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchBtn);
		action.click(getDriver(), searchBtn);
		Thread.sleep(3000);
	
	}

	

}
