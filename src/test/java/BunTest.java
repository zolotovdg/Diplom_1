import jdk.jfr.Description;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Description("Проверяем, что метод getName возвращает правильное название булочки")
    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100);
        String expectedName = "black bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Description("Проверяем, что метод getPrice возвращает правильную цену")
    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 100);
        float expectedPrice = 100;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 100);
    }
}