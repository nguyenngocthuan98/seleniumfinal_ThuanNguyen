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

    private Button btnCancel(Ticket ticket) {
        return new Button(cancelButtonDynamic,
                ticket.getDepartFrom(),
                ticket.getArriveAt(),
                ticket.getSeatType(),
                ticket.getDepartDate(),
                ticket.getAmounts());
    }

    private Label lblTicketInfo(Ticket ticket) {
        return new Label(ticketDynamic,
                ticket.getDepartFrom(),
                ticket.getArriveAt(),
                ticket.getSeatType(),
                ticket.getDepartDate(),
                ticket.getAmounts());
    }

    //Methods
    public boolean doesTicketExist(Ticket ticket) {
        return lblTicketInfo(ticket).isExist(Constants.SHORT_TIME);
    }

    public boolean waitForDisappearance(Ticket ticket) {
        lblTicketInfo(ticket).waitForDisappear(Constants.SHORT_TIME);
        return lblTicketInfo(ticket).isExist(Constants.SHORT_TIME);
    }

    public void cancelTicket(Ticket ticket) {
        btnCancel(ticket).scrollToView();
        btnCancel(ticket).click();
        DriverUtils.acceptAlert();
    }
}
