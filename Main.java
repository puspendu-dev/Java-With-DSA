package TicTacToeGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][]board=new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col]=' ';
            }
        }
        char Player='X';
        boolean GameOver=false;
        Scanner in=new Scanner(System.in);
        while (!GameOver){
            printBoard(board);
            System.out.println("Player" +Player + "enter:");
            int row= in.nextInt();
            int col= in.nextInt();
            if(board[row][col]==' '){
              //place the element
                board[row][col]=Player;
                GameOver=haveWon(board,Player);
                if (GameOver){
                    System.out.println("Player" +Player + "has Won:");
                }
                else {
//                    if(Player=='X'){
//                        Player='0';
//                    }
//                    else {
//                        Player='X';
//                    }
                    Player=(Player=='X')?'0':'X';
                }
            }
            else {
                System.out.println("Invalid Move.TryAgain");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
        //check for row
        for (int row = 0; row < board.length; row++) {
         if(board[row][0]==player&&board[row][1]==player&&board[row][1]==player){
             return true;
         }
        }
        //check for col
        for (int col = 0; col < board[0].length; col++) {
            if(board[0][col]==player&&board[1][col]==player&&board[2][col]==player){
                return true;
            }
        }
        //diagonal
        if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        }
        if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]+"|");
            }
            System.out.println();
        }
    }
}
