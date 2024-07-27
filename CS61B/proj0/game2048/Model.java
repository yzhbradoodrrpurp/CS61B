package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author Zhihang Yi.
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */
    public boolean tilt(Side side) {
        boolean changed=false;

        //tile[COL][ROW]

        int i,j,k;
        //k:COL
        //j:ROW

        board.setViewingPerspective(side);

        for(k=0;k<board.size();k++){
            for(j=board.size()-2;j>=0;j--){
                if(board.tile(k,j)==null) {
                    continue;
                }else{
                    int blank=0;

                    for(i=j+1;i<board.size();i++){
                        if(board.tile(k,i)==null)
                            blank++;
                    }
                    //这一步的意图在于计算每一个非空格元素距离最上面一行的空格数，
                    //然后再将其向上移动相应的空格数，使得所有非空格元素相邻。

                    if(blank!=0) {
                        board.move(k, j + blank, board.tile(k, j));
                        //注意：move函数不能移动null。

                        changed=true;
                    }
                }
            }
        }
        //将每一列中所有的元素全部先推向一边，暂时不进行emerge。

        for(k=0;k<board.size();k++){
            for(j=board.size()-2;j>=0;j--){
                if(board.tile(k,j)!=null){
                    //加上不等于null的条件，目的在于要移动board.tile(k,j);
                    if(board.tile(k,j).value()==board.tile(k,j+1).value()){
                        board.move(k,j+1,board.tile(k,j));
                        score+=board.tile(k,j+1).value();
                        //这一步的意图在于将相邻且相等的数emerge，并加上相应的分数。

                        for(i=j-1;i>=0;i--){
                            if(board.tile(k,i)!=null){
                                board.move(k,i+1,board.tile(k,i));
                            }
                        }
                        //这一步的意图是，emerge过后，原位置是空格，
                        //那么就要用下面的数补上空格。

                        changed=true;
                    }
                }
            }
        }

        board.setViewingPerspective(Side.NORTH);

        checkGameOver();

        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {
        int j,k;

        for(j=0;j<b.size();j++){
            for(k=0;k<b.size();k++){
                if(b.tile(j,k)==null)
                    return true;
            }
        }

        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        int j,k;

        for(j=0;j<b.size();j++){
            for(k=0;k<b.size();k++){
               if(b.tile(j,k)!=null) {
               if(b.tile(j,k).value()==MAX_PIECE)
                  return true;
               }
            }
        }

        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        if(emptySpaceExists(b)) {
            return true;
        }else{
            int j,k;

            for(j=0;j<b.size();j++){
                for(k=0;k<b.size()-1;k++){
                    if(b.tile(j,k).value()==b.tile(j,k+1).value())
                        return true;
                }
            }

            for(j=0;j<b.size()-1;j++){
                for(k=0;k<b.size();k++){
                    if(b.tile(j,k).value()==b.tile(j+1,k).value())
                        return true;
                }
            }
        }

        return false;
    }


    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
