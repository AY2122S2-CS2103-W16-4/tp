package seedu.realestatepro.logic.commands;

import static seedu.realestatepro.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.realestatepro.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.realestatepro.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.realestatepro.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.realestatepro.model.Model;
import seedu.realestatepro.model.ModelManager;
import seedu.realestatepro.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
