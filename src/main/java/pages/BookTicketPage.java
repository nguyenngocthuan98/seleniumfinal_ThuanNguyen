package pages;

import entities.Ticket;
import helpers.Constants;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    private final String dynamicOfValuesByColumn =
            "//table[@class='MyTable WideTable']/tbody/tr/td[count(//th)-count(//th[text()='%s']/following-sibling::th)]";

    //Locators
    private final By bookTicketButton = By.cssSelector("input[type='submit']");
    private final By departFromDropdown = By.cssSelector("select[name='DepartStation']");
    private final By departDateDropdown = By.cssSelector("select[name='Date']");
    private final By arriveAtDropdown = By.cssSelector("select[name='ArriveStation']");
    private final By seatTypeDropdown = By.cssSelector("select[name='SeatType']");
    private final By ticketAmountDropdown = By.cssSelector("select[name='TicketAmount']");
    private final By pageTitle = By.cssSelector("div#content h1[align='center']");
    private final By departFromValue = By.xpath(String.format(dynamicOfValuesByColumn, "Depart Station"));
    private final By arriveAtValue = By.xpath(String.format(dynamicOfValuesByColumn, "Arrive Station"));
    private final By seatTypeValue = By.xpath(String.format(dynamicOfValuesByColumn, "Seat Type"));
    private final By departDateValue = By.xpath(String.format(dynamicOfValuesByColumn, "Depart Date"));
    private final By amountValue = By.xpath(String.format(dynamicOfValuesByColumn, "Amount"));

    //Elements
    private WebElement bookTicketButtonElement() {
        return Constants.WEBDRIVER.findElement(bookTicketButton);
    }

    private WebElement pageTitleElement() {
        return Constants.WEBDRIVER.findElement(pageTitle);
    }

    private WebElement departFromDropdownElement() {
        return Constants.WEBDRIVER.findElement(departFromDropdown);
    }

    private WebElement departDateDropdownElement() {
        return Constants.WEBDRIVER.findElement(departDateDropdown);
    }

    private WebElement arriveAtDropdownElement() {
        return Constants.WEBDRIVER.findElement(arriveAtDropdown);
    }

    private WebElement seatTypeDropdownElement() {
        return Constants.WEBDRIVER.findElement(seatTypeDropdown);
    }

    private WebElement ticketAmountDropdownElement() {
        return Constants.WEBDRIVER.findElement(ticketAmountDropdown);
    }

    private WebElement departFromValueElement() {
        return Constants.WEBDRIVER.findElement(departFromValue);
    }

    private WebElement arriveAtValueElement() {
        return Constants.WEBDRIVER.findElement(arriveAtValue);
    }

    private WebElement seatTypeValueElement() {
        return Constants.WEBDRIVER.findElement(seatTypeValue);
    }

    private WebElement departDateValueElement() {
        return Constants.WEBDRIVER.findElement(departDateValue);
    }

    private WebElement amountValueElement() {
        return Constants.WEBDRIVER.findElement(amountValue);
    }

    //Methods
    public String getPageTitle() {
        return pageTitleElement().getText();
    }

    public String getDepartFromValue() {
        return departFromValueElement().getText();
    }

    public String getArriveAtValue() {
        return arriveAtValueElement().getText();
    }

    public String getSeatTypeValue() {
        return seatTypeValueElement().getText();
    }

    public String getTicketAmountValue() {
        return amountValueElement().getText();
    }

    public String getDepartDateValue() {
        return departDateValueElement().getText();
    }

    public void bookTicket(Ticket ticket) {
        Wait.untilElementVisible(departDateDropdown, Constants.TIME_WAIT);
        ElementHelper.scrollTo(departDateDropdownElement());
        ElementHelper.selectOption(departDateDropdownElement(), ticket.getDepartDate());
        ElementHelper.selectOption(departFromDropdownElement(), ticket.getDepartFrom());
        Wait.untilElementStillAttached(arriveAtDropdownElement(), Constants.QUICK_TIME);
        ElementHelper.selectOption(arriveAtDropdownElement(), ticket.getArriveAt());
        ElementHelper.selectOption(seatTypeDropdownElement(), ticket.getSeatType());
        ElementHelper.selectOption(ticketAmountDropdownElement(), ticket.getAmounts());
        bookTicketButtonElement().click();
    }
}
