package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Opens up the Favourites Window that displays the list of favourited clients
 */
public class FavouritesWindowCommand extends Command {
    public static final String COMMAND_WORD = "fw";
    public static final String MESSAGE_FAVOURITES_WINDOW_SUCCESS =
            "Successfully opened Favourites Window!\nCheck that all favourited clients are present in the window.";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Opens up the Favourites Window that displays the list of favourited clients\n"
            + "Example: " + COMMAND_WORD;

    public FavouritesWindowCommand() {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new CommandResult(MESSAGE_FAVOURITES_WINDOW_SUCCESS, false, false, true);
    }
}
