// G27_TP065118_TP064210_TP068065.cpp : This file contains the 'main' function. Program execution begins and ends there.
//


#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>
#include <fstream>
#include <chrono>
#include <vector>
using namespace std;


int seletion() {
    int sel = 0;
    cout << "What would you like to sort the data based on?\n1.Grams\n2.Calories\n3.Protein\n4.Fat\n5.Sat.Fat\n6.Fiber\n7.Carbs\n";
    
    while (sel < 1 || sel >7) {
        cout << "(Please select based on the number stated above) : \n";
        cin >> sel;
        if (sel < 1 || sel >7) {
            cout << "Please select a proper number (1-7)\n";
        }
    }
    sel = sel + 1;
    return sel;
}

bool ascend_descend() {
    bool ascend = true;
    int sel = 0;
    cout << "You wish to sort ascending or descending?\n1.Ascending\n2.Descending\n";

    while (sel < 1 || sel >2) {
        cout << "(Please select based on the number stated above) : \n";
        cin >> sel;
        if (sel < 1 || sel >7) {
            cout << "Please select a proper number (1 or 2)\n";
        }
    }
    if (sel == 1) {
        ascend = true;
    }
    else {
        ascend = false;
    }

    return ascend;
}

//Insertion Sorting algorith--------------------------------------------------------
void insertionSort2DString(string arr[][10], int rows, int cols,int sort_based, bool ascend) {
    for (int i = 1; i < rows; i++) {
        string keyRow[10];  // Declare keyRow without initialization
        for (int k = 0; k < cols; k++) {  // Copy elements from arr[i]
            keyRow[k] = arr[i][k];
        }

        int j = i - 1;

        if (ascend == true) {
            // Move rows with larger third elements up
            while (j >= 0 && stod(arr[j][sort_based]) > stod(keyRow[sort_based])) {
                // Copy elements individually instead of direct assignment
                for (int k = 0; k < cols; k++) {
                    arr[j + 1][k] = arr[j][k];
                }
                j--;
            }
        }
        else {
            // Move rows with larger third elements up
            while (j >= 0 && stod(arr[j][sort_based]) < stod(keyRow[sort_based])) {
                // Copy elements individually instead of direct assignment
                for (int k = 0; k < cols; k++) {
                    arr[j + 1][k] = arr[j][k];
                }
                j--;
            }
        }

        // Copy elements from keyRow to arr[j + 1]
        for (int k = 0; k < cols; k++) {
            arr[j + 1][k] = keyRow[k];
        }
    }
}
//Insertion Sorting algorithm--------------------------------------------------------

//Buuble Sorting algorithm-----------------------------------------------------------
void bubbleSort2DString(string arr[][10], int rows, int cols, int sort_based, bool ascend) {
    for (int i = 0; i < rows - 1; i++) {
        for (int j = 0; j < rows - i - 1; j++) {

            if (ascend == true) {
                if (stod(arr[j][sort_based]) > stod(arr[j + 1][sort_based])) {
                    // Swap rows manually using a temporary array
                    string temp[10];
                    for (int k = 0; k < cols; k++) {
                        temp[k] = arr[j][k];
                        arr[j][k] = arr[j + 1][k];
                        arr[j + 1][k] = temp[k];
                    }
                }
            }
            else {
                if (stod(arr[j][sort_based]) < stod(arr[j + 1][sort_based])) {
                    // Swap rows manually using a temporary array
                    string temp[10];
                    for (int k = 0; k < cols; k++) {
                        temp[k] = arr[j][k];
                        arr[j][k] = arr[j + 1][k];
                        arr[j + 1][k] = temp[k];
                    }
                }
            }
        }
    }
}
//Buuble Sorting algorithm-----------------------------------------------------------

//Heap Sorting algorithm-----------------------------------------------------------
void heapify2DString(string arr[][10], int N, int i, int cols, int sort_based,bool ascend) {
    int largest = i;  // Initialize largest as root
    int l = 2 * i + 1;  // left = 2*i + 1
    int r = 2 * i + 2;  // right = 2*i + 2

    if (ascend == true) {
        // Compare based on the third element (numerical string)
        if (l < N && stod(arr[l][sort_based]) > stod(arr[largest][sort_based]))
            largest = l;

        if (r < N && stod(arr[r][sort_based]) > stod(arr[largest][sort_based]))
            largest = r;
    }
    else {
        // Compare based on the third element (numerical string)
        if (l < N && stod(arr[l][sort_based]) < stod(arr[largest][sort_based]))
            largest = l;

        if (r < N && stod(arr[r][sort_based]) < stod(arr[largest][sort_based]))
            largest = r;
    }

    if (largest != i) {
        // Swap entire rows using a temporary array
        string temp[10];
        for (int k = 0; k < cols; k++) {
            temp[k] = arr[i][k];
            arr[i][k] = arr[largest][k];
            arr[largest][k] = temp[k];
        }

        heapify2DString(arr, N, largest, cols,sort_based,ascend);
    }
}

void heapSort2DString(string arr[][10], int rows, int cols, int sort_based,bool ascend) {
    for (int i = rows / 2 - 1; i >= 0; i--)
        heapify2DString(arr, rows, i, cols, sort_based, ascend);

    for (int i = rows - 1; i > 0; i--) {
        // Swap rows
        string temp[10];
        for (int k = 0; k < cols; k++) {
            temp[k] = arr[0][k];
            arr[0][k] = arr[i][k];
            arr[i][k] = temp[k];
        }

        heapify2DString(arr, i, 0, cols, sort_based, ascend);
    }
}
//Heap Sorting algorithm-----------------------------------------------------------


//Function to clean the data inside CSV file
string join(const vector<string>& strings, const string& delimiter) {
    string joinedString;
    for (size_t i = 0; i < strings.size(); ++i) {
        if (i > 0) {
            joinedString += delimiter;
        }
        joinedString += strings[i];
    }
    return joinedString;
}

string cleanCell(const string& cell) {
    if (cell.find_first_not_of("0123456789.") != string::npos || cell.empty()) {
        return "0";
    }
    else {
        return cell;
    }
}

void cleanCSVData(const string& inputFile, const string& outputFile) {
    ifstream infile(inputFile);
    ofstream outfile(outputFile);

    string line;
    bool headerRead = false;  // Flag to indicate if header has been read

    while (getline(infile, line)) {
        if (!headerRead) {
            // Write header directly without cleaning
            outfile << line << endl;
            headerRead = true;  // Set flag to true after processing header
        }
        else {
            stringstream ss(line);
            string cell;
            vector<string> cells;

            int columnIndex = 0;
            while (getline(ss, cell, ',')) {
                if (columnIndex >= 2 && columnIndex <= 8) {
                    cell = cleanCell(cell);
                }
                cells.push_back(cell);
                columnIndex++;
            }

            string cleanedLine = join(cells, ",");
            outfile << cleanedLine << endl;
        }
    }
}

