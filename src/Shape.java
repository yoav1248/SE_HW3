public abstract class Shape {
    /**
     * @return the shape's area
     */
    public abstract double area();

    /**
     * @return the shape's perimeter
     */
    public abstract double perimeter();

    /**
     * @return the shape's width
     */
    public abstract int getWidth();

    /**
     * @return the shape's height
     */
    public abstract int getHeight();

    /**
     * must return true iff the runtime class of other is a subclass of the runtime class of this,
     * and the fields of this exist in other with the same value
     */
    protected abstract boolean isOfSubclassWithEqualFields(Shape other);

    @Override
    public boolean equals(Object other) {
        return (other instanceof Shape) &&
                this.isOfSubclassWithEqualFields((Shape) other) &&
                ((Shape) other).isOfSubclassWithEqualFields(this);
    }
}
