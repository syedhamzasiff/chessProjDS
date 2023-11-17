package Tile;

import pieces.Piece;

public abstract class Tile {
    //in the mind look it as a 2d array
    //we are going to make 64 diff chess tiles

    int tileCoordinate;

    public Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }
    public abstract boolean tileOccupied();
    public abstract Piece getPiece();


}
