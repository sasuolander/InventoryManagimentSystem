package inventorysystem.repositorytest;

import inventorysystem.object.entity.Order;
import inventorysystem.object.pojo.OrderPOJO;
import inventorysystem.repository.OrderRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = OrderRepository.class)
public class OrderRepositoryTest {

    @Autowired private OrderRepository repository;
    private final Logger logger = LoggerFactory.getLogger(OrderRepositoryTest.class);
    @Test
    public void injectedComponentsAreNotNull(){
        assertThat(repository).isNotNull();
    }

    final String firstName="Tim";
    final String lastName="Tom";
    final String title="More item";
    OrderPOJO order2 = OrderPOJO.Builder().orderId(1L).firstName(firstName).lastName(lastName).title(title).build();
    Order order = new Order().translatePojoToPersistent(order2);
    @BeforeClass
    public static void populateDatabase(){


    }
    @AfterClass
    public static void emptyDatabase(){


    }


    @Test
    public void saveOrderAndThenFindById(){

        repository.save(order);
        Optional<Order> order1 = repository.findById(1L);
        //logger.info("wait",order1.toString());
        assertThat(order1).isNotNull();
        assertEquals(order.getOrderId(),order1.get().getOrderId());
    }

    @Test
    public void findByFirstNameTest(){
        repository.save(order);
        Order order1= repository.findByFirstName(firstName);
        assertThat(order1).isNotNull();
        assertEquals(firstName,order1.getFirstName());
    }
    @Test
    public void findByLastNameTest(){
        repository.save(order);
        Order order1= repository.findByLastName(lastName);
        assertThat(order1).isNotNull();
        assertEquals(lastName,order1.getLastName());
    }
    @Test
    public void findByTitleTest(){
        repository.save(order);
        Order order1= repository.findByTitle(title);
        assertThat(order1).isNotNull();
        assertEquals(title,order1.getTitle());
    }
//id is not static so this test fail
     @Test
    public void deleteById(){
        repository.deleteById(1L);
         Optional<Order> order1 = repository.findById(1L);
         assertThat(order1).isEmpty();
     }

}