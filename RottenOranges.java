import java.util.*;

class Solution {

    public static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public static int minTimeRotten(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            time++;

            int len = q.size();

            while (len-- > 0) {
                int curr[] = q.remove();
                int i = curr[0];
                int j = curr[1];

                for (int dir[] : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (isSafe(x, y, n, m) && arr[x][y] == 1) {
                        arr[x][y] = 2;
                        q.add(new int[] { x, y });
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, time - 1);
    }
}