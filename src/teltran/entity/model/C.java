package teltran.entity.model;

import telran.entity.interfaces.Entity;
import telran.entity.interfaces.EntityCollection;

import java.util.*;

public class C implements EntityCollection {
    ArrayList<Entity> collection;
    Comparator<Entity> EntityComparator = new EntityComparator();
    public C(Collection<Entity>entities) {
        collection = new ArrayList<>(entities);
        collection.sort(EntityComparator);
    }

    @Override
    public void add(Entity entity) {
        int pos = Collections.binarySearch(collection,entity,EntityComparator);
        if(pos > 0 )
            return;
        pos = -pos - 1;
        collection.add(pos,entity);
    }

    @Override
    public Entity removeMaxValue() {
        Entity val = collection.get(collection.size() - 1);
        collection.remove(collection.size() - 1);
        return val;
    }
    private  class EntityComparator implements Comparator<Entity>{

        @Override
        public int compare(Entity o1, Entity o2) {
            return o1.getValue() - o2.getValue();
        }
    }
}
