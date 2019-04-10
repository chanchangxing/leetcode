import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/23.
 */
public class Exist {
    List<Integer> countList = new ArrayList<>();

    public boolean exist(char[][] board, String word) {

        char first = word.charAt(0);
        if (board.length * board[0].length < word.length()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == first) {
                    countList.add(board[0].length * i + j);

                    if (word.length() == 1) {
                        return true;
                    }
                    if (a(board, word, 1, i - 1, j, 1, countList) ||
                            a(board, word, 1, i, j + 1, 2, countList) ||
                            a(board, word, 1, i + 1, j, 3, countList) ||
                            a(board, word, 1, i, j - 1, 4, countList)) {
                        return true;
                    }

                    countList.remove(board[0].length * i + j);

                }
            }
        }

        return false;
    }

    private boolean a(char[][] board, String word, int index, int i, int j, int k, List<Integer> countList) {
        if (i < 0 || i == board.length
                || j < 0 || j == board[0].length
                || word.charAt(index) != board[i][j]
                || countList.contains(board[0].length * i + j)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        countList.add(board[0].length * i + j);

        switch (k) {
            case 1: {
                if (a(board, word, index + 1, i - 1, j, 1, countList) ||
                        a(board, word, index + 1, i, j + 1, 2, countList) ||
                        a(board, word, index + 1, i, j - 1, 4, countList)) {
                    return true;
                } else {
                    countList.remove(countList.indexOf(board[0].length * i + j));
                    return false;
                }
            }
            case 2: {
                if (a(board, word, index + 1, i - 1, j, 1, countList) ||
                        a(board, word, index + 1, i, j + 1, 2, countList) ||
                        a(board, word, index + 1, i + 1, j, 3, countList)) {
                    return true;
                } else {
                    countList.remove(countList.indexOf(board[0].length * i + j));
                    return false;
                }
            }
            case 3: {
                if (a(board, word, index + 1, i, j + 1, 2, countList) ||
                        a(board, word, index + 1, i + 1, j, 3, countList) ||
                        a(board, word, index + 1, i, j - 1, 4, countList)) {
                    return true;
                } else {
                    countList.remove(countList.indexOf(board[0].length * i + j));
                    return false;
                }
            }
            case 4: {
                if (a(board, word, index + 1, i - 1, j, 1, countList) ||
                        a(board, word, index + 1, i + 1, j, 3, countList) ||
                        a(board, word, index + 1, i, j - 1, 4, countList)) {
                    return true;
                } else {
                    countList.remove(countList.indexOf(board[0].length * i + j));
                    return false;
                }
            }
        }

        return false;
    }

//    [["C","A","A"],["A","A","A"],["B","C","D"]]
//            "AAB"



    public static boolean exist1(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int k, int i, int j) {
        if (k == word.length()) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[i].length) return false;
        if (board[i][j] != word.charAt(k)) return false;
        board[i][j] ^= 256;
        if (dfs(board, word, k + 1, i - 1, j) ||
                dfs(board, word, k + 1, i + 1, j) ||
                dfs(board, word, k + 1, i, j - 1) ||
                dfs(board, word, k + 1, i, j + 1) ) return true;
        board[i][j] ^= 256;
        return false;
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{
//                new char[]{'a','b'},
                new char[]{'C', 'A', 'A'},
                new char[]{'A', 'A', 'A'},
                new char[]{'B', 'C', 'D'},
//                new char[]{'a', 'a', 'a', 'a'},
//                new char[]{'a', 'a', 'a', 'b'},
        };


        System.out.print(exist1(b, "AAB"));
    }
}
