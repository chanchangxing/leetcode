import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenchangxing on 2018/12/3.
 */
public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Map<Character, List<Integer>> vertical = new HashMap<>();
        Map<Character, List<Integer>> horizontal = new HashMap<>();
        Map<Integer, List<Character>> matrix = new HashMap<>();

        for (int v = 0; v < board.length; v++) {
            for (int h = 0; h < board[v].length; h++) {
                if (board[v][h] != '.') {
                    if (vertical.containsKey(board[v][h])) {
                        if (vertical.get(board[v][h]).contains(v) || horizontal.get(board[v][h]).contains(h)) {
                            return false;
                        }

                        if (matrix.containsKey(v / 3 * 3 + h / 3)) {
                            if (matrix.get(v / 3 * 3 + h / 3).contains(board[v][h])) {
                                return false;
                            } else {
                                matrix.get(v / 3 * 3 + h / 3).add(board[v][h]);
                            }
                        } else {
                            List<Character> matrixList = new ArrayList<>();
                            matrixList.add(board[v][h]);
                            matrix.put(v / 3 * 3 + h / 3, matrixList);
                        }

                        vertical.get(board[v][h]).add(v);
                        horizontal.get(board[v][h]).add(h);

                    } else {
                        List<Integer> verticalList = new ArrayList<>();
                        verticalList.add(v);
                        vertical.put(board[v][h], verticalList);

                        List<Integer> horizontalList = new ArrayList<>();
                        horizontalList.add(h);
                        horizontal.put(board[v][h], horizontalList);

                        if (matrix.containsKey(v / 3 * 3 + h / 3)) {
                            matrix.get(v / 3 * 3 + h / 3).add(board[v][h]);
                        } else {
                            List<Character> matrixList = new ArrayList<>();
                            matrixList.add(board[v][h]);
                            matrix.put(v / 3 * 3 + h / 3, matrixList);
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board, boolean best) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')continue;
                for(int k = 8; k > j; k-- )
                    if(board[i][j] == board[i][k])
                        return false;
                for(int k = 8; k > i; k--)
                    if(board[i][j] == board[k][j])
                        return false;
                for(int k = i + 1; k % 3 != 0; k ++){
                    for(int h = j /3 *3;h < j / 3 *3 + 3; h ++ )
                        if(board[i][j] == board[k][h])
                            return false;
                }
            }
        }
        return true;
    }

    /**
     * [".",".",".",".","5",".",".","1","."],
     * [".","4",".","3",".",".",".",".","."],
     * [".",".",".",".",".","3",".",".","1"],
     * ["8",".",".",".",".",".",".","2","."],
     * [".",".","2",".","7",".",".",".","."],
     * [".","1","5",".",".",".",".",".","."],
     * [".",".",".",".",".","2",".",".","."],
     * [".","2",".","9",".",".",".",".","."],
     * [".",".","4",".",".",".",".",".","."]
     **/
    public static void main(String[] args) {
        char[][] strings = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        long before = System.currentTimeMillis();
        System.out.println(isValidSudoku(strings));
        System.out.println(System.currentTimeMillis() - before);
    }
}
