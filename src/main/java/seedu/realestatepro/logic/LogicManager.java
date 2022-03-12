package seedu.realestatepro.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.realestatepro.commons.core.GuiSettings;
import seedu.realestatepro.commons.core.LogsCenter;
import seedu.realestatepro.commons.core.Pair;
import seedu.realestatepro.logic.commands.Command;
import seedu.realestatepro.logic.commands.CommandResult;
import seedu.realestatepro.logic.commands.exceptions.CommandException;
import seedu.realestatepro.logic.parser.AddressBookParser;
import seedu.realestatepro.logic.parser.exceptions.ParseException;
import seedu.realestatepro.model.Model;
import seedu.realestatepro.model.ReadOnlyAddressBook;
import seedu.realestatepro.model.person.Person;
import seedu.realestatepro.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AddressBookParser addressBookParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        addressBookParser = new AddressBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = addressBookParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveAddressBook(model.getAddressBook());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return model.getAddressBook();
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    /**
     * Iterate through the list of Persons and only add those that are favourited into
     * favouritedList to be returned.
     */
    @Override
    public ObservableList<Person> getFavouritedPersonList() {
        ObservableList<Person> favouritedList = FXCollections.observableArrayList();
        for (Person person : getFilteredPersonList()) {
            if (person.getFavourite().getStatus()) {
                favouritedList.add(person);
            }
        }
        return favouritedList;
    }

    @Override
    public List<Pair<Person>> getMatchList() {
        model.updateMatchList();
        return model.getMatchList();
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
