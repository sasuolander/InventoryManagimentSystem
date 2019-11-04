package inventorysystem.repositorytest;

import inventorysystem.object.entity.Order;
import inventorysystem.object.pojo.OrderPOJO;
import inventorysystem.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(repository).isNotNull();
    }

    @Test
    public void saveOrderAndThenFindByOrderId() {
        final String firstName = "Tim";
        final String lastName = "Tom";
        final String title = "More item";
        OrderPOJO order2 = OrderPOJO.Builder().orderId("0ecabc0d80513f15e12838388c756f482198e7bcb3e1df4b37b92a76e2f73cbb").firstName(firstName).lastName(lastName).title(title).build();
        Order order = new Order().translatePojoToPersistent(order2);

        Optional<Order> order1 = repository.findByOrderId(order2.getOrderId());
        //logger.info("wait",order1.toString());
        assertThat(order1).isNotNull();
        assertEquals(order.getOrderId(), order1.get().getOrderId());
    }

    @Test
    public void findByFirstNameTest() {
        Order order1 = repository.findByFirstName("Aindrea").get();
        assertThat(order1).isNotNull();
        assertEquals("Aindrea", order1.getFirstName());
    }

    @Test
    public void findByLastNameTest() {

        Order order1 = repository.findByLastName("Calles").get();
        assertThat(order1).isNotNull();
        assertEquals("Calles", order1.getLastName());
    }

    @Test
    public void findByTitleTest() {
        Order order1 = repository.findByTitle("Meembee").get();
        assertThat(order1).isNotNull();
        assertEquals("Meembee", order1.getTitle());
    }

    @Test
    public void deleteById() {
        repository.deleteByOrderId("44ac23325ebaadb5a07a81f7328e60fc8711837da14399c8edadb523a81dc369");
        Optional<Order> order1 = repository.findByOrderId("44ac23325ebaadb5a07a81f7328e60fc8711837da14399c8edadb523a81dc369");
        assertThat(order1).isEmpty();
    }

}