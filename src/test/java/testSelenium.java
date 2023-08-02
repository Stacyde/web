import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSelenium {
    private WebDriver driver;
    @BeforeAll
     static void setupAll() {
        System.setProperty("web-driver.chrome.driver","./driver/win/chromedriver.exe");
    }
    @BeforeEach
    void setUp(){driver = new ChromeDriver();} //открыть браузер

    @AfterEach
    void tearDown(){
        driver.quit(); //закрыть браузер и обнулить кэш
        driver = null;
    }
    @Test
    void shouldTestV1(){
        driver.get("http://localhost:9999/"); //загрузка страницы
        List<WebElement> inputs = driver.findElements(By.tagName("input"));//найти элемент и заполнить значение
        inputs.get(0).sendKeys("Анастасия Петрова");
        inputs.get(1).sendKeys("+79370357056");
        driver.findElement(By.className("checkbox__box")).click(); // проставить чек-бокс
        driver.findElement(By.className("button__text")).click(); // нажать кнопку
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText(); //получить у элмента, то что в нем написанно
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV2(){
        driver.get("http://localhost:9999/"); //загрузка страницы
        List<WebElement> inputs = driver.findElements(By.tagName("input"));//найти элемент и заполнить значение
        inputs.get(0).sendKeys("Анастасия-Мария Петрова");
        inputs.get(1).sendKeys("+79370357056");
        driver.findElement(By.className("checkbox__box")).click(); // проставить чек-бокс
        driver.findElement(By.className("button__text")).click(); // нажать кнопку
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText(); //получить у элмента, то что в нем написанно
        assertEquals(expected, actual);
    }

}
