//here's a simple C program that demonstrates the use of a doubly linked list to perform basic operations such as inserting, deleting, and displaying elements in the list:

#include <stdio.h>
#include <stdlib.h>

// Define the structure for a node in the doubly linked list
struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;
    return newNode;
}

// Function to insert a node at the end of the list
void insertEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
    } else {
        struct Node* current = *head;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newNode;
        newNode->prev = current;
    }
}

// Function to delete a node with a given value from the list
void deleteNode(struct Node** head, int key) {
    if (*head == NULL) {
        printf("List is empty. Cannot delete.\n");
        return;
    }

    struct Node* current = *head;

    while (current != NULL) {
        if (current->data == key) {
            if (current->prev != NULL) {
                current->prev->next = current->next;
            } else {
                *head = current->next;
            }
            if (current->next != NULL) {
                current->next->prev = current->prev;
            }
            free(current);
            printf("Deleted %d from the list.\n", key);
            return;
        }
        current = current->next;
    }

    printf("%d not found in the list. Cannot delete.\n", key);
}

// Function to display the elements of the list
void display(struct Node* head) {
    printf("Doubly Linked List: ");
    while (head != NULL) {
        printf("%d <-> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

int main() {
    struct Node* head = NULL;

    insertEnd(&head, 1);
    insertEnd(&head, 2);
    insertEnd(&head, 3);
    insertEnd(&head, 4);
    insertEnd(&head, 5);

    display(head);

    deleteNode(&head, 3); // Delete node with value 3
    display(head);

    deleteNode(&head, 1); // Delete first node
    display(head);

    deleteNode(&head, 5); // Delete last node
    display(head);

    return 0;
}
//This program defines a doubly linked list and provides functions for inserting nodes at the end, deleting nodes by value, and displaying the contents of the list. It demonstrates how to create and manipulate a doubly linked list in C.