package Examples;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DisabledTest {
    // Ignored test method
    @Disabled("Disabled until CustomerService is up!")
    @Test
    void testCustomerServiceGet() {
        assertEquals(2, 1 + 1);
        System.out.println("Expected and actual result is same");
    }

    // Test method that will execute
    @Test
    void test3Plus3() {
        assertEquals(6, 3 + 3);
        System.out.println("3+3 is 6 this is pass");
    }
}