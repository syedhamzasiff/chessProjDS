package pieces;

import Alliance.Alliance;
import board.Board;
import board.Move;

import java.util.Collection;


public abstract class Piece {

    protected final PieceType pieceType;
    protected final int piecePosition; // position of piece on the board
    protected final Alliance pieceAlliance; // tells if the piece is of the black or white team
    protected final boolean isFirstMove;

    Piece (final PieceType pieceType, final int piecePosition, final Alliance pieceAlliance) {
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
        this.pieceType = pieceType;
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

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public enum PieceType{
        /*
        This code defines an enumeration (enum) in Java called PieceType,
        representing different types of chess pieces.
        Each enum constant corresponds to a specific chess piece type:
        PAWN, KNIGHT, ROOK, QUEEN, and KING.
         */
        PAWN("P") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        KNIGHT("N") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        ROOK("R") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        BISHOP("B") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        QUEEN("Q") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        KING("K") {
            @Override
            public boolean isKing() {
                return true;
            }
        };
        private String pieceName; //Each enum constant has an associated


        PieceType(final String pieceName) { //The constructor initializes the pieceName field for each enum constant.
            this.pieceName = pieceName;
        }
        @Override
        public String toString() {
            return this.pieceName;
        }

        public abstract boolean isKing();

    }

}
