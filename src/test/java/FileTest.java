import org.junit.Assert;
import org.junit.Test;

/**
 *Тестирование файла
 */
    public class FileTest {

    @Test
    public void testName() throws Exception {

        Start start = new Start();
        String inName = start.getNameFile();
        String name = "Input.txt";

        Assert.assertEquals(name, inName);

    }
}


