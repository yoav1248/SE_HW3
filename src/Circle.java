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

    @Override
    protected boolean isOfSubclassWithEqualFields(Shape other) {
        return (other instanceof Circle) &&
                this.radius == ((Circle) other).radius;
    }


    @Override
    public String toString() {
        // center is at (radius, radius)
        String result = "";
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                double dist = Utils.norm(i - radius, j - radius);
                if (dist <= radius + 0.3) {
                    result += Utils.STAR;
                } else {
                    result += Utils.SPACE;
                }
            }
            result += '\n';
        }
        return result;
    }
}
