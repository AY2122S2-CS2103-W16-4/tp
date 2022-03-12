package seedu.realestatepro.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.realestatepro.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.realestatepro.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.realestatepro.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.realestatepro.commons.core.Messages;
import seedu.realestatepro.commons.core.index.Index;
import seedu.realestatepro.logic.commands.exceptions.CommandException;
import seedu.realestatepro.model.AddressBook;
import seedu.realestatepro.model.Model;
import seedu.realestatepro.model.ModelManager;
import seedu.realestatepro.model.UserPrefs;
import seedu.realestatepro.model.person.Person;

class FavouriteCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    void execute_favouriteOnValidIndexUnfilteredList_success() throws CommandException {
        Person personToFavourite = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        CommandResult commandResult = new FavouriteCommand(INDEX_FIRST_PERSON).execute(expectedModel);

        /* Runs test based on the starting favourite status of the first person in the address book */
        if (!personToFavourite.getFavourite().getStatus()) {
            assertEquals(
                    String.format(FavouriteCommand.MESSAGE_UNFAVOURITE_PERSON_SUCCESS, personToFavourite.getName()),
                    commandResult.getFeedbackToUser());
        } else {
            assertEquals(
                    String.format(FavouriteCommand.MESSAGE_FAVOURITE_PERSON_SUCCESS, personToFavourite.getName()),
                    commandResult.getFeedbackToUser());
        }
    }

    @Test
    public void execute_favouriteOnInvalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        FavouriteCommand favouriteCommand = new FavouriteCommand(outOfBoundIndex);

        assertCommandFailure(favouriteCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

}
