public class RightAngleTriangle extends Shape {
    private final int width, height;

    public RightAngleTriangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height / 2.;
    }

    @Override
    public double perimeter() {
        return width + height + Utils.norm(width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    protected boolean isOfSubclassWithEqualFields(Shape other) {
        return (other instanceof RightAngleTriangle) &&
                this.width == ((RightAngleTriangle) other).width &&
                this.height == ((RightAngleTriangle) other).height;
    }


    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < height; row++) {
            int rowSize = (int) ((double) (row + 1) * width / height);
            rowSize = Utils.max(rowSize, 1);  // ensure at least one star in per row
            result += Utils.STAR.repeat(rowSize) + Utils.SPACE.repeat(width - rowSize);
            result += '\n';
        }
        return result;
    }
}
