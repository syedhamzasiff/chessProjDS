package pieces;

import Alliance.Alliance;
import board.Board;
import board.Move;

import java.util.List;


public abstract class Piece {

    protected final int piecePosition; // position of piece on the board
    protected final Alliance pieceAlliance; // tells if the piece is of the black or white team

    Piece (final int piecePosition, final Alliance pieceAlliance) {
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }

    public abstract List<Move> calculateLegalMoves (final Board board);

}
