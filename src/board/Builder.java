package board;

import Alliance.Alliance;
import pieces.Piece;

import java.util.Map;

public class Builder {
    /*
    this is the OOPs designing concept
     */
    /*
    we are going to set a bunch of mutable fields on our builder,
    once we invoke build, it's going to invoke an immutable board based on that builder
     */

    //integer is the 0-63 position of the piece
    //map the tile id of the chess board to the given piece on that tile id
    Map<Integer, Piece> boardConfig;
    Alliance nextMoveMaker;

    public Builder() {
    }

    /*
    we are setting some property of the current builder and
    return that builder back to the place it was called from
     */
    public Builder setPiece(final Piece piece){
        this.boardConfig.put(piece.getPiecePosition(), piece);
        return this;
    }
    public Builder setMoveMaker(final Alliance nextMoveMaker){
        this.nextMoveMaker = nextMoveMaker;
        return this;
    }

    public Board build() {
        return new Board(this);
    }
}
