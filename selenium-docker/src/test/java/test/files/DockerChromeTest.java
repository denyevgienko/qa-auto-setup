package test.files;

import driver.manager.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DockerChromeTest {

    @BeforeSuite
    public void before() throws IOException {

        String[] command = {"bash", "start-docker.sh"};
        System.out.println(System.getProperties());

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(System.getProperty("user.dir") + "/src/main/java/docker/compose/files"));

        try {
            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null && !line.contains("Selenium Grid hub is up and running")) {
                System.out.println(line);
            }

            process.waitFor(10, TimeUnit.SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void after() throws IOException {
        String[] command = {"bash", "stop-docker.sh"};
        System.out.println(System.getProperties());

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(System.getProperty("user.dir") + "/src/main/java/docker/compose/files"));

        try {
            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            reader.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.driver;
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test1 ");
    }

    @Test
    public void test2() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.driver;
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test2 ");
    }

    @Test
    public void test3() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.driver;
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test3 ");
    }

    @Test
    public void test4() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.getDriver(new DesiredCapabilities(DesiredCapabilities.firefox()));
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test4 ");
    }

}
