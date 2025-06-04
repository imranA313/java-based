package leetcode;


/**
 * Q1. Check if Two Chessboard Squares Have the Same Color.
 * */
public class ChessBoardSquaresColor {
    public static void main(String[] args) {
        int x = "a1".charAt(0) - "c3".charAt(0);
        int y = "a1".charAt(1) - "c3".charAt(1);

        System.out.println((x + y) % 2);
    }
}
