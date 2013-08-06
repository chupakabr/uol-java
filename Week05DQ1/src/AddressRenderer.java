import java.util.Map;

/**
 * Created by myltik
 * Created on 8/1/13 8:56 PM
 */
public class AddressRenderer implements DataRenderer<PersonContacts> {

    @Override
    public String render(PersonContacts contacts) {
        StringBuilder builder = new StringBuilder();

        builder.append("<html>Address: <ul>")
                .append("<li>First name: " + contacts.getFirstName())
                .append("<li>Last name: " + contacts.getLastName())
                .append("<li>Phone number: " + contacts.getPhoneNumber());

        for (Map.Entry<String, Object> entry : contacts.getExtraInfo().entrySet()) {
            builder.append("<li>" + entry.getKey() + ": " + entry.getValue());
        }

        builder.append("</ul></html>");

        return builder.toString();
    }
}
