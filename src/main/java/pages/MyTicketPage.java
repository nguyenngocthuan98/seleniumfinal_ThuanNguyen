package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.driver.DriverUtils;
import entities.Ticket;
import helpers.Constants;

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

    private Button cancelButton(Ticket ticket) {
        return new Button(cancelButtonDynamic,
                ticket.getDepartFrom(),
                ticket.getArriveAt(),
                ticket.getSeatType(),
                ticket.getDepartDate(),
                ticket.getAmounts());
    }

    //Methods
    public boolean doesTicketExist(Ticket ticket) {
        Label ticketInformation = new Label(ticketDynamic,
                ticket.getDepartFrom(),
                ticket.getArriveAt(),
                ticket.getSeatType(),
                ticket.getDepartDate(),
                ticket.getAmounts());
        return ticketInformation.isExist(Constants.QUICK_TIME);
    }

    public void cancelTicket(Ticket ticket) {
        cancelButton(ticket).scrollToView();
        cancelButton(ticket).click();
        DriverUtils.acceptAlert();
    }
}
