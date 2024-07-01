package streams;

record PathElement(String name, int order) {
    @Override
    public String toString () {
        return "PathElement{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}