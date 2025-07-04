

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

// Structure to represent a node in the queue
struct Order {
    // Data members for the node
    int order_code; // You can change this data type based on your needs
    string packed_date;
    string deliver_date;
    int review;
    Order* next;

    // Constructor to create a new node with given data
    Order(int val, string p_date, string d_date, int re) {
        order_code = val;
        packed_date = p_date;
        deliver_date = d_date;
        review = re;
        next = NULL;
    }
};

// Queue class using linked list
class QueueLinkedList {
    Order* front; // Pointer to the front of the queue
    Order* rear; // Pointer to the rear of the queue
    
private:    
    int order_count = 1;

public:
    // Constructor to initialize an empty queue
    QueueLinkedList() {
        front = NULL;
        rear = NULL;
    }

    // Function to check if the queue is empty
    bool isEmpty() {
        return (front == NULL);
    }

    // Function to add an element to the rear of the queue (enqueue)
    void enqueue(int val, string p_date, string d_date, int re) {
        Order* newNode = new Order(val,p_date,d_date,re);

        // If the queue is empty, set both front and rear to the new node
        if (isEmpty()) {
            front = rear = newNode;
        }
        else {
            // Add the new node to the rear and update rear to the new node
            rear->next = newNode;
            rear = newNode;
        }
    }

    // Function to remove an element from the front of the queue (dequeue)
    void dequeue() {
        // If the queue is empty, print a message and return
        if (isEmpty()) {
            cout << "\nQueue is empty. Nothing to dequeue." << endl;
            return;
        }

        // Store the front node in a temporary variable
        Order* temp = front;

        // Move front to the next node
        front = front->next;

        // If front becomes NULL, the queue is now empty, so update rear to NULL as well
        if (front == NULL)
            rear = NULL;

        // Delete the front node
        delete temp;
    }

    // Function to get the front element of the queue
    Order* getFront() {
        // If the queue is empty, return -1 (or any other default value based on your needs)
        if (isEmpty()) {
            cout << "\nQueue is empty. No front element." << endl;
        }

        // Return the data of the front node
        return front;
    }

    // Function to display the contents of the queue
    void display() {
        // If the queue is empty, print a message and return
        if (isEmpty()) {
            cout << "\nQueue is empty." << endl;
            return;
        }

        // Display the contents of the queue
        cout << "\nQueue contents: \n\n";
        cout << setw(20) << left << "Order Code" << setw(20) << left << "Packed Date"
            << setw(20) << left << "Deliver Date" << setw(20) << left << "Review" << "\n";

        Order* temp = front;

        while (temp != NULL) {
            cout << setw(20) << left << temp->order_code << setw(20) << left << temp->packed_date
                << setw(20) << left << temp->deliver_date << setw(20) << left << temp->review << "\n";

            temp = temp->next;
        }
        cout << endl;
    }

    int get_order_count(){
        return order_count;
    }

    void set_order_count(int o) {
        order_count = o;
    }
};

QueueLinkedList user_order(QueueLinkedList order_queue) {
    bool order = true;
    double const price_per_kg = 0.5;
    double weight = 0;
    int selection;

    while (order) {
        cout << "\nOrder Code: " << order_queue.get_order_count() << endl;
        cout << "Weight of item: " << weight << endl;
        cout << "Total fee: " << weight * price_per_kg << endl;

        if (weight == 0) {
            cout << "\n Please enter the total weight of your item (in kg): " << endl;
            cin >> weight;
            continue;
        }

        cout << "\nAre you confirm to place this order?\n1. Yes\n2. No\n" << endl;
        cin >> selection;

        if (selection == 1) {
            order_queue.enqueue(order_queue.get_order_count(), "", "", -1);
            order_queue.set_order_count(order_queue.get_order_count() + 1);
            order = false;
            break;
        }
        else if (selection == 2) {
            order = false;
            break;
        }
        else {
            cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
            continue;
        }
    }

    return order_queue;

}

bool check_string_number(string s) {
    for (int i = 0; i < s.length();i++) {
        if (!isdigit(s[i])) {
            return false;
        }
    }

    return true;
}

QueueLinkedList* user_review(QueueLinkedList order_queue, QueueLinkedList deliver_queue, QueueLinkedList complete_queue) {
    bool review_order = true;
    QueueLinkedList* three_queue = new QueueLinkedList[3];

    while (review_order) {
        deliver_queue.display();

        cout << "Do you wish to review the first order being delivered?" << "\n1. Yes\n2. No\n";
        string user_selection_order;
        cin >> user_selection_order;
        if (user_selection_order == "1") {

            if (deliver_queue.isEmpty()) {
                cout << "\nSorry, there is no any new order.\nPlease try again!\n" << endl;
                continue;
            }
            else {


                bool r_order = true;
                Order* temp = deliver_queue.getFront();
                int o_code = temp->order_code;
                string p_date = temp->packed_date;
                string d_date = temp->deliver_date;
                int rev = temp->review;
                int selection;

                while (r_order) {

                    cout << "\nOrder Code: " << o_code << endl;
                    cout << "Packed_date: " << p_date << endl;
                    cout << "Delovery Date: " << d_date << endl;
                    cout << "Review: " << rev << endl;

                    if (rev == -1) {
                        string temp_review;
                        cout << "\n Please rate our service for this order from 1 to 10: " << endl;
                        cin >> temp_review;

                        if (check_string_number(temp_review)) {

                            rev = stoi(temp_review);
                            if (rev < 1 || rev > 10) {
                                cout << "Sorry, we only accept numeric input from 1 to 19, please try again!";
                                rev = -1;
                            }
                        }
                        else {
                            cout << "Sorry, we only accept numeric input from 1 to 19, please try again!";
                            rev = -1;
                        }
                        continue;
                    }

                    cout << "\nAre you confirm to make this review?\n1. Yes\n2. No\n" << endl;
                    cin >> selection;

                    if (selection == 1) {
                        deliver_queue.dequeue();
                        complete_queue.enqueue(o_code, p_date, d_date, rev);
                        r_order = false;
                        break;
                    }
                    else if (selection == 2) {
                        r_order = false;
                        break;
                    }
                    else {
                        cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
                        continue;
                    }

                }
            }

        }
        else if (user_selection_order == "2") {
            review_order = false;
            break;
        }
        else {
            cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
            continue;
        }
    }

    three_queue[0] = order_queue;
    three_queue[1] = deliver_queue;
    three_queue[2] = complete_queue;

    return three_queue;
}

QueueLinkedList* user_interface(QueueLinkedList order_queue, QueueLinkedList deliver_queue, QueueLinkedList complete_queue) {
    bool user = true;
    QueueLinkedList* three_queue = new QueueLinkedList[3];
    three_queue[0] = order_queue;
    three_queue[1] = deliver_queue;
    three_queue[2] = complete_queue;
    while (user) {

        cout << "\n----------User----------\n";
        cout << "\n1. Order\n2. View Order\n3. Review Order\n4. View Complete/Reviewed Order\n0. Back\n";
        string user_selection;
        cout << "\nAs user, you can order our courier service here. \nAnd after the order has been delivered, kindly to rate our service from 1 to 10\nPlease select your choice:\n";
        cin >> user_selection;

        if (user_selection == "1") {
            order_queue = user_order(order_queue);
            three_queue[0] = order_queue;
            continue;
        }
        else if (user_selection == "2") {
            order_queue.display();
            continue;
        }
        else if (user_selection == "3") {
            three_queue = user_review(order_queue, deliver_queue, complete_queue);
            continue;
        }
        else if (user_selection == "4") {
            complete_queue = three_queue[2];
            complete_queue.display();
            continue;
        }
        else if (user_selection == "0") {
            user = false;
            break;
        }
        else {
            cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
            continue;
        }
    }

    return three_queue;
}

