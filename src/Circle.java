public class Circle extends Shape {
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int getWidth() {
        return 2 * radius + 1;
    }

    @Override
    public int getHeight() {
        return this.getWidth();
    }
}
