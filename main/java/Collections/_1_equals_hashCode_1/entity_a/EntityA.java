package Collections._1_equals_hashCode_1.entity_a;
/*Дан класс, представляющий собой некоторую бизнес-сущность (entity), объект предметной области (domain object).
Необходимо для него корректно определить методы equals(..), hashCode() и toString().*/

public class EntityA {
    private int age;
    private int height;
    private String name;

    public EntityA(int age, int height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        EntityA other = (EntityA) obj;

        // age
        if (age != other.age) {
            return false;
        }
        // height
        if (height != other.height) {
            return false;
        }
        // name
        if (this.name == null) {
            return other.name == null;
        } else {
            return this.name.equals(other.name);
        }
//        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + height;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
//        return Objects.hash(age, height, name);
    }

//    @Override
//    public int hashCode() {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        throw new UnsupportedOperationException();
//    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}

