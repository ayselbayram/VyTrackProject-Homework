package Tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;
    //table
    //thead--table header(coloumn names)
    //tbody--table body(content)
    //tr--table row
    //td--table data
    //th-- table header data
    @BeforeMethod
    public void setup(){

        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait=new WebDriverWait(driver,15);
        //explicit wit:related to presence of element
        //this wait can be used anywhere
        //always recommended to use before finding element
        //if you are getting noSuchElementException Vasyl recommend to use this wait
        // for any element not only webtable
        //wait for presence of table 1
        //difference vit visible and precense
        //precence can not be visible but there
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }
    @Test(description = "print table 1 data")
    public void test1(){
        //<table> stands for webtable in HTML
        //table1 is id of first table
        //once we find this table as webelement, we can print all text from there
        //put explicit wait rigth before the find weblemenet command
        //related to presence of element
        //this wait can be used anywhere
        //always recommended to use before finding element
        //if you are getting noSuchElementException Vasyl recommend to use this wait
        // for any element not only webtable
        WebElement table1=driver.findElement(By.id("table1"));
        System.out.println(table1.getText());

    }
    @Test(description = "verify that number of colouns in the first table is equals to 6")
    public void test2(){
       //size=number of element that is why we need to say findelementS
        int actualColumnNumber=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber=6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber);
    }


    //to exclude first row(thead rows)=//table[@id='table1']//tbody//tr
    // "//" means any child, in this case ant tr element of the table
    @Test(description = "verify that number of raws is equals to 5")
    public void test3(){
      int expectedNumberOfRaws=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
      int actualNumberOfRaws=5;
      Assert.assertEquals(actualNumberOfRaws,expectedNumberOfRaws,"");
    }
    /*
    use findelements to find all values from 2nd raw
    then iterate through the collection of elements with for each lopp
    print text of every element from new line
     */
    @Test(description = "print all values from the 2.row (excluding table heder) ")
    public void test4(){
        List<WebElement> row =  driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for(WebElement cell:row){
            System.out.println(cell.getText());
        }


    }
    @Test(description = "print all values from the n-th row (excluding table header)")
    public void test5(){
        //if index = 1, then it's a first row
        //if index = 2, then it's a second row
        //if we don't specify td index, it will take all td elements
        //in css we use space " ", in xpath // to get to any child
        //or in css we use ">", in xpath /, to get to direct child
        //css selector alternative: table[id='table1'] tbody tr:nth-of-type(2) td
        //if index will exceed table size, you will not get any errors, list will be just empty
        //findElements() doesn't give NoSuchElementException, in any case.
        int index=3;
        List<WebElement> row =  driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+index+"]//td"));
        for(WebElement cell:row){
            System.out.println(cell.getText());
        }
    }
    @Test(description = "verify that e mail in the 3. row is equal to jdoe@hotmail.com")
    public void test6(){
        int row=3;//represents row number
        int colum=3;//represent column number
        //combination of tr and td index will give us specific ell value
    WebElement cell=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+colum+"]"));
    String actualEmail=cell.getText();
    String expectedEmail="jdoe@hotmail.com";
    Assert.assertEquals(actualEmail,expectedEmail);
    }
    /*
    get all values from email column and verify that every value contains @
    if no- fail test.
     */
    @Test(description = "verify that every email contains '@'")
    public void test7(){
        ////table[@id='table1']//tbody//td[3]--this works too
        //td[3] --mean 3. column
        //we are skippinng tr because we need data from all rows
        List <WebElement> cells=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
        for(WebElement email:cells) {
            System.out.println(email.getText());
            Assert.assertTrue(email.getText().contains("@"),"email not contains @");
        }
    }
    /*
    step1=click on last name
    step2=Get all values from "last name" column
    step3= verify that column is sorted in alphabetic order
     */
    @Test(description = "verify that author clicking on Last Name, values will be sorted in alphabetic order")
    public void test8(){
        WebElement lastName=driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']"));
        lastName.click();
        List<WebElement> lastNames=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        for(int i=0;i<lastNames.size()-1;i++){
           String value=lastNames.get(i).getText();
           String followingLastName=lastNames.get(i+1).getText();
            System.out.println("===iteration: "+i);
            System.out.println("Current Last Name "+value);
            System.out.println("Current Last Name "+followingLastName);
            System.out.println("======================");
           Assert.assertTrue(value.compareTo(followingLastName)<0);
        }


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    public static void main(String[] args) {
        //if result is less then 0, sequence of words is correct or in alpahbetical order
        //if the resukt is 0, words are equals
        //if result is positive, sequence of words is opposite to aplhabetic order
        String word1= "ab";//97 in ASCII table
        String word2="ac";//100 is ASCII table
        //a-d=-3
        //it checks cjaracter by character
        //if first character is the same, checks the next characters
        System.out.println(word1.compareTo(word2));
    }
}
