package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyRealEstatePro;

/**
 * A class to access RealEstatePro data stored as a json file on the hard disk.
 */
public class JsonRealEstateProStorage implements RealEstateProStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonRealEstateProStorage.class);

    private Path filePath;

    public JsonRealEstateProStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getRealEstateProPath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyRealEstatePro> readRealEstatePro() throws DataConversionException {
        return readRealEstatePro(filePath);
    }

    /**
     * Similar to {@link #readRealEstatePro()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyRealEstatePro> readRealEstatePro(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableRealEstatePro> jsonRealEstatePro = JsonUtil.readJsonFile(
                filePath, JsonSerializableRealEstatePro.class);
        if (!jsonRealEstatePro.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonRealEstatePro.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveRealEstatePro(ReadOnlyRealEstatePro addressBook) throws IOException {
        saveRealEstatePro(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveRealEstatePro(ReadOnlyRealEstatePro)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveRealEstatePro(ReadOnlyRealEstatePro addressBook, Path filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableRealEstatePro(addressBook), filePath);
    }

}
