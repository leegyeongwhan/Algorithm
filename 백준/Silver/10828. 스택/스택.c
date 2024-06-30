#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

#define MAX_SIZE 100001
int stack[MAX_SIZE];
int stack_size = 0;

void push(int num) {
    stack[stack_size] = num;
    stack_size++;
}

int pop() {
    if (stack_size == 0) {
        return -1;
    }
    stack_size--;
    return stack[stack_size];
}

int size() {
    return stack_size;
}

int empty() {
    return stack_size == 0 ? 1 : 0;
}

int top() {
    if (empty() == 1) {
        return -1;
    }
    return stack[stack_size - 1];
}

int main() {
    int n, data;
    char command[6];

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%s", command);

        if (strcmp(command, "push") == 0) {
            scanf("%d", &data);
            push(data);
        } else if (strcmp(command, "pop") == 0) {
            printf("%d\n", pop());
        } else if (strcmp(command, "top") == 0) {
            printf("%d\n", top());
        } else if (strcmp(command, "empty") == 0) {
            printf("%d\n", empty());
        } else if (strcmp(command, "size") == 0) {
            printf("%d\n", size());
        }
    }

    return 0;
}
