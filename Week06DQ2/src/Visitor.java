/**
 * Some basic visitor. Anyone. Identified by name.
 *
 * Created by myltik
 * Created on 8/11/13 9:10 PM
 */
public class Visitor implements Queueing {

    private final String name;

    public Visitor(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Visitor must have a name");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        if (!name.equals(visitor.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
