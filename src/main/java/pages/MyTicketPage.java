package pages;

import entities.Ticket;
import helpers.Constants;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {
    String cancelButtonDynamic = "//tr//td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::input[@value='Cancel']";
    String ticketDynamic = "//tr//td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::td[text()='%s']" +
            "//following::td[text()='%s']";

    //Elements
    private WebElement cancelButtonElement(Ticket ticket) {
        By cancelButton = By.xpath(String.format(cancelButtonDynamic,
                ticket.getDepartFrom(),
                ticket.getArriveAt(),
                ticket.getSeatType(),
                ticket.getDepartDate(),
                ticket.getAmounts())
        );
        return Constants.WEBDRIVER.findElement(cancelButton);
    }

    //Methods
    public boolean doesTicketExist(Ticket ticket){
        By ticketInformation = By.xpath(String.format(ticketDynamic,
                ticket.getDepartFrom(),
                ticket.getArriveAt(),
                ticket.getSeatType(),
                ticket.getDepartDate(),
                ticket.getAmounts())
        );
        return !Constants.WEBDRIVER.findElements(ticketInformation).isEmpty();
    }

    public void cancelTicket(Ticket ticket) {
        ElementHelper.scrollTo(cancelButtonElement(ticket));
        cancelButtonElement(ticket).click();
        Wait.untilAlertPopupDisplays(Constants.QUICK_TIME);
        ElementHelper.acceptAlert();
    }
}
