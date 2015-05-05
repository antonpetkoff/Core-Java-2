package test;
import tunit.*;

public class TestUser {

    private User testUser;
    
    @Before
    public void setUp() {
        testUser = new User("Dummy", 20);
        System.out.println("setUp");
    }
    
    @TestCase
    public void testGrowOneYear() {
        testUser.growOneYear();
        System.out.println("TestCase: testGrowOneYear");
    }
    
    @After
    public void tearDown() {
        System.out.println("tearDown");
    }
    
}
