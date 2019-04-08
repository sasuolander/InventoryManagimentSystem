package inventorysystem.repositorytest;

import inventorysystem.object.Order;
import inventorysystem.repository.OrderRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
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

    @BeforeClass
    public static void populateDatabase(){


    }
    @AfterClass
    public static void emptyDatabase(){

    }


    @Test
    public void saveOrder(){
       Order order = new Order.Builder(1L).setFirstName("tim").setLastName("tim").build();
        repository.save(order);
        Optional<Order> order1 = repository.findById(1L);
        //logger.info("wait",order1.toString());
        assertThat(order1).isNotNull();
        //assertEquals("tim",order1.getFirstName());
    }

   /* @Test
    public void findByFirstNameTest(){
        repository.findByFirstName(firstName);
    }
    @Test
    public void findByLastNameTest(){
        repository.findByLastName(lastName);
    }
    @Test
    public void findByTitleTest(){
        repository.findByTitle(title);
    }*/

}