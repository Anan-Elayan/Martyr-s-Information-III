# Martyrs Data Structure Project-III

## Project Overview
This project involves implementing a martyrs data structure using a sorted doubly circular linked list, AVL trees, queues, and stacks.
The system will manage martyr records sorted by location, with each location containing two AVL trees.
The first AVL tree stores martyr records sorted by name, and the second AVL tree stores DateStack objects sorted by date.
The system will provide a graphical user interface (GUI) using JavaFX for user interaction.

## Data Input
The data input for this project will be a martyrs CSV file (btselem.csv attached).

## Main Features
1. Location Management (Tab 1)
 - Option to insert a new location record.
 - Option to update or delete an existing location record.
 - Option to search for a location record and load the martyrs' records in that location.

2. Martyrs Management (Tab 2)
- After selecting a location, the user can:
   - Insert a new martyr record (create one martyr record and add its pointer to AVL1 and AVL2).
   - Update or delete a martyr record.
   - Search for martyrs by part of the name.

3. Statistics (Tab 3)
- For the selected location from the location screen:
   - Generate a summary report that includes:
        - The number of martyrs in the selected location.
        - Traverse the first AVL level-by-level and print the martyr’s full information.
        - The height of the first AVL tree.
        - Traverse the second AVL backward and print the martyr’s full information.
        -  Report the date that had the maximum number of martyrs.
        - The height of the second AVL tree.
- Navigation buttons to move through locations.

4. Save Data (Tab 4)
- Save the updated data structures back to a file in the same format (Name, Age, Event location – District, Date of death, Gender) separated by commas.
- Use a file chooser to select the folder to save the file in.