int main()
{
    cleanCSVData("Nutrients_Info 1.csv", "cleaned_Nutrients_Info 1.csv");

    //read the excel file into array-------------------------------------------------------
    string file_path = "cleaned_Nutrients_Info 1.csv";
    ifstream nutrient;
    nutrient.open(file_path);

    if (nutrient.fail()) {
        cout << "Unable to open the file, please try again!";
    }
    string line;
    string nutrient_data[336][10];  // 336 rows and 10 columns
    int row = 0;

    while (getline(nutrient, line) && row < 336) {
        stringstream ss(line);
        string cell;
        int col = 0;

        while (getline(ss, cell,',') && col < 10) {
            nutrient_data[row][col] = cell;
            col += 1;
        }
        row += 1;
    }
    //done reading the data into nutrient_data array----------------------------------------
    // 
    //To print Unsorted data:
    cout << "Unsoreted data: " << "\n";
    for (int i = 0; i < 336; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                cout << setw(40) << left << nutrient_data[i][j];
            }
            else if (j == 9) {
                cout << nutrient_data[i][j];
            }
            else {
                cout << setw(10) << left << nutrient_data[i][j];
            }
        }
        cout << endl;
    }
    //Done printing unsorted data-------------------------------------------------------------

    //Ask user what to sort and ascending or desceding
    int based = seletion();
    bool ac_ds = ascend_descend();

    //The part below start doing the sorting algorithm, above is just read the data from excel file and print it out
    //remove header
    string insert_unsort[335][10];
    for (int i = 1;i < 336;i++) {
        for (int k = 0;k < 10;k++) {
            insert_unsort[i - 1][k] = nutrient_data[i][k];
        }
        
    }

    //Insertion Sorting Algorithm-------------------------------------------------------------

    cout << "\n\n-------------------------------------------------------------------------------";
    cout << "\nInsertion Sorting Algorithm:";
    auto insert_start = chrono::high_resolution_clock::now();
    insertionSort2DString(insert_unsort, 335, 10,based, ac_ds);
    auto insert_end = chrono::high_resolution_clock::now();

    auto insert_duration = chrono::duration_cast <chrono::milliseconds>(insert_end - insert_start);
    cout << "\n\nTime taken for the insertion sorting algorithm: " << insert_duration.count() << " milliseconds" << endl;
       //to print insertion sorted data
    cout << "Insertion soreted data: " << "\n";
    for (int i = 0; i < 335; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                cout << setw(40) << left << insert_unsort[i][j];
            }
            else if (j == 9) {
                cout << insert_unsort[i][j];
            }
            else {
                cout << setw(10) << left << insert_unsort[i][j];
            }
        }
        cout << endl;
    } 
    cout << "\n-------------------------------------------------------------------------------";

    //Insertion Sorting Algorithm-------------------------------------------------------------

    //remove header
    string bubble_unsort[335][10];
    for (int i = 1;i < 336;i++) {
        for (int k = 0;k < 10;k++) {
            bubble_unsort[i - 1][k] = nutrient_data[i][k];
        }

    }

    //Bubble sorting algorithm+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    cout << "\n\n-------------------------------------------------------------------------------";
    cout << "\nBubble Sorting Algorithm:";
    auto bubble_start = chrono::high_resolution_clock::now();
    bubbleSort2DString(bubble_unsort, 335, 10, based,ac_ds);
    auto bubble_end = chrono::high_resolution_clock::now();

    auto bubble_duration = chrono::duration_cast <chrono::milliseconds>(bubble_end - bubble_start);
    cout << "\n\nTime taken for the bubble sorting algorithm: " << bubble_duration.count() << " milliseconds" << endl;
     //to print bubble sorted data
    cout << "Bubble soreted data: " << "\n";
    for (int i = 0; i < 335; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                cout << setw(40) << left << bubble_unsort[i][j];
            }
            else if (j == 9) {
                cout << bubble_unsort[i][j];
            }
            else {
                cout << setw(10) << left << bubble_unsort[i][j];
            }
        }
        cout << endl;
    }
    cout << "\n-------------------------------------------------------------------------------";

    //Bubble sorting algorithm+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //remove header
    string heap_unsort[335][10];
    for (int i = 1;i < 336;i++) {
        for (int k = 0;k < 10;k++) {
            heap_unsort[i - 1][k] = nutrient_data[i][k];
        }

    }

    //Heap sorting algorithm--------------------------------------------------------------------

    cout << "\n\n-------------------------------------------------------------------------------";
    cout << "\nHeap Sorting Algorithm:";
    auto heap_start = chrono::high_resolution_clock::now();
    heapSort2DString(heap_unsort, 335, 10, based,ac_ds);
    auto heap_end = chrono::high_resolution_clock::now();

    auto heap_duration = chrono::duration_cast <chrono::milliseconds>(heap_end - heap_start);
    cout << "\n\nTime taken for the bubble sorting algorithm: " << heap_duration.count() << " milliseconds" << endl;
      //to print heap sorted data
    cout << "Heap soreted data: " << "\n";
    for (int i = 0; i < 335; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                cout << setw(40) << left << heap_unsort[i][j];
            }
            else if (j == 9) {
                cout << heap_unsort[i][j];
            }
            else {
                cout << setw(10) << left << heap_unsort[i][j];
            }
        }
        cout << endl;
    }
    cout << "\n-------------------------------------------------------------------------------";

    //Heap sorting algorithm--------------------------------------------------------------------
}
