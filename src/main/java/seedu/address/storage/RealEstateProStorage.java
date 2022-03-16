package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyRealEstatePro;
import seedu.address.model.RealEstatePro;

/**
 * Represents a storage for {@link RealEstatePro}.
 */
public interface RealEstateProStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getRealEstateProPath();

    /**
     * Returns RealEstatePro data as a {@link ReadOnlyRealEstatePro}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyRealEstatePro> readRealEstatePro() throws DataConversionException, IOException;

    /**
     * @see #getRealEstateProPath()
     */
    Optional<ReadOnlyRealEstatePro> readRealEstatePro(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyRealEstatePro} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveRealEstatePro(ReadOnlyRealEstatePro addressBook) throws IOException;

    /**
     * @see #saveRealEstatePro(ReadOnlyRealEstatePro)
     */
    void saveRealEstatePro(ReadOnlyRealEstatePro addressBook, Path filePath) throws IOException;

}
