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

public class Knight extends Piece{

    private static final int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17}; // possible positions for the move

    public Knight(int piecePosition, Alliance pieceAlliance) {
        super(PieceType.KNIGHT, piecePosition, pieceAlliance, true);
    }

    public Knight(int piecePosition, Alliance pieceAlliance, final boolean isFirstMove) {
        super(PieceType.KNIGHT, piecePosition, pieceAlliance, isFirstMove);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                if (isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)) {
                    continue;
                }
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance != pieceAlliance) { // means that the piece is enemy's piece
                        legalMoves.add(new MajorAttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }
        return List.copyOf(legalMoves);
    }

    @Override
    public Knight movePiece(Move move) {
        return new Knight(move.getDestinationCoordinate(), move.getMovedPiece().getPieceAlliance());
    }

    private static boolean isFirstColumnExclusion (final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -17) || (candidateOffset == -10) || (candidateOffset == 6) || (candidateOffset == 15)); // edge cases
    }

    private static boolean isSecondColumnExclusion (final int currentPosition, final int candidateOffset) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && ((candidateOffset == -10) || (candidateOffset == 6)); // edge cases
    }

    private static boolean isSeventhColumnExclusion (final int currentPosition, final int candidateOffset) {
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && ((candidateOffset == -6) || (candidateOffset == 10)); // edge cases
    }

    private static boolean isEighthColumnExclusion (final int currentPosition, final int candidateOffset) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && ((candidateOffset == -15) || (candidateOffset == -6) || (candidateOffset == 10) || (candidateOffset == 17)); // edge cases
    }
    @Override
    public String toString() {
        return PieceType.KNIGHT.toString();
    }

}
