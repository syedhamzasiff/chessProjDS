package Tile;

import pieces.Piece;

public final class EmptyTile extends Tile{

    int coordinate;

    public EmptyTile(int coordinate) {
        super(coordinate);
    }

    @Override
    public boolean tileOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
