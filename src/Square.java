public class Square extends Rectangle {
    public Square(int sideLength) {
        super(sideLength, sideLength);
    }

    @Override
    protected boolean isOfSubclassWithEqualFields(Shape other) {
        return (other instanceof Square) &&
                super.isOfSubclassWithEqualFields(other);
    }
}
