package teltran.entity.model;

import telran.entity.interfaces.Entity;
import telran.entity.interfaces.EntityCollection;

import java.util.*;


public class A implements EntityCollection {
    HashSet<Entity> collection;

    public A(Collection<Entity> entities) {
        this.collection = new HashSet<>(entities);
    }

    @Override
    public void add(Entity entity) {
        collection.add(entity);
    }

    @Override
    public Entity removeMaxValue() {
        List<Entity> arr= new ArrayList<>(collection);
        arr.sort((o1,o2) -> o1.getValue() - o2.getValue());
        Entity val = arr.get(arr.size() - 1);
        collection.remove(val);
        return val;
    }

}
