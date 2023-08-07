package chess;

import entities.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        // Example: Moving a piece
        boolean moveSuccessful = board.movePiece(1, 0, 3, 0);
        System.out.println("Move successful: " + moveSuccessful);
    }
}