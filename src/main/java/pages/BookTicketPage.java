package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.Label;
import entities.Ticket;

public class BookTicketPage extends BasePage {
    private final String valuesByColumnDynamic =
            "//table[@class='MyTable WideTable']/tbody/tr/td[count(//th)-count(//th[text()='%s']/following-sibling::th)]";

    //Locators
    private final Button bookTicketButton = new Button("css=input[type='submit']");
    private final ComboBox departFromDropdown = new ComboBox("css=select[name='DepartStation']");
    private final ComboBox departDateDropdown = new ComboBox("css=select[name='Date']");
    private final ComboBox arriveAtDropdown = new ComboBox("css=select[name='ArriveStation']");
    private final ComboBox seatTypeDropdown = new ComboBox("css=select[name='SeatType']");
    private final ComboBox ticketAmountDropdown = new ComboBox("css=select[name='TicketAmount']");
    private final Label pageTitle = new Label("css=div#content h1[align='center']");
    private final Label departFromValue = new Label(valuesByColumnDynamic, "Depart Station");
    private final Label arriveAtValue = new Label(valuesByColumnDynamic, "Arrive Station");
    private final Label seatTypeValue = new Label(valuesByColumnDynamic, "Seat Type");
    private final Label departDateValue = new Label(valuesByColumnDynamic, "Depart Date");
    private final Label amountValue = new Label(valuesByColumnDynamic, "Amount");

    //Methods
    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getDepartFromValue() {
        return departFromValue.getText();
    }

    public String getArriveAtValue() {
        return arriveAtValue.getText();
    }

    public String getSeatTypeValue() {
        return seatTypeValue.getText();
    }

    public String getTicketAmountValue() {
        return amountValue.getText();
    }

    public String getDepartDateValue() {
        return departDateValue.getText();
    }

    public void bookTicket(Ticket ticket) {
        departDateDropdown.waitForDisplay();
        departDateDropdown.scrollToView();
        departDateDropdown.select(ticket.getDepartDate());
        departFromDropdown.select(ticket.getDepartFrom());
        arriveAtDropdown.select(ticket.getArriveAt());
        seatTypeDropdown.select(ticket.getSeatType());
        ticketAmountDropdown.select(ticket.getAmounts());
        bookTicketButton.click();
    }
}
