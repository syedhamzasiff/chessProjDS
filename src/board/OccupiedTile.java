package board;

import pieces.Piece;

public final class OccupiedTile extends Tile {

    private final Piece pieceOnTile;

    public OccupiedTile(int tileCoordinate, final Piece pieceOnTile) {
        super(tileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
    @Override
    public String toString() {
        if (getPiece().getPieceAlliance().isBlack()) {
            return getPiece().toString().toLowerCase();
        } else {
            return getPiece().toString().toUpperCase();
        }
    }
}
