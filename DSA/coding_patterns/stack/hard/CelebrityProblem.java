// https://takeuforward.org/plus/dsa/problems/celebrity-problem?tab=description

package coding_patterns.stack.hard;

public class CelebrityProblem {

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

    public static void main(String[] args) {
        int arr[][] = { { 0, 0 },
                { 1, 0 } };     

        // int arr[][]= [0, 1, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0], [0, 1, 1, 0]
        CelebrityProblem celebrityProblem = new CelebrityProblem();
        System.out.println(celebrityProblem.findCeleberity(arr));
    }
}