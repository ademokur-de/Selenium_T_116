package tests.admDenemeler;

import tests.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;

import java.io.File;

public class ServiceTest extends BaseTest {
    private static File driverLocation;

    @BeforeAll
    public static void installDriver() {
        SeleniumManagerOutput.Result location = DriverFinder.getPath(ChromeDriverService.createDefaultService(), new ChromeOptions());
        driverLocation = new File(location.driverPath);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void defaultService() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .build();
        driver = new ChromeDriver(service);

    }

    @Test
    public void setDriverLocation() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(driverLocation)
                .build();

        driver = new ChromeDriver(service);
    }

    @Test
    public void setPort() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingPort(1234)
                .build();

        driver = new ChromeDriver(service);
    }
}