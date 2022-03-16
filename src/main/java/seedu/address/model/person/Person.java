package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.property.Property;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private Optional<Favourite> favourite;

    // Data fields
    private final Address address;
    private final Optional<Property> property;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * This constructor is used when editing a Client.
     * Favourited clients will remain favourited
     */
    public Person(Name name, Phone phone, Email email, Optional<Favourite> favourite, Address address,
                  Optional<Property> property, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, favourite, address, property, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.favourite = favourite;
        this.property = property;
        this.address = address;
        this.tags.addAll(tags);
    }

    /**
     * Every field must be present and not null.
     * This constructor is used for adding a new Client that
     * does not have a Favourite field by default (not favourited at the start)
     */
    public Person(Name name, Phone phone, Email email, Address address,
                  Optional<Property> property, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, property, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.property = property;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Optional<Favourite> getFavourite() {
        return favourite;
    }

    /**
     * Creates the favourite status of Person such that he/she is favourited
     */
    public void createFavouriteStatus() {
        Optional<Favourite> favouriteStatus = Optional.of(new Favourite(true));
        favourite = favouriteStatus;
    }

    public Address getAddress() {
        return address;
    }

    public Optional<Property> getProperty() {
        return property;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getProperty().equals(getProperty())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, favourite, address, property, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Favourite: ")
                .append(getFavourite())
                .append("; Address: ")
                .append(getAddress());

        if (getProperty().isPresent()) {
            builder.append("; Property: ");
            builder.append(getProperty().get());
        }

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }
}
