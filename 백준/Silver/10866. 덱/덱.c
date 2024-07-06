#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
} Node;

typedef struct {
    Node *front;
    Node *rear;
    int size;
} Deque;

Node* create_node(int data) {
    Node *new_node = (Node *)malloc(sizeof(Node));
    if (!new_node) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    new_node->data = data;
    new_node->prev = NULL;
    new_node->next = NULL;
    return new_node;
}

void push_front(Deque *deque, int data){
    Node *new_node = create_node(data);
    if (deque->size == 0) {
        deque->front = new_node;
        deque->rear = new_node;
    } else {
        new_node->next = deque->front;
        deque->front->prev = new_node;
        deque->front = new_node;
    }
    deque->size++;
}

void push_back(Deque *deque, int data){
    Node *new_node = create_node(data);
    if (deque->size == 0) {
        deque->front = new_node;
        deque->rear = new_node;
    } else {
        new_node->prev = deque->rear;
        deque->rear->next = new_node;
        deque->rear = new_node;
    }
    deque->size++;
}

int empty(Deque *deque) {
    return deque->size == 0;
}

int pop_front(Deque *deque){
    if (empty(deque)) {
        return -1;
    }
    Node *temp = deque->front;
    int data = temp->data;
    deque->front = deque->front->next;
    if (deque->front != NULL) {
        deque->front->prev = NULL;
    } else {
        deque->rear = NULL;
    }
    free(temp);
    deque->size--;
    return data;
}

int pop_back(Deque *deque){
    if (empty(deque)) {
        return -1;
    }
    Node *temp = deque->rear;
    int data = temp->data;
    deque->rear = deque->rear->prev;
    if (deque->rear != NULL) {
        deque->rear->next = NULL;
    } else {
        deque->front = NULL;
    }
    free(temp);
    deque->size--;
    return data;
}

int size(Deque *deque) {
    return deque->size;
}

int front(Deque *deque) {
    if (empty(deque)) {
        return -1;
    }
    return deque->front->data;
}

int back(Deque *deque) {
    if (empty(deque)) {
        return -1;
    }
    return deque->rear->data;
}

// 초기화 함수
void init(Deque *deque) {
    deque->front = NULL;
    deque->rear = NULL;
    deque->size = 0;
}

int main(){
    Deque deque;
    init(&deque);

    int n, data;
    char command[20];

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%s", command);

        if (strcmp(command, "push_front") == 0) {
            scanf("%d", &data);
            push_front(&deque, data);
        } else if (strcmp(command, "push_back") == 0) {
            scanf("%d", &data);
            push_back(&deque, data);
        } else if (strcmp(command, "pop_front") == 0) {
            printf("%d\n", pop_front(&deque));
        } else if (strcmp(command, "pop_back") == 0) {
            printf("%d\n", pop_back(&deque));
        } else if (strcmp(command, "empty") == 0) {
            printf("%d\n", empty(&deque));
        } else if (strcmp(command, "size") == 0) {
            printf("%d\n", size(&deque));
        } else if (strcmp(command, "front") == 0) {
            printf("%d\n", front(&deque));
        } else if (strcmp(command, "back") == 0) {
            printf("%d\n", back(&deque));
        } else {
            fprintf(stderr, "Unknown command: %s\n", command);
        }
    }
    return 0;
}
