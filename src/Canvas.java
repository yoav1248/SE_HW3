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
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (shapeArray[row][col] != null && shapeArray[row][col].getWidth() > maxWidth) {
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

    /**
     * returns a string corresponding to the shapes at the given row, including the newline space after it.
     */
    private String getRowString(int row) {
        String rowString = "";

        int maxHeight = getMaxHeight(row);
        int maxWidth = getMaxWidth();

        // subRow is indexing an actual row of output (ending with a newline)
        // iterate over all rows relevant to our a row
        for (int subRow = 0; subRow < maxHeight; subRow++) {
            for (Shape shape : shapeArray[row]) {
                if (shape != null) {
                    // if there's a shape in that cell, adjust to the width of the shape (and add 1 for a space)
                    if (subRow < shape.getHeight()) {
                        // if the shape hits our subRow, get the part from shape's string
                        rowString += shape.toString().split("\n")[subRow];
                        rowString += Utils.SPACE;
                    } else {
                        rowString += Utils.SPACE.repeat(shape.getWidth() + 1);
                    }
                } else {
                    // if no shape in that cell, adjust to maxWidth (and add 1 for space)
                    rowString += Utils.SPACE.repeat(maxWidth + 1);
                }
            }
            rowString += '\n';
        }
        return rowString;
    }

    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < rows; row++) {
            result += getRowString(row);
        }
        return result;
    }
}
