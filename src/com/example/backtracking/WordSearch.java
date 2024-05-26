package com.example.backtracking;

public class WordSearch {

    // O(m * n) time and O(l) space
    private static Boolean wordSearch(char[][] grid, String word) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(dfs(grid, row, col, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean dfs(char[][] grid, int row, int col, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (grid[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = grid[row][col];
        grid[row][col] = '*';

        index = index + 1;
        boolean result = false;

        if (col + 1 < colLength) {
            result = dfs(grid, row, col + 1, index, word);
        }

        if (result) {
            grid[row][col] = temp;
            return true;
        }

        if (row - 1 >= 0) {
            result = dfs(grid, row - 1, col, index, word);
        }

        if (result) {
            grid[row][col] = temp;
            return true;
        }

        if (col - 1 >= 0) {
            result = dfs(grid, row, col - 1, index, word);
        }

        if (result) {
            grid[row][col] = temp;
            return true;
        }

        if (row + 1 < rowLength) {
            result = dfs(grid, row + 1, col, index, word);
        }

        grid[row][col] = temp;

        return result;
    }

    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid[0].length; j++) {
                if (j < grid[0].length - 1)
                    System.out.print("'" + grid[i][j] + "', ");
                else
                    System.out.print("'" + grid[i][j] + "'");
            }
            System.out.println("]");
        }
        System.out.println("\n");
    }

    public static void main( String args[] ) {
        char[][][] grids = {
                {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'U', 'F', 'M', 'Q'},
                        {'I', 'C', 'Q', 'R', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}},

                {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'A', 'F', 'M', 'Q'},
                        {'I', 'C', 'A', 'S', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}},

                {{'h', 'e', 'c', 'm', 'l'},
                        {'w', 'l', 'i', 'e', 'u'},
                        {'a', 'r', 'r', 's', 'n'},
                        {'s', 'i', 'i', 'o', 'r'}},

                {{'C', 'Q', 'N', 'A'},
                        {'P', 'S', 'E', 'I'},
                        {'Z', 'A', 'P', 'E'},
                        {'J', 'V', 'T', 'K'}},

                {{'O', 'Y', 'O', 'I'},
                        {'B', 'Y', 'N', 'M'},
                        {'K', 'D', 'A', 'R'},
                        {'C', 'I', 'M', 'I'},
                        {'Z', 'I', 'T', 'O'}}
        };
        String[] words = {"EDUCATIVE", "PACANS", "warrior", "SAVE", "DYNAMIC"};
        for(int i=0;i<words.length;i++){
            System.out.print(i+1);
            System.out.println(".\tGrid = ");
            printGrid(grids[i]);
            System.out.println("\tWord = "+ words[i]);

            Boolean result = wordSearch(grids[i], words[i]);
            if(result){
                System.out.println("\n\tSearch result = Found Word");
            }
            else{
                System.out.println("\n\tSearch result = Word could not be found");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
