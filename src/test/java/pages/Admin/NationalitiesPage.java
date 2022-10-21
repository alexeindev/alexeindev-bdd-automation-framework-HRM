package pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NationalitiesPage extends BasePage {

    @FindBy(css = ".orangehrm-main-title")
    private WebElement pageHeaderTitle;

    public NationalitiesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPageHeaderTitle() {
        return pageHeaderTitle;
    }

    public WebElement getDeleteBtnFromNationality(String nationality){
        return driver.findElement(By.xpath("//div[contains(text(),'%s')]/../../div[3]/div/button[1]".formatted(nationality)));
    }

    public void deleteNationality(String nationality){
        WebElement deleteBtn = getDeleteBtnFromNationality(nationality);
        deleteBtn.click();
        clickOnAcceptDeleteBtnFromModal();
    }
}
