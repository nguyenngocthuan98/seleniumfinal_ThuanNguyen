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
    private final By valueOfDepartFrom = By.xpath(String.format(dynamicOfValuesByColumn, "Depart Station"));
    private final By valueOfArriveAt = By.xpath(String.format(dynamicOfValuesByColumn, "Arrive Station"));
    private final By valueOfSeatType = By.xpath(String.format(dynamicOfValuesByColumn, "Seat Type"));
    private final By valueOfDepartDate = By.xpath(String.format(dynamicOfValuesByColumn, "Depart Date"));
    private final By valueOfAmount = By.xpath(String.format(dynamicOfValuesByColumn, "Amount"));

    //Elements
    private WebElement bookTicketButtonElement() {
        return Constants.WEBDRIVER.findElement(bookTicketButton);
    }

    private WebElement titleOfPageElement() {
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

    private WebElement valueOfDepartFromElement() {
        return Constants.WEBDRIVER.findElement(valueOfDepartFrom);
    }

    private WebElement valueOfArriveAtElement() {
        return Constants.WEBDRIVER.findElement(valueOfArriveAt);
    }

    private WebElement valueOfSeatTypeElement() {
        return Constants.WEBDRIVER.findElement(valueOfSeatType);
    }

    private WebElement valueOfDepartDateElement() {
        return Constants.WEBDRIVER.findElement(valueOfDepartDate);
    }

    private WebElement valueOfAmountElement() {
        return Constants.WEBDRIVER.findElement(valueOfAmount);
    }

    //Methods
    public String getPageTitle() {
        return titleOfPageElement().getText();
    }

    public String getValueOfDepartFrom() {
        return valueOfDepartFromElement().getText();
    }

    public String getValueOfArriveAt() {
        return valueOfArriveAtElement().getText();
    }

    public String getValueOfSeatType() {
        return valueOfSeatTypeElement().getText();
    }

    public String getValueOfTicketAmount() {
        return valueOfAmountElement().getText();
    }

    public String getValueOfDepartDate() {
        return valueOfDepartDateElement().getText();
    }

    public void bookTicket(Ticket ticket) {
        Wait.untilElementVisible(departDateDropdown, Constants.TIME_WAIT);
        ElementHelper.scrollTo(departDateDropdownElement());
        ElementHelper.selectOption(departDateDropdownElement(), ticket.getDepartDate());
        ElementHelper.selectOption(departFromDropdownElement(), ticket.getDepartFrom());
        Wait.notStalenessOf(arriveAtDropdownElement(), Constants.QUICK_TIME);
        ElementHelper.selectOption(arriveAtDropdownElement(), ticket.getArriveAt());
        ElementHelper.selectOption(seatTypeDropdownElement(), ticket.getSeatType());
        ElementHelper.selectOption(ticketAmountDropdownElement(), ticket.getAmounts());
        bookTicketButtonElement().click();
    }
}
