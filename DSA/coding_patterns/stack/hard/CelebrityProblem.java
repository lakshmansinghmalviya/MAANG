// https://takeuforward.org/plus/dsa/problems/celebrity-problem?tab=description

package coding_patterns.stack.hard;

public class CelebrityProblem {

    // optimal things
    // Need revesion
    int findCeleberityOptimal(int arr[][]) {

        int top = 0, down = arr.length - 1;

        while (top < down) {

            if (arr[top][down] == 1) {
                top++;
            } else if (arr[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }

        if (top > down)
            return -1;

        for (int i = 0; i < arr.length; i++) {

            if (top == i)
                continue;

            else if (arr[top][i] == 0 && arr[i][top] == 1) {

            } else
                return -1;
        }

        return top;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 0 },
                { 0, 1 } };

        // int arr[][]=
        // [0, 1, 1, 0],
        // [0, 0, 0, 0],
        // [1, 1, 0, 0],
        // [0, 1, 1, 0]

        CelebrityProblem celebrityProblem = new CelebrityProblem();
        System.out.println(celebrityProblem.findCeleberityOptimal(arr));
    }

    // brute force
    int findCeleberity(int arr[][]) {
        int knownByOthers[] = new int[arr.length];
        int knows[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    knows[i]++;
                    knownByOthers[j]++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (knownByOthers[i] == arr.length - 1 && knows[i] == 0)
                return i;
        }
        return -1;
    }
}