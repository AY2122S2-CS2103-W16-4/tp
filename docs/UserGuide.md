---
layout: page
title: User Guide
---

RealEstatePro is a desktop app for managing contacts, optimized for real estate agents to manage their client's contacts and sales of HDB properties.
The app also includes various tools which aims to help agents in their work.

# Reference

Original AB3 User Guide: [link](https://se-education.org/addressbook-level3/UserGuide.html)

#Table of contents
- [Quick Start](#quick-start)
- [Features](#features)
- [General Commands](#general-commands)
  - [Open Help Window: `help`](#open-help-window-help)
  - [Listing all clients: `list`](#listing-all-clients--list)
  - [Clearing all entries: `clear`](#clearing-all-entries--clear)
  - [Exiting the program: `exit`](#exiting-the-program--exit)
- [Client Management](#client-management)
  - [Adding a client: `add`](#adding-a-client-add)
  - [Editing a client: `edit`](#editing-a-client-edit)
  - [Deleting a client: `delete`](#deleting-a-client-delete)
  - [Favourite a client: `favourite`](#favourite-a-client-favourite)
  - [Open Favourites window: `fw`](#open-favourites-window-fw)
  - [Locating clients by name: `find`](#locating-clients-by-name-find)
  - [Sorting persons: `sort`](#sorting-persons-sort)
- [Tools](#tools)
  - [Matching properties and preferences: `match`](#matching-properties-and-preferences-match)
  - [Upload and image: `upload`](#upload-an-image--upload)
  - [View image of person: `viewimage`](#view-image-of-person-viewimage)
  - [Setting a reminder for a person: `remind`](#setting-a-reminder-for-a-person-remind)
  - [Open Reminder window: `rm`](#open-reminder-window)
  - [Displaying statistics: `stats`](#displaying-statistics-stats)
- [Future Features](#future-features-coming-soon)
- [Storage](#storage)
  - [Saving the data](#saving-the-data)
  - [Editing the data file](#editing-the-data-file)
- [FAQ](#faq)
- [Command Summary](#command-summary)
- [Keyboard Shortcuts](#keyboard-shortcuts)

## Quick start

1. Ensure you have Java `11` or above installed on your computer.
2. Download the latest `realestatepro.jar` from [here](https://github.com/AY2122S2-CS2103-W16-4/tp/releases).
3. Copy the file to the folder you want to use as the *home folder* for your RealEstatePro.
4. Double-click the file to start the app. The GUI should appear in a few seconds.
5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.
Some example commands you can try:
    - `list` : Lists all client information.
    - `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 pr/north,123 Street,1-room,$300000` : Adds a client named `John Doe` , contact number `98765432`, email `johnd@example.com`, address `street, block 123, #01-01` owns the property `north,123 Street,1-room,$300000`and is a seller in the RealEstatePro app.
    - `delete 3` : Deletes the 3rd client shown in the current list.
    - `clear` : Deletes all client information.
    - `exit` : Exits the app.
6. Refer to the Features below for details of each command.

## Features

Notes about the command format:

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

- Items in square brackets are optional.<br>
  e.g. `n/NAME [pr/PROPERTY]` can be used as `n/John Doe pr/north,123 Street,1-room,$300000` or as `n/John Doe`.

- Items with `…` after them can be used multiple times including zero times.<br>
  e.g. `[p/PHONE_NUMBER]…` can be used as ` ` (i.e. 0 times), `p/12345`, `p/12345 p/54321` etc.

- Inputting information after `pr/` & `p/` indicates the type of property a user is selling or buying.<br>
e.g. `pr/PROPERTY` can be used as `pr/East, Block 123, 2-room, $550000` means this person is a seller looking to sell a 2-room property at Block 123 which is located in the East, with a price of $550000.<br>More information about the required format of properties can be found in the next section.

- client parameters can be in any order.<br>
e.g. if the command specifies `n/NAME p/PHONE_NUMBER pr/PROPERTY`, `p/PHONE_NUMBER pr/PROPERTY n/NAME` is also acceptable.

- If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

- Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
e.g. if the command specifies `help 123`, it will be interpreted as `help`.

Notes about the property format:
- Properties must be specified in the following format: `pr/REGION,ADDRESS,SIZE,PRICE`. Whitespace between parameters is ignored.<br>
  e.g. Both `pr/East,Pasir Ris Drive 1 Block 123,2-room,$550000` and `pr/East, Pasir Ris Drive 1 Block 123, 2-room, $550000` are acceptable. `pr/Pasir Ris Drive 1 Block 123, East, 2-room, $550000` is not acceptable.

Notes about the preference format:
- Preference must be specified in the following format: `pf/REGION,SIZE,LOWPRICE,HIGHPRICE`. Whitespace between parameters is ignored.<br>

Notes about the image format:
- Image must be specified in the following format `i/FILEPATH:DESCRIPTION`. Make sure your file path is from  the directory the jar file is run. Description
is optional and can be omitted.

Parameter formats:
- REGION: One of [`North`, `South`, `East`, `West`, `Central`] (Non case-sensitive).
- ADDRESS: Any non-empty string that does not contain `,`. e.g. `Pasir Ris Drive 1 Block 123`
- SIZE: One of [`1-room`,`2-room`, `3-room`, `4-room`, `5-room`] (Non case-sensitive).
- PRICE: `$` followed by a positive integer. e.g. `$150000`

##General Commands

### Open Help Window: `help`

Opens a new window that displays information on how to use the app and a URL to the user guide of the app.

Format: `help`

#### Navigating the help window

<img src="images/user-guide/helpWindowUi.png" width="600px">

1. Link to the full user guide.
2. Buttons to access the different help sections.
3. Help contents.

### Listing all clients : `list`

Shows a list of all clients in the address book.

Format: `list`

### Clearing all entries : `clear`

Deletes all clients from the address book.

Format: `clear`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
All clients will be deleted! Use with caution.
</div>

### Exiting the program : `exit`

Exits the program.

Format: `exit`

##Client Management

### Adding a client: `add`

Adds a client to RealEstatePro.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [pr/PROPERTY]… [pf/PREFERENCE] [i/FILEPATH:DESCRIPTION]`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
Either a property or preference must be provided when adding a new user and only one of either type can be provided.
</div>
**Tip**: A person is either a `buyer`, or `seller` based on whether he has a property or a preference.

Examples:

- `add n/Betsy Crowe e/betsycrowe@example.com a/Newgate Prison p/1234567 pf/West, 1-room, $100000, $200000 i/living.png:living room`
- `add n/John Doe p/98765432 e/johnd@example.com a/John street block 123 #01-01, pr/East, John street block 123 #01-01, 2-room, $200000`

    ![images/user-guide/addBetsyCroweResult.png](images/user-guide/addJohnDoeResult.png)

### Editing a client: `edit`

Edits an existing client's information in RealEstatePro.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PROPERTY]… [i/FILEPATH:DESCRIPTION]…`

- Edits the client at the specified `INDEX`. The index refers to the index number shown in the displayed client list. The index **must be a positive integer** 1, 2, 3, …
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- Type of the user can be changed from `buyer` to `seller` & vice versa by adding a `Property` or a `Preference` which removes the user's current `Property` or `Preference`.
- You can remove all the person’s properties by typing `pr/` without specifying any properties after it.

Examples:

- `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
- `edit 2 n/Betsy Crower p/1234567 pf/West, 1-room, $100000, $200000` Edits the name of the 2nd person to be `Betsy Crower` and updates the 2nd person to have a `preference` turning the
2nd person into a `buyer`.
- `edit 2 n/Betsy Crower pr/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing properties.
- `edit 2 i/Living.png:living room` Edits 2nd person to only have `Living.png` and removes all other images.


### Deleting a client: `delete`

Deletes the specified client from the address book.

Format: `delete INDEX`

- Deletes the client at the specified `INDEX`.
- The index refers to the index number shown in the displayed client list.
- The index **must be a positive integer** 1, 2, 3, …

Examples:

- `list` followed by `delete 2` deletes the 2nd client in the address book.
- `find Betsy` followed by `delete 1` deletes the 1st client in the results of the `find` command.

**Note**:
- Images associated with the user are not deleted and remains in the OS file system.

### Favourite a client: `favourite`

Favourites the specified client in the RealEstatePro represented by a star as show below. The user (real estate agent) will be able to view a more compact list of favourited clients in a new window called Favourites window.

![images/Favouritestar.png](images/Favouritestar.png)

Format: `favourite INDEX`

- Favourites the client at the specified `INDEX`.
- The index refers to the index number shown in the displayed client list.
- The index **must be a positive integer** 1, 2, 3, …

### Open Favourites window: `fw`

Opens a new window that displays the compacted list of clients that have been favourited.

Format:  `fw`

#### By Ui:

1) Navigate to the `File` menu and click on it.

2) Under it, click on `Favourites`.

3) The system will pop up the Favourites window that displays the compacted list of clients that have been favourited.

### Locating clients by name: `find`

Finds clients whose specified attribute contain any of the given keywords.

Format: `find ATTRIBUTE KEYWORD [MORE_KEYWORDS]`

- `ATTRIBUTE` can be one of: `all` `name` `phone` `email` `address` `properties` `preference` `usertype`.
- If the specified attribute is `all`, search for the keywords in all attributes.
- The search is case-insensitive. e.g `hans` will match `Hans`.
- The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
- Only full words will be matched e.g. `Han` will not match `Hans`.
- clients matching at least one keyword will be returned (i.e. `OR` search). e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

Examples:

- `find name John` returns `john` and `John Doe`
- `find name sam elon` returns `Sam Yeo`, `Elon Musk`

    ![images/user-guide/findSamElonResult.png](images/user-guide/findSamElonResult.png)

### Sorting persons: `sort`

Sorts the list of persons displayed according to one or more keywords.

Format: `sort [!]KEYWORD [[!]MORE_KEYWORDS]…`

- `KEYWORD` can be one of `name` `phone` `email` `address` `favourite` `usertype` `num_property` (case-insensitive).
- Prefixing a keyword with `!` will reverse the sorting order for that keyword.
- If multiple keywords are specified, the list is sorted according to the order in which the keywords are specified, i.e., subsequent keywords are used to break ties after sorting by the previous keyword.

The following table shows the keywords and the default sorting behaviours:

| Keyword        | Default Behaviour                   |
|----------------|-------------------------------------|
| `name`         | Sort by `Name` alphabetically       |
| `phone`        | Sort by `Phone` numerically         |
| `email`        | Sort by `Email` lexicographically   |
| `address`      | Sort by `Address` lexicographically |
| `favourite`    | Show favourites first               |
| `usertype`     | Show buyers first                   |
| `num_property` | Sort by number of `Property`        |

Examples:
- `sort address name phone` will sort the list by `Address` first. If there are entries with equal `Address`, the entries will be sorted by `Name`. If there are entries with equal `Address` and `Name`, they will be sorted by `Phone`.
- `sort !name` will sort the list according to `Name` in reverse alphabetical order, i.e., `Sam Yeo` will be listed before `Elon Musk`.
- `sort favourite !name` will sort the list according to `Favourite`, with favourites being listed first, followed by non-favourites. Within each group, entries are sorted according to `Name` in reverse alphabetical order.

##Tools
### Matching properties and preferences: `match`

Opens a new window and shows all sellers and buyers with matching property and preference.

Format: `match`

### Upload an Image : `upload`

Uploads an image and description to be associated with a client.

Format `upload INDEX [i/FilePath:description]`
- Adds an image to the person at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- File path is from the directory the JAR file is ran from. e.g. `upload 1 i/example.png:living room`
  ![images/user-guide/Upload_Directory_Example.png](images/user-guide/Upload_Directory_Example.png).
- Description is optional and can be left blank e.g. `upload 1 i/example.png`.
- multiple images can be uploaded at once by starting each file with a new flag e.g. `upload 1 i/example.png:living room i/example2.png:Bed Room`.

### View image of person: `viewimage`

View images that are associated with a person in another window.

Format `viewimage INDEX`


### Setting a Reminder for a person: `remind`

Sets a reminder for the specific client from the application. The user (real estate agent) will be able to view a more compact list of clients with reminders set, via a new window called the Reminder window.

Format: `remind INDEX r/ReminderDetails`
- Sets a Reminder for the person at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- The index **must be a postive integer** 1, 2, 3, ...
- The `ReminderDetails` must be a non-empty String, e.g. `arrange home viewing`.

### Open Reminder window: `rm`

Opens a new window that displays compacted list of clients that have Reminders set.

Format: `rm`

#### By Ui:

1) Navigate to the `File` menu and click on it.
2) Under it, click on `Reminders`.
3) The system will launc the `Reminders` window that contains a list of Persons the user has set Reminders for.


### Displaying statistics: `stats`
<img src="images/user-guide/Stats.png" height="400px">

Opens up a new window that shows a pie chart of the number of buyers & sellers with preference or properties respectively in a particular region.

Format: `stats`

## Future Features **[Coming soon]**
1. More types of sizes and increased details such as floor size, landed properties.
2. Display statistics of the number of properties being sold/bought categorized by their room size to provide insight on the most popular number of rooms in a property.
3. Display statistics of the prices of properties sold/bought to provide insight on the average property price sold/bought.
4. Display statistics of lower price and higher price of preferences of clients to provide insight on the average asking price of a property.
5. Allow images to be associated with properties or preferences to allow for better organization

##Storage
### Saving the data

RealEstatePro data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

RealEstatePro data are saved as a JSON file `[JAR file location]/data/realestatepro.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, RealEstatePro will discard all data and start with an empty data file at the next run.
</div>

# FAQ

# Command Summary

| Action            | Format                                                                                                 | Examples                                                                                                                             |
|-------------------|--------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| Add               | add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [pr/PROPERTY]... [pf/PREFERENCE] i/FILEPATH[:DESCRIPTION]… | e.g. add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 pr/2-room, East, SGD$200K, i/living.png:Living room |
| Clear             | clear                                                                                                  | -                                                                                                                                    |
| Delete            | delete INDEX                                                                                           | e.g. delete 3                                                                                                                        |
| Edit              | edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PROPERTY]… [i/FILEPATH[:DESCRIPTION]]…         | e.g. edit 2 n/James Lee e/jameslee@example.com                                                                                       |
| Find              | find ATTRIBUTE KEYWORD [MORE KEYWORDS...]                                                              | e.g. find name James Jake                                                                                                            |
| Sort              | sort [!]KEYWORD [[!]MORE_KEYWORDS]…                                                                    | e.g. sort name !phone email                                                                                                          |
| Remind            | remind INDEX r/reminderDetails                                                                         | e.g. remind 1 r/home viewing                                                                                                         |
| Upload            | upload INDEX i/FilePath[:Description]…                                                                 | e.g. Upload 1 i/livingroom.png:Living room of 4-room flat                                                                            |
| viewimage         | viewimage INDEX                                                                                        | e.g. viewimage 1                                                                                                                     |
| List              | list                                                                                                   | -                                                                                                                                    |
| Help              | help                                                                                                   | -                                                                                                                                    |
| Match             | match                                                                                                  | -                                                                                                                                    |
| Favourite         | favourite INDEX                                                                                        | e.g., favourite 3                                                                                                                    |
| Favourites window | fw                                                                                                     | -                                                                                                                                    |
| Statistics window | stats                                                                                                  | -                                                                                                                                    |
| Reminder window   | rm                                                                                                     | -                                                                                                                                    |

#Keyboard Shortcuts

| Key | Function                |
|-----|-------------------------|
| F1  | Opens Help Window       |
| F2  | Opens stats Window      |
| F3  | Opens favourties Window |
| F4  | Opens reminders Window  |


