package view;

import entities.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGUI extends JFrame {
    private JButton[][] squares = new JButton[8][8];
    private Board board = new Board(); // Assuming you have a Board class similar to the previous example

    public ChessGUI() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        initializeSquares();
        setupPieces();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeSquares() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = new JButton();
                squares[row][col].addActionListener(new SquareActionListener(row, col));
                add(squares[row][col]);
            }
        }
    }

    private void setupPieces() {
        // Initialize the board with pieces and update the GUI
        // You can use a loop to iterate over the board and set icons on the buttons
        // based on the piece type and color.
    }

    private class SquareActionListener implements ActionListener {
        private int row, col;

        public SquareActionListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the piece movement logic here
            // You can use row and col to identify which square was clicked
            // and implement the logic to move the pieces on the board.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessGUI());
    }
}
