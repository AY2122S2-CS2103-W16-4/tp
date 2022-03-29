package seedu.address.model.userimage;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

/**
 * Creates a UserImage object that contains an image file with description
 */
public class UserImage {

    public static final String MESSAGE_CONSTRAINTS =
                "Image must be of the format: [File Path:Description(optional)]";

    private final String description;
    private final FilePath filePath;
    private final File image;

    /**
     * @param filePath filePath to an existing file
     * @param description description to be attached to image
     */
    public UserImage(FilePath filePath, String description) {
        requireAllNonNull(filePath, description);
        this.filePath = filePath;
        this.description = description;
        this.image = new File(filePath.value);
    }

    public String getDescription() {
        return description;
    }


    public FilePath getFilePath() {
        return filePath;
    }

    public File getImage() {
        return image;
    }

    /**
     * Checks to ensure that file in filepath is an image file
     */
    public boolean isImage() {
        try {
            return ImageIO.read(image) != null;
        } catch (IOException E) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserImage)) {
            return false;
        }
        UserImage otherUserImage = (UserImage) other;
        return otherUserImage.getFilePath().equals(filePath)
            && otherUserImage.getDescription().equals(description);

    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath, description);
    }
}
