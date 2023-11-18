package board;

import pieces.Piece;

public abstract class Move {
    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    private Move(Board board, Piece movedPiece, int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }
    public int getDestinationCoordinate(){
        return this.destinationCoordinate;
    }
    public abstract Board execute();
    public Piece getMovedPiece(){
        return this.movedPiece;
    }

public static final class MajorMove extends Move {

        public MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
            super(board, movedPiece, destinationCoordinate);
        }
        /*
        performing a move doesn't mean you are going to mutate the board, it means that you will materialise a new board to existence
        move has a handle coming into this new member field
        when you execute a move, it is going to return a new board, not mutate the final board that was passed
         */
        @Override
        public Board execute() {
            //return a new Board from execute
            final Builder builder = new Builder();
            for (final Piece piece: this.board.currentPlayer().getActivePieces()){//traverse through all the current pieces
                //TODO hashcode and equals for pieces
                if (!this.movedPiece.equals(piece)){ //the not moved pieces must be just placed on the new outbound board
                    builder.setPiece(piece);
                }
            }
            for (final Piece piece: this.board.currentPlayer().getOpponent().getActivePieces()) {
                //no if statement because they won't have a moved piece
                builder.setPiece(piece); //same thing for the enemy pieces
            }
            //move the moved piece
            builder.setPiece(this.movedPiece.movePiece(this));
            //set the move maker to the opponent for the next turn
            builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
            return builder.build();
        }
    }

public static final class AttackMove extends Move {
        final Piece attackedPiece;
        public AttackMove(final Board board, final Piece movedPiece, final int destinationCoordinate, final Piece attackedPiece) {
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }

        @Override
        public Board execute() {
            return null;
        }
    }



}
