package seedu.realestatepro.logic.parser;

import static seedu.realestatepro.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.realestatepro.commons.core.index.Index;
import seedu.realestatepro.logic.commands.FavouriteCommand;
import seedu.realestatepro.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FavouriteCommand object
 */
public class FavouriteCommandParser implements Parser<FavouriteCommand> {

    @Override
    public FavouriteCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new FavouriteCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FavouriteCommand.MESSAGE_USAGE), pe);
        }
    }
}
