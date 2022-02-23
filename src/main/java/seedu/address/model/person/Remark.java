package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the address book.
 */
public class Remark {

    public final String remarkDescription;

    public Remark(String description) {
        requireNonNull(description);
        remarkDescription = description;
    }

    @Override
    public String toString() {
        return remarkDescription;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && remarkDescription.equals(((Remark) other).remarkDescription)); // state check
    }

    @Override
    public int hashCode() {
        return remarkDescription.hashCode();
    }

}
