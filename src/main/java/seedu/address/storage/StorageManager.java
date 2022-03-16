package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyRealEstatePro;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private RealEstateProStorage realEstateProStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(RealEstateProStorage realEstateProStorage, UserPrefsStorage userPrefsStorage) {
        this.realEstateProStorage = realEstateProStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getRealEstateProPath() {
        return realEstateProStorage.getRealEstateProPath();
    }

    @Override
    public Optional<ReadOnlyRealEstatePro> readRealEstatePro() throws DataConversionException, IOException {
        return readRealEstatePro(realEstateProStorage.getRealEstateProPath());
    }

    @Override
    public Optional<ReadOnlyRealEstatePro> readRealEstatePro(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return realEstateProStorage.readRealEstatePro(filePath);
    }

    @Override
    public void saveRealEstatePro(ReadOnlyRealEstatePro addressBook) throws IOException {
        saveRealEstatePro(addressBook, realEstateProStorage.getRealEstateProPath());
    }

    @Override
    public void saveRealEstatePro(ReadOnlyRealEstatePro addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        realEstateProStorage.saveRealEstatePro(addressBook, filePath);
    }

}
