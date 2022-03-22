package seedu.address.model.userimage;

import java.io.File;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class FilePath {

    public static final String MESSAGE_CONSTRAINTS = "File not found. Please check your file path";

    public final String value;

    public FilePath(String filePath) {
        requireNonNull(filePath);
        checkArgument(isValidFilePath(filePath), MESSAGE_CONSTRAINTS);
        value = filePath;
    }

    public static boolean isValidFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof FilePath
                && value.equals(((FilePath) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
