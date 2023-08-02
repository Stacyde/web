import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSelenium {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestV1() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петрова Анастасия");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370357056");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV2() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петрова Анастасия-Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370357056");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestV3() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петрова Анастасия-Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("79370357056");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElements(By.className("input__sub")).get(1).getText();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestV4() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петрова Анастасия-Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys(" ");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElements(By.className("input__sub")).get(1).getText();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV5() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys(" ");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370357056");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.className("input__sub")).getText();
        assertEquals(expected, actual);
    }
     @Test
    void shouldTestV6() {
         driver.get("http://localhost:9999/");
         driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петрова Анастасия-Мария");
         driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370357056");
         driver.findElement(By.className("button__text")).click();
         String expected = "Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй";
         String actual = driver.findElement(By.className("input_invalid")).getText();
         assertEquals(expected, actual);
     }
    @Test
    void shouldTestV7() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Petrova Anastasia");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370357056");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText();
        assertEquals(expected, actual);
    }


}
