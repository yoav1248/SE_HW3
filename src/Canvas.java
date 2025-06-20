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
                maxHeight = Utils.max(maxHeight, shapeHeight);
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
            for (int col = 0; col < cols; col++) {
                Shape shape = shapeArray[row][col];
                if (shape != null) {
                    // if there's a shape in that cell, adjust to the width of the shape
                    if (subRow < shape.getHeight()) {
                        // if the shape hits our subRow, get the part from shape's string
                        rowString += shape.toString().split("\n")[subRow];
                    } else {
                        rowString += Utils.SPACE.repeat(shape.getWidth());
                    }
                } else {
                    // if no shape in that cell, adjust to maxWidth
                    rowString += Utils.SPACE.repeat(maxWidth);
                }
                // if not at the end, add a space (so it's just spaces between the shapes)
                if (col != cols - 1) {
                    rowString += Utils.SPACE;
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
            result += getRowString(row) + '\n';
        }
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Canvas)) {
            return false;
        }

        Canvas otherCanvas = (Canvas) other;

        if (this.cols != otherCanvas.cols || this.rows != otherCanvas.rows) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Shape thisShape = shapeArray[i][j];
                Shape otherShape = otherCanvas.shapeArray[i][j];
                if (thisShape == null) {
                    if (otherShape != null) {
                        return false;
                    }
                } else {
                    if (!(thisShape.equals(otherShape))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
