package teltran.entity.model;

import telran.entity.interfaces.Entity;
import telran.entity.interfaces.EntityCollection;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class B implements EntityCollection {
    TreeSet<Entity>collection;

    public B(Collection<Entity> entities) {
        this.collection = new TreeSet<>((o1, o2) -> o1.getValue() - o2.getValue());
        collection.addAll(entities);
    }

    @Override
    public void add(Entity entity) {
        collection.add(entity);
    }

    @Override
    public Entity removeMaxValue() {
        return collection.pollLast();
    }
}
