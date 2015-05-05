package test;
import tunit.*;

public class TestUser {

    private User testUser;
    
    @Before(priority=1)
    public void setUp() {
        testUser = new User("Dummy", 20);
        System.out.println("setUp with priority 1");
    }
    
    @Before(priority=2)
    public void setUp2() {
        testUser = new User("Dummy", 20);
        System.out.println("setUp with priority 2");
    }
    
    @TestCase
    public void testGrowOneYear() {
        testUser.growOneYear();
        TUnit.assertEquals(Integer.valueOf(21), testUser.getAge());
        System.out.println("TestCase: testGrowOneYear");
    }
    
    @After
    public void tearDown() {
        System.out.println("tearDown");
    }
    
}
