package pieces;

import Alliance.Alliance;
import board.Board;
import board.BoardUtils;
import board.Move;
import board.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static board.Move.*;

public class Bishop extends Piece{

    private static final int[] CANDIDATE_MOVE_VECTOR_COORDINATES = {-9, -7, 7, 9}; // possible positions for the move

    public Bishop(int piecePosition, Alliance pieceAlliance) {
        super(PieceType.BISHOP, piecePosition, pieceAlliance, true);
    }

    public Bishop(int piecePosition, Alliance pieceAlliance, final boolean isFirstMove) {
        super(PieceType.BISHOP, piecePosition, pieceAlliance, isFirstMove);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {
            int candidateDestinationCoordinate = this.piecePosition;

            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) { // loop each of the vectors in the constant array and check if its valid position (not off the board) and if the position is valid then check if the position is occupied. if not occupied its a majormove else its a attackmove

                if (isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset) || isEighthColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {
                    break;
                }

                candidateDestinationCoordinate += candidateCoordinateOffset;
                if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                    if (!candidateDestinationTile.isTileOccupied()) {
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    } else {
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                        if (this.pieceAlliance != pieceAlliance) { // means that the piece is enemy's piece
                            legalMoves.add(new MajorAttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                        }
                        break; // the break ensures that if a blocking piece is in the way
                    }
                }
            }
        }
        return List.copyOf(legalMoves);
    }

    @Override
    public Bishop movePiece(Move move) {
        return new Bishop(move.getDestinationCoordinate(), move.getMovedPiece().getPieceAlliance());
    }

    private static boolean isFirstColumnExclusion (final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -9) || (candidateOffset == 7));
    }

    private static boolean isEighthColumnExclusion (final int currentPosition, final int candidateOffset) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && ((candidateOffset == -7) || (candidateOffset == 9));
    }

    @Override
    public String toString() {
        return PieceType.BISHOP.toString();
    }
}
