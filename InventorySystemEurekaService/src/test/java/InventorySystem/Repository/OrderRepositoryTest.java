package InventorySystem.Repository;

import org.aspectj.lang.annotation.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

public class OrderRepositoryTest {

    @Autowired
    OrderRepository repository;

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
    }

}