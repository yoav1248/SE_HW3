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
        return width + height + Math.sqrt(width * width + height * height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
