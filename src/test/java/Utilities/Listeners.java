package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Listeners extends  BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File inMemory = ss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(inMemory, new File("src\\test\\resources\\ScreenShots\\"
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_kk_mm_ss")) + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
