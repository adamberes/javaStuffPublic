package streams;

public class PfadElement {
    private String name;
    private int order;

    public PfadElement(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return "PfadElement{" +
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
