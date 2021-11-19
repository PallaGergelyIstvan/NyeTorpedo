package nye.harmadikfélév.torpedo;

import java.util.Arrays;
import java.util.Objects;

public class Map {

    public static MapVOBuilder builder() {
        return new MapVOBuilder();
    }

    private final int numberOfRows;
    private final int numberOfColumns;
    private final int[][] map;


    public Map(int numberOfRows, int numberOfColumns, int[][] map, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = deepCopy(map);

    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return deepCopy(map);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.deepHashCode(map);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                ", map=" + Arrays.toString(map) +
                '}';
    }

    private int[][] deepCopy(int[][] array) {
        int[][] result = null;

        if (array != null) {
            result = new int[array.length][];
            for (int i = 0; i < array.length; i++) {
                result[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }

        return result;
    }

    private boolean[][] deepCopy(boolean[][] array) {
        boolean[][] result = null;

        if (array != null) {
            result = new boolean[array.length][];
            for (int i = 0; i < array.length; i++) {
                result[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }

        return result;
    }

    public static final class MapVOBuilder {
        private int numberOfRows;
        private int numberOfColumns;
        private int[][] map;

        private MapVOBuilder() {
        }

        public static MapVOBuilder builder() {
            return new MapVOBuilder();
        }

        public MapVOBuilder withNumberOfRows(int numberOfRows) {
            this.numberOfRows = numberOfRows;
            return this;
        }

        public MapVOBuilder withNumberOfColumns(int numberOfColumns) {
            this.numberOfColumns = numberOfColumns;
            return this;
        }

        public MapVOBuilder withMap(int[][] map) {
            this.map = map;
            return this;
        }

    }

}