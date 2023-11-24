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
    private final int cachedHashCode;

    Piece (final PieceType pieceType, final int piecePosition, final Alliance pieceAlliance, final boolean isFirstMove) {
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
        this.pieceType = pieceType;
        //TODO more work here
        this.isFirstMove = isFirstMove;
        this.cachedHashCode = computeHashCode();
    }
    private int computeHashCode(){
        int result = pieceType.hashCode();
        result = 31 * result + pieceAlliance.hashCode();
        result = 31 * result + piecePosition;
        if (isFirstMove) {
            result = 31 * result + 1;
        } else {
            result = 31 * result;
        }
        return result;
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public int getPieceValue() {
        return this.pieceType.getPieceValue();
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public abstract Collection<Move> calculateLegalMoves (final Board board); // checks for legal moves of each piece

    public abstract Piece movePiece(Move move); //take in a move and apply it to the existing piece that we are on and give a new piece that is just like the old piece with an updated position - keeping things immutable
    public int getPiecePosition(){
        return piecePosition;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }
    @Override
    public boolean equals(final Object other){ //we don't want to do reference equality, we want object equality
        if (this == other){
            return true;
        }
        if (!(other instanceof Piece)){
            return false;
        }
        final Piece otherPiece = (Piece) other;
        return piecePosition == otherPiece.getPiecePosition() && pieceType == otherPiece.getPieceType() &&
                pieceAlliance == otherPiece.getPieceAlliance() && isFirstMove == otherPiece.isFirstMove();
    }
    @Override
    public int hashCode(){
        return this.cachedHashCode;
    }

    public int locationBonus() {
        return 0;
    }

    public enum PieceType{
        /*
        This code defines an enumeration (enum) in Java called PieceType,
        representing different types of chess pieces.
        Each enum constant corresponds to a specific chess piece type:
        PAWN, KNIGHT, ROOK, QUEEN, and KING.
         */
        PAWN(100, "P") {
            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        KNIGHT(300, "N") {
            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        ROOK(500, "R") {
            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return true;
            }
        },
        BISHOP(300, "B") {
            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        QUEEN(900, "Q") {
            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        KING(10000, "K") {
            @Override
            public boolean isKing() {
                return true;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        };
        private String pieceName; //Each enum constant has an associated

        private int pieceValue;


        PieceType(final int pieceValue,final String pieceName) { //The constructor initializes the pieceName field for each enum constant.
            this.pieceName = pieceName;
            this.pieceValue = pieceValue;
        }

        @Override
        public String toString() {
            return this.pieceName;
        }

        public abstract boolean isKing();

        public abstract boolean isRook();

        public int getPieceValue() {
            return this.pieceValue;
        }

        public String getPieceName() {
            return pieceName;
        }
    }

}
