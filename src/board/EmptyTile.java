package board;

import pieces.Piece;

public final class EmptyTile extends Tile {

    private int coordinate;

    public EmptyTile(int coordinate) {
        super(coordinate);
    }

    @Override
    public boolean isTileOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
