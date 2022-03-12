package seedu.realestatepro.model.tag;

import static seedu.realestatepro.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.realestatepro.model.person.UserType;

public class UserTypeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new UserType(null));
    }

    @Test
    public void constructor_invalidUserType_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new UserType(invalidTagName));
    }

    @Test
    public void isValidUserType() {
        // null user type
        assertThrows(NullPointerException.class, () -> UserType.isValidUserType(null));
    }

}
