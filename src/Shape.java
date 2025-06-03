public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public abstract int getWidth();
    public abstract int getHeight();

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        return true;
    }
}
