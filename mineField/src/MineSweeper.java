import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    public int rowNumber, colNumber, size;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    MineSweeper(int rowNumber, int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];

    }

    public void run(){
        int row, col, success = 0;
        prepareGame();
        //print(map);
        System.out.println("Oyun başladı !");
        while( game ){
            print(board); // kullanıcıya board'u sürekli göstermem gerek
            System.out.print("Satır : ");
            row = scan.nextInt();
            System.out.print("Sütun : ");
            col = scan.nextInt();

            if(row < 0 || row >= rowNumber){
                System.out.println("Geçersiz koordinat girildi.");
                continue;
            }

            if(col < 0 || col >= colNumber){
                System.out.println("Geçersiz koordinat girildi.");
                continue;
            }

            if(map[row][col] != -1){
                checkMine(row,col);
                success += 1;
                if(success == (size - (size/4))){
                    System.out.println("Mayına basmadan oyunu bitirdiniz.");
                    break;
                }
            }else{
                game = false;
                System.out.println("Game Over !");
            }
        }
    }

    public void checkMine(int r, int c){
        if(map[r][c] == 0){
            if((c < colNumber -1) && (map[r][c+1] == -1)){
                board[r][c] += 1;
            }
            if((r < rowNumber-1) && (map[r+1][c] == -1)){
                board[r][c] += 1;
            }
            if((c > 0) && (map[r][c-1] == -1)){
                board[r][c] += 1;
            }
            if((r > 0) && (map[r-1][c] == -1)){
                board[r][c] += 1;
            }
        }
        if(board[r][c] == 0){
            board[r][c] = -2;
        }

    }

    public void prepareGame(){
        int randRow, randCol, count = 0;
        while(count != (size/4)){
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if(map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count += 1;
            }
        }
    }

    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
