package board;

import pieces.Piece;

public final class OccupiedTile extends Tile {

    private final Piece pieceOnTile;

    public OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
        super(tileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean tileOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
}
