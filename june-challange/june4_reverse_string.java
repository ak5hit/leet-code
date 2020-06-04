class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int p1 = 0, p2 = length - 1;

        char temp;

        while (p1 < length / 2) {
            temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;

            p1++;
            p2--;
        }
    }
}