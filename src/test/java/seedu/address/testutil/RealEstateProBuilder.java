package seedu.address.testutil;

import seedu.address.model.RealEstatePro;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building RealEstatePro objects.
 * Example usage: <br>
 *     {@code RealEstatePro rep = new RealEstateProBuilder().withPerson("John", "Doe").build();}
 */
public class RealEstateProBuilder {

    private RealEstatePro realEstatePro;

    public RealEstateProBuilder() {
        realEstatePro = new RealEstatePro();
    }

    public RealEstateProBuilder(RealEstatePro realEstatePro) {
        this.realEstatePro = realEstatePro;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public RealEstateProBuilder withPerson(Person person) {
        realEstatePro.addPerson(person);
        return this;
    }

    public RealEstatePro build() {
        return realEstatePro;
    }
}
