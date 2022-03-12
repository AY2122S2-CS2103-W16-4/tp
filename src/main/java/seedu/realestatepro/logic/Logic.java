package seedu.realestatepro.logic;

import java.nio.file.Path;
import java.util.List;

import javafx.collections.ObservableList;
import seedu.realestatepro.commons.core.GuiSettings;
import seedu.realestatepro.commons.core.Pair;
import seedu.realestatepro.logic.commands.CommandResult;
import seedu.realestatepro.logic.commands.exceptions.CommandException;
import seedu.realestatepro.logic.parser.exceptions.ParseException;
import seedu.realestatepro.model.ReadOnlyAddressBook;
import seedu.realestatepro.model.person.Person;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the AddressBook.
     *
     * @see seedu.realestatepro.model.Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Person> getFilteredPersonList();

    /** Returns the match list */
    List<Pair<Person>> getMatchList();

    /** Returns an unmodifiable view of the filtered list of favourited persons */
    ObservableList<Person> getFavouritedPersonList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
