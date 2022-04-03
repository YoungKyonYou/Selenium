package com.example.selenium.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\USER\\selenium\\chromedriver.exe";
    public Controller() {
        //Driver SetUp
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        base_url = "http://128.11.2.201:8080/login.action";
    }
    @GetMapping("/execute")
    public String test(){
        crawl();
        return "Success";
    }
    private WebDriver driver;


    //크롤링 할 URL
    private String base_url;



    public void crawl() {

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            Thread.sleep(2000);
            //아이디 비밀번호 변수에 저장
            WebElement username=driver.findElement(By.id("textfield-1013-inputEl"));

            WebElement password=driver.findElement(By.id("textfield-1016-inputEl"));

            WebElement login=driver.findElement(By.id("container-1017-innerCt"));
            username.sendKeys("08541");

            password.sendKeys("08541");


            Thread.sleep(900);
            login.click();
            Thread.sleep(4000);






            WebElement catalogueBtn=driver.findElement(By.id("Meta_MBZ400000_topmenu"));
            catalogueBtn.click();

            Thread.sleep(3000);

            WebElement tableSearchBtn=driver.findElement(By.id("treeview-1014-record-33124149-bcb9-4b91-85bf-9550dba77278"));
            tableSearchBtn.click();

            WebElement inputTable=driver.findElement(By.id("textfield-1249-inputEl"));
            inputTable.sendKeys("TB_ACCH_GTHFEECALC_C");
            Thread.sleep(1000);

            WebElement searchTableBtn=driver.findElement(By.id("button-1254"));
            searchTableBtn.click();
            Thread.sleep(1000);



            WebElement selectTable=driver.findElement(By.xpath("//*[text()='NEXS']"));
            Actions act = new Actions(driver);
            act.doubleClick(selectTable).perform();
            Thread.sleep(1000);


            //className에 해당하는 모든 버튼 가져오기
            List<WebElement> btns=driver.findElements(By.className("icon-excel"));
            //두 번째 버튼 선택
            WebElement excelBtn = btns.get(1);
            excelBtn.click();



            Thread.sleep(10000);


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }
}