QueueLinkedList* admin_process_order(QueueLinkedList order_queue, QueueLinkedList deliver_queue) {
    
    bool process_order = true;
    QueueLinkedList* two_queue = new QueueLinkedList[2];

    while (process_order) {
        order_queue.display();

        cout << "Do you wish to process the order being placed by the earlist?" << "\n1. Yes\n2. No\n";
        string admin_selection_order;
        cin >> admin_selection_order;
        if (admin_selection_order == "1") {

            if (order_queue.isEmpty()) {
                cout << "\nSorry, there is no any new order.\nPlease try again!\n" << endl;
                continue;
            }
            else {


                bool p_order = true;
                Order* temp = order_queue.getFront();
                int o_code = temp->order_code;
                string p_date = temp->packed_date;
                string d_date = temp->deliver_date;
                int rev = temp->review;
                int selection;

                while (p_order) {

                    cout << "\nOrder Code: " << o_code << endl;
                    cout << "Packed_date: " << p_date << endl;
                    cout << "Delovery Date: " << d_date << endl;
                    cout << "Review: " << rev << endl;

                    if (p_date == "" || d_date == "") {
                        cout << "\n Please enter the packing date: " << endl;
                        cin >> p_date;
                        cout << "\nPlease enter the delivery date: " << endl;
                        cin >> d_date;
                        continue;
                    }

                    cout << "\nAre you confirm to proceed this order?\n1. Yes\n2. No\n" << endl;
                    cin >> selection;

                    if (selection == 1) {
                        order_queue.dequeue();
                        deliver_queue.enqueue(o_code, p_date, d_date, rev);
                        p_order = false;
                        break;
                    }
                    else if (selection == 2) {
                        p_order = false;
                        break;
                    }
                    else {
                        cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
                        continue;
                    }

                }
            }

        }
        else if (admin_selection_order == "2") {
            process_order = false;
            break;
        }
        else {
            cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
            continue;
        }
    }

    two_queue[0] = order_queue;
    two_queue[1] = deliver_queue;

    return two_queue;
}

QueueLinkedList* admin_interface(QueueLinkedList order_queue, QueueLinkedList deliver_queue, QueueLinkedList complete_queue) {

    bool admin = true;
    QueueLinkedList* two_queue = new QueueLinkedList[2];
    while (admin) {

        cout << "\n----------Admin----------\n";
        cout << "\n1. Process New Order\n2. View Processed Order\n3. View Complete/Reviewed Order\n0. Back";
        string admin_selection;
        cout << "\n\nAs admin, you can process the order here (Packing and Delivering). \nAnd after receveied review from customer, you also can check here\nPlease select your choice:\n";
        cin >> admin_selection;

        if (admin_selection == "1") {
            two_queue = admin_process_order(order_queue, deliver_queue);
            continue;
        }
        else if (admin_selection == "2") {
            deliver_queue = two_queue[1];
            deliver_queue.display();
            continue;
        }
        else if (admin_selection == "3") {
            complete_queue.display();
            continue;
        }
        else if (admin_selection == "0") {
            admin = false;
            break;
        }
        else {
            cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
            continue;
        }

    }
    return two_queue;
}


int main()
{
    bool main_menu = true;
    int order_count = 0;
    QueueLinkedList order_of_item;
    QueueLinkedList deliver_order_of_item;
    QueueLinkedList complete_order_of_item;

    while (main_menu) {
        cout << "\nWelcome to G27 Courier System!\n\n1. User\n2. Admin\n0. Exit\n" << endl;
        cout << "Please select your role:\n";

        string role_selection;
        cin >> role_selection;

        if (role_selection == "1") {
            QueueLinkedList* three_queue;
            three_queue = user_interface(order_of_item, deliver_order_of_item, complete_order_of_item);
            order_of_item = three_queue[0];
            deliver_order_of_item = three_queue[1];
            complete_order_of_item = three_queue[2];
            continue;
        }
        else if (role_selection == "2") {
            QueueLinkedList *two_queue;
            two_queue = admin_interface(order_of_item, deliver_order_of_item, complete_order_of_item);
            order_of_item = two_queue[0];
            deliver_order_of_item = two_queue[1];
            continue;
        }
        else if (role_selection == "0") {
            main_menu = false;
            cout << "\nThanks for your time. Hope to see you again." << endl;
            break;
        }
        else {
            cout << "\nSorry, we don't understand your request.\nPlease try again!\n" << endl;
            continue;
        }
    }


    cout << "Hello World!";
}