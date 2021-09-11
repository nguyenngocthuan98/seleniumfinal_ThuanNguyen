package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.Label;
import entities.Ticket;

public class BookTicketPage extends BasePage {
    private final String valuesByColumnDynamic =
            "//table[@class='MyTable WideTable']/tbody/tr/td[count(//th)-count(//th[text()='%s']/following-sibling::th)]";

    //Locators
    private final Button btnBookTicket = new Button("css=input[type='submit']");
    private final ComboBox cbbDepartFrom = new ComboBox("css=select[name='DepartStation']");
    private final ComboBox cbbDepartDate = new ComboBox("css=select[name='Date']");
    private final ComboBox cbbArriveAt = new ComboBox("css=select[name='ArriveStation']");
    private final ComboBox cbbSeatType = new ComboBox("css=select[name='SeatType']");
    private final ComboBox cbbTicketAmount = new ComboBox("css=select[name='TicketAmount']");
    private final Label lblPageTitle = new Label("css=div#content h1[align='center']");
    private final Label lblDepartFromValue = new Label(valuesByColumnDynamic, "Depart Station");
    private final Label lblArriveAtValue = new Label(valuesByColumnDynamic, "Arrive Station");
    private final Label lblSeatTypeValue = new Label(valuesByColumnDynamic, "Seat Type");
    private final Label lblDepartDateValue = new Label(valuesByColumnDynamic, "Depart Date");
    private final Label lblAmountValue = new Label(valuesByColumnDynamic, "Amount");

    //Methods
    public String getPageTitle() {
        return lblPageTitle.getText();
    }

    public String getDepartFromValue() {
        return lblDepartFromValue.getText();
    }

    public String getArriveAtValue() {
        return lblArriveAtValue.getText();
    }

    public String getSeatTypeValue() {
        return lblSeatTypeValue.getText();
    }

    public String getTicketAmountValue() {
        return lblAmountValue.getText();
    }

    public String getDepartDateValue() {
        return lblDepartDateValue.getText();
    }

    public String getDepartStationSelectedValue() {
        return new ComboBox("xpath=//select[@name='DepartStation']/option[@selected='selected']").getText();
    }

    public String getArriveStationSelectedValue() {
        return new ComboBox("xpath=//select[@name='ArriveStation']/option[@selected='selected']").getText();
    }

    public void bookTicket(Ticket ticket) {
        cbbDepartDate.waitForDisplay();
        cbbDepartDate.scrollToView();
        cbbDepartDate.select(ticket.getDepartDate());
        cbbDepartFrom.select(ticket.getDepartFrom());
        cbbArriveAt.select(ticket.getArriveAt());
        cbbSeatType.select(ticket.getSeatType());
        cbbTicketAmount.select(ticket.getAmounts());
        btnBookTicket.click();
    }
}
