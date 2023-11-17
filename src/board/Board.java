package board;

import java.util.List;

public class Board {
    /*
    using list because you cant have an immutable list in java but
    you can have an immutable list
     */

    private final List<Tile> gameBoard;

    protected Board(Builder builder) {
        //calling this constructor makes a gameBoard
        this.gameBoard = createGameBoard(builder);
        //populate a list of tiles numbered 0-63
    }

    public Tile getTile(final int tileCoordinate) {
        return null;
    }
    private static List<Tile> createGameBoard(final Builder builder){
        final Tile[] tiles = new Tile[BoardUtils.NUM_TILES]; //create an array of 64 tiles
        /*
        in this loop:
        we get from our config that where ever we set our config, we are going to map a piece on to a tile ID
         */
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            tiles[i] = Tile.createTile(i, builder.boardConfig.get(i)); //get the piece thats associated with tile ID 4, and create a tile from it
        }
        return List.of(tiles);
        //ImmutableList.copyOf(tiles);
    }
    public static Board createStandardBoard(){
        //create the initial position of the chess board (starting point)
        //use the builder class
        return null;
    }
}
