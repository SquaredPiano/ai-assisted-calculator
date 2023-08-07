package entities;

public class Board {
    private Piece[][] pieces;

    public Board() {
        pieces = new Piece[8][8];
        initialize();
    }

    private void initialize() {
        // Initialize white pieces
        pieces[0][0] = new Rook("white");
        pieces[0][7] = new Rook("white");
        pieces[0][1] = new Knight("white");
        pieces[0][6] = new Knight("white");
        pieces[0][2] = new Bishop("white");
        pieces[0][5] = new Bishop("white");
        pieces[0][3] = new Queen("white");
        pieces[0][4] = new King("white");

        for (int i = 0; i < 8; i++) {
            pieces[1][i] = new Pawn("white");
        }

        // Initialize black pieces
        pieces[7][0] = new Rook("black");
        pieces[7][7] = new Rook("black");
        pieces[7][1] = new Knight("black");
        pieces[7][6] = new Knight("black");
        pieces[7][2] = new Bishop("black");
        pieces[7][5] = new Bishop("black");
        pieces[7][3] = new Queen("black");
        pieces[7][4] = new King("black");

        for (int i = 0; i < 8; i++) {
            pieces[6][i] = new Pawn("black");
        }
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = pieces[startX][startY];
        if (piece != null && piece.isValidMove(startX, startY, endX, endY)) {
            pieces[startX][startY] = null;
            pieces[endX][endY] = piece;
            return true;
        }
        return false;
    }
}
