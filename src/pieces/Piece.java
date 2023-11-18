package pieces;

import Alliance.Alliance;
import board.Board;
import board.Move;

import java.util.Collection;


public abstract class Piece {

    protected final int piecePosition; // position of piece on the board
    protected final Alliance pieceAlliance; // tells if the piece is of the black or white team
    protected final boolean isFirstMove;

    Piece (final int piecePosition, final Alliance pieceAlliance) {
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
        //TODO more work here
        this.isFirstMove = false;
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public abstract Collection<Move> calculateLegalMoves (final Board board); // checks for legal moves of each piece

    public int getPiecePosition(){
        return piecePosition;
    }

}
