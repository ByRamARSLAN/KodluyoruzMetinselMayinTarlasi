import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int row, column;

        System.out.println("Mayın tarlasına hoşgeldiniz ! ");
        System.out.println("Lütfen oynamak istediğiniz boyutları giriniz! ");
        System.out.print("Satır Sayısı : ");
        row = scan.nextInt();
        System.out.print("Sütun sayısı : ");
        column = scan.nextInt();

        MineSweeper mine = new MineSweeper(row, column);

        mine.run();

    }
}