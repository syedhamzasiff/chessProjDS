package board;

import pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    //in the mind look it as a 2d array
    //we are going to make 64 diff chess tiles

    protected final int tileCoordinate;

    /*
    we can create all empty tiles upfront and whenever we want to retrieve one
    instead of creating a new one, we could look it up on cache
     */
    private static final Map<Integer, EmptyTile> emptyTiles = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles(){

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return emptyTileMap;
        //immutable map
        //return ImmutableMap.copyOf(emptyTileMap);
    }

    //the only method that will be used to create a tile will be this tile method
    //and if they ever need an empty tile they will get one of the cached empty tiles
    //otherwise they are going to create a new occupied tile
    //we can cache all the occupied tiles too (might implement later)
    //this is to save space and not discard/make new tile every move but to use the cached ones
    public static Tile createTile(final int tileCoordinate, final Piece piece){
        if (piece != null) {
            return new OccupiedTile(tileCoordinate, piece);
        } else {
            return emptyTiles.get(tileCoordinate);
        }
    }

    Tile(final int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();


    public int getTileCoordinate() {
        return this.tileCoordinate;
    }
}
