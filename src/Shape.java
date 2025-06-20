public abstract class Shape {
    public abstract double area();

    public abstract double perimeter();

    public abstract int getWidth();

    public abstract int getHeight();

    protected abstract boolean isOfSubclassWithEqualFields(Shape shape);

    @Override
    public boolean equals(Object other) {
        return (other instanceof Shape) &&
                this.isOfSubclassWithEqualFields((Shape) other) &&
                ((Shape) other).isOfSubclassWithEqualFields(this);
    }
}
