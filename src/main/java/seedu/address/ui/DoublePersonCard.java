package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

public class DoublePersonCard extends UiPart<Region> {

    private static final String FXML = "DoublePersonCard.fxml";

    private Person seller;
    private Person buyer;

    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label property;
    @FXML
    private Label preference;
    @FXML
    private FlowPane userType;

    @FXML
    private Label name2;
    @FXML
    private Label phone2;
    @FXML
    private Label address2;
    @FXML
    private Label email2;
    @FXML
    private Label property2;
    @FXML
    private Label preference2;
    @FXML
    private FlowPane userType2;

    /**
     * Creates a {@code DoublePersonCard} with the given two persons.
     */
    public DoublePersonCard(Person seller, Person buyer) {
        super(FXML);
        this.seller = seller;
        this.buyer = buyer;

        // seller card
        name.setText(seller.getName().fullName);
        phone.setText(seller.getPhone().value);
        address.setText(seller.getAddress().value);
        email.setText(seller.getEmail().value);

        if (!seller.getProperties().isEmpty()) {
            property.setText(seller.getProperties().toString());
        } else {
            property.setVisible(false);
        }

        if (seller.getPreference().isPresent()) {
            preference.setText(seller.getPreference().get().toString());
        } else {
            preference.setVisible(false);
        }

        userType.getChildren().add(new Label(seller.getUserType().value));

        // buyer card
        name2.setText(buyer.getName().fullName);
        phone2.setText(buyer.getPhone().value);
        address2.setText(buyer.getAddress().value);
        email2.setText(buyer.getEmail().value);

        if (!buyer.getProperties().isEmpty()) {
            property2.setText(buyer.getProperties().toString());
        } else {
            property2.setVisible(false);
        }

        if (buyer.getPreference().isPresent()) {
            preference2.setText(buyer.getPreference().get().toString());
        } else {
            preference2.setVisible(false);
        }

        userType2.getChildren().add(new Label(buyer.getUserType().value));
    }
}
