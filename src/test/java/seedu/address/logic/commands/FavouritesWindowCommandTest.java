package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.FavouritesWindowCommand.MESSAGE_FAVOURITES_WINDOW_SUCCESS;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class FavouritesWindowCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_favouriteswindow_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_FAVOURITES_WINDOW_SUCCESS,
                 false, false, false, true);
        assertCommandSuccess(new FavouritesWindowCommand(), model, expectedCommandResult, expectedModel);
    }
}
