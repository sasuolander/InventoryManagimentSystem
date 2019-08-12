package inventorysystem.object;

public interface PersistentObject<T,A> {
     T translatePojoToPersistent(A objectPojo);
}
