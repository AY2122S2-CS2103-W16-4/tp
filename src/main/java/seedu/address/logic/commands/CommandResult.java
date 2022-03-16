package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** Match information should be shown to the user. */
    private final boolean showMatch;

    /** The application should exit. */
    private final boolean exit;

    /** Favourites information should be shown to the user. */
    private final boolean showFavourites;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean showMatch, boolean exit, boolean showFavourites) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.showMatch = showMatch;
        this.exit = exit;
        this.showFavourites = showFavourites;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isShowMatch() {
        return showMatch;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isShowFavourites() {
        return showFavourites;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit
                && showFavourites == otherCommandResult.isShowFavourites();
                && showMatch == otherCommandResult.showMatch
                && exit == otherCommandResult.exit;
                && showFavourites == otherCommandResult.isShowFavourites();
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, showMatch, exit, showFavourites);
    }

    @Override
    public String toString() {
        return ("Feedback to user: " + feedbackToUser + "\n"
                + "Show help: " + showHelp + "\n"
                + "Exit: " + exit + "\n");
    }

}
