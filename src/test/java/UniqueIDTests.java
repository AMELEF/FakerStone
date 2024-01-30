import environment.UniqueIdentifier;
import org.junit.Test;
import static org.junit.Assert.*;

public class UniqueIDTests {
    @Test
    public void testUniqueIDAttribution(){
        UniqueIdentifier identifier = new UniqueIdentifier();
        int a = identifier.getUniqueID();
        int b = identifier.getUniqueID();
        assertNotEquals(a,b);
    }
}
