#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

#define SIZE 10003
    
typedef struct {
    int arr[SIZE];
    int front, rear;
} Q;


void init(Q *q) {
    q->front = 0;
    q->rear = 0;
}

int empty(Q *q) {
      return q->front == q->rear;
}
int back(Q *q) {
     if(empty(q)){
        return -1;
    }
    return q->arr[q->rear];
  }
 
int size(Q *q) {
    return (q->rear - q->front + SIZE) % SIZE;
}

int front(Q *q) {
    if(empty(q)){
        return -1;
    }
    return q->arr[q->front+1];
}

void push(Q *q, int data) {
    q->rear = (q->rear + 1) % SIZE;
    q->arr[q->rear] = data;
}


int isFull(Q *q){
      return q->front == q->rear % SIZE;
}


int pop(Q *q) {
    if (empty(q)) {
        return -1;
    }
    q->front = (q->front + 1) % SIZE;
    return q->arr[q->front];
}


int main() {
      Q q;
      init(&q);
    
    int n, data;
    char command[6];

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%s", command);

        if (strcmp(command, "push") == 0) {
            scanf("%d", &data);
            push(&q, data);
        } else if (strcmp(command, "pop") == 0) {
            printf("%d\n", pop(&q));
        } else if (strcmp(command, "size") == 0) {
            printf("%d\n", size(&q));
        } else if (strcmp(command, "empty") == 0) {
            printf("%d\n", empty(&q));
        } else if (strcmp(command, "front") == 0) {
            printf("%d\n", front(&q));
        } else if (strcmp(command, "back") == 0) {
            printf("%d\n", back(&q));
        }
}
    return 0;
}
