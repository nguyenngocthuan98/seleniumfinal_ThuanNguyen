package pages;

import com.logigear.control.common.imp.Link;

public class TimeTablePage extends BasePage {
    private final String dynamicOfBookTicketLink =
            "//table[@class='MyTable WideTable']/tbody/tr[td[text()='%s']/following-sibling::td[text()='%s']]" +
                    "/td/a[text()='book ticket']";

    //Methods
    public void clickBookTicket(String departFrom, String arriveAt) {
        Link lnkBookTicket = new Link("xpath=" + String.format(dynamicOfBookTicketLink, departFrom, arriveAt));

        lnkBookTicket.scrollToView();
        lnkBookTicket.click();
    }
}
