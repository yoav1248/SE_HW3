public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public abstract int getWidth();
    public abstract int getHeight();

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object.getClass() != this.getClass()) {
            return false;
        }

        return true;
    }
}
