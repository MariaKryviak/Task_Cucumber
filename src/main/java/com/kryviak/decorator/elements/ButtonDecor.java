package com.kryviak.decorator.elements;

import com.kryviak.decorator.MyElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ButtonDecor extends MyElement {

    private static Logger logger = LogManager.getLogger(ButtonDecor.class);

    public ButtonDecor(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        logger.info("Button");
        webElement.click();
    }

    public boolean isDisplayed() {
        logger.info("Button is displayed");
        return webElement.isDisplayed();
    }
}
