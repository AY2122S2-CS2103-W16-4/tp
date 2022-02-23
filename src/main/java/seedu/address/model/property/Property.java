package seedu.address.model.property;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.StringJoiner;

import seedu.address.model.person.Address;

/**
 * Represents a Property in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Property {

    public static final String MESSAGE_CONSTRAINTS =
        "Property must have have the format: [region, address, size, price]";

    private final Region region;
    private final Address address;
    private final Size size;
    private final Price price;

    /**
     * Every field must be present and not null.
     */
    public Property(Region region, Address address, Size size, Price price) {
        requireAllNonNull(region, address, size, price);
        this.region = region;
        this.address = address;
        this.size = size;
        this.price = price;
    }

    public Region getRegion() {
        return region;
    }

    public Address getAddress() {
        return address;
    }

    public Size getSize() {
        return size;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(region.toString()).add(address.toString()).add(size.toString()).add(price.toString());
        return "Property: " + joiner;
    }

    /**
     * Returns true if both properties have the region, address, size and price.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Property)) {
            return false;
        }

        Property otherProperty = (Property) other;
        return otherProperty.getRegion().equals(getRegion())
            && otherProperty.getAddress().equals(getAddress())
            && otherProperty.getSize().equals(getSize())
            && otherProperty.getPrice().equals(getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, address, size, address, price);
    }

}
