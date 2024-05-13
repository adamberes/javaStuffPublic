package streams;

public class PathElement {
    private String name;
    private int order;

    public PathElement(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return "PathElement{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }
}
