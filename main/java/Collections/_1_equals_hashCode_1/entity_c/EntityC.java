package Collections._1_equals_hashCode_1.entity_c;

/* Дан класс, представляющий собой некоторую бизнес-сущность (entity), объект предметной области (domain object).
Необходимо для него корректно определить методы equals(..), hashCode() и toString().
Предполагается, что методы equals(..), hashCode() и toString() для EntityA и EntityB уже корректно определены.*/
import Collections._1_equals_hashCode_1.entity_a.EntityA;
import Collections._1_equals_hashCode_1.entity_b.EntityB;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;

    public EntityC(EntityA entity, List<EntityB> list, Map<Set<EntityA>, List<EntityB[]>> map) {
        this.entity = entity;
        this.list = list;
        this.map = map;
    }

    public EntityA getEntity() {
        return entity;
    }

    public List<EntityB> getList() {
        return list;
    }

    public Map<Set<EntityA>, List<EntityB[]>> getMap() {
        return map;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
