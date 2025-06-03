public class Canvas {
    private final int rows, cols;
    private final Shape[][] shapeArray;

    public Canvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.shapeArray = new Shape[rows][cols];
    }

    public void addShape(Shape s, int row, int col) {
        shapeArray[row][col] = s;
    }

    public void removeShape(int row, int col) {
        shapeArray[row][col] = null;
    }

    public double getTotalArea() {
        double sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (shapeArray[row][col] != null)
                    sum += shapeArray[row][col].area();
            }
        }
        return sum;
    }

    public double getTotalPerimeter() {
        double sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (shapeArray[row][col] != null)
                    sum += shapeArray[row][col].perimeter();
            }
        }
        return sum;
    }

    private int getMaxWidth() {
        int maxWidth = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(shapeArray[row][col] != null && shapeArray[row][col].getWidth() > maxWidth) {
                    maxWidth = shapeArray[row][col].getWidth();
                }
            }
        }
        return maxWidth;
    }

    private int getMaxHeight(int row) {
        int maxHeight = 0;
        for (int col = 0; col < cols; col++) {
            if (shapeArray[row][col] != null) {
                int shapeHeight = shapeArray[row][col].getHeight();
                maxHeight = maxHeight > shapeHeight ? maxHeight : shapeHeight;
            }
        }
        return maxHeight;
    }

    /** returns a string corresponding to the shapes at the given row */
    private String getRowString(int row) {
        String rowString = "";

        int maxHeight = getMaxHeight(row);
        int maxWidth = getMaxWidth();

        // subRow
        for (int subRow = 0; subRow < maxHeight; subRow++) {
            for (Shape shape : shapeArray[row]) {
                if (shape != null && subRow < shape.getHeight()) {
                    rowString += shape.toString().split("\n")[subRow];
                    rowString += "   ";
                } else {
                    rowString += "   ".repeat(maxWidth);
                }
            }
            rowString += '\n';
        }
        return rowString;
    }

    @Override
    public String toString() {
        String result = "";
        int maxWidth = getMaxWidth();
        for (int row = 0; row < rows; row++) {
            result += getRowString(row);
        }
        return result;
    }
}
