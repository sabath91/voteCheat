package org.czyz;

import io.github.bonigarcia.Arguments;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.czyz.Utils.DESTINATION_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SeleniumExtension.class)
public class VoteForBogdan {

    private ChromeDriver driver;

    VoteForBogdan(@Arguments({"--headless", "--disable-gpu"}) ChromeDriver driver) {
        this.driver = driver;
    }


    @Test
    void shouldAccessVotePage() {
        //when
        driver.get(DESTINATION_URL);
        Utils.sleepABit();
        driver.findElement(By.cssSelector("div.rodo a.button")).click();
        Utils.sleepABit();
        Utils.sleepABit();
        driver.findElement(By.cssSelector("div.cookie-bar a.close")).click();
        Utils.sleepABit();
        driver.findElement(By.cssSelector("#yes button")).click();
        Utils.sleepABit();
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        Utils.sleepABit();
        driver.findElement(By.cssSelector("#recaptcha-anchor")).click();
        System.out.println("Voting for Bogdan done with success if capcha was not shown");
        //then
        assertThat(driver.getTitle(), containsString("Bogdan Czyż"));
    }


}
