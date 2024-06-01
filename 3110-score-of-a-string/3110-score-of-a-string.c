int length(char* s) {
    int len = 0;
    while (*(s + len)) {
        len++;
    }
    return len;
}

int myAbs(int a, int b) {
    return a > b ? a - b : b - a;
}
int scoreOfString(char* s) {
    int len = length(s);
    int score = 0;
    for (int i = 0; i < len - 1; i++) {
        score += myAbs(*(s + i), *(s + i + 1));
    }
    return score;
}