public class Rectangle extends Shape {
    private final int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
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
    public String toString() {
        String str = "";
        for (int rows = 0; rows < height; rows++) {
            str = str.concat(" * ".repeat(width) + "\n");
        }
        return str;
    }
}
