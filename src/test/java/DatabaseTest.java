import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void checkBunListSize() {
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void checkIngridientsListSize() {
        assertEquals(6, database.availableIngredients().size());
    }
}
