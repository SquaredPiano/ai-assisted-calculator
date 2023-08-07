package entities;

public class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        int dy = endY - startY;

        if (getColor().equals("white")) {
            return dy == 1 && startX == endX;
        } else {
            return dy == -1 && startX == endX;
        }
    }
}