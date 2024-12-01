import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][] classroom = new char[5][5];
    static boolean[][] selected = new boolean[5][5];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                classroom[i][j] = line.charAt(j);
            }
        }
        
        backtracking(0, 0);

        System.out.println(answer);
    }

    static void backtracking(int start, int count) {
        if (count == 7) {
            if (isConnected() && checkDasom()) {
                answer++;
            }
            return;
        }
        
        for (int i = start; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;

            selected[row][col] = true;
            backtracking(i + 1, count + 1);
            selected[row][col] = false;
        }
    }
    
    static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        
        int startRow = -1, startCol = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (selected[i][j]) {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
            if (startRow != -1) break;
        }
        
        dfs(startRow, startCol, visited);
        
        int connectCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (selected[i][j] && visited[i][j]) {
                    connectCount++;
                }
            }
        }

        return connectCount == 7;
    }
    
    static void dfs(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= 5 || col < 0 || col >= 5 ||
                !selected[row][col] || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        // 상하좌우 탐색
        dfs(row+1, col, visited);
        dfs(row-1, col, visited);
        dfs(row, col+1, visited);
        dfs(row, col-1, visited);
    }
    
    static boolean checkDasom() {
        int dasomCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (selected[i][j] && classroom[i][j] == 'S') {
                    dasomCount++;
                }
            }
        }
        return dasomCount >= 4;
    }
}