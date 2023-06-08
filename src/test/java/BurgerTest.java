import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;
    private Burger burger;

    @Before
    public void setUp() {
        bun = new Bun("white bun", 200);
        sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        filling = new Ingredient(IngredientType.FILLING, "sour cream", 200);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Description("Проверяем, что метод getPrice() возвращает ожидаемую " +
            "общую цену бургера, которая вычисляется на основе цены булочки и всех ингредиентов")
    @Test
    public void testGetPrice() {
        float expectedPrice = 0;
        for (Ingredient ingredient : burger.ingredients) {
            expectedPrice = expectedPrice + ingredient.getPrice();
        }
        expectedPrice = expectedPrice + (bun.getPrice() * 2);
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Description("Проверяем, что метод getReceipt() возвращает ожидаемый чек с " +
            "информацией о бургере, включая название булочки и список ингредиентов")
    @Test
    public void testGetReceipt() {
        String expectedReceipt = String.format("(==== white bun ====)%n" +
                "= sauce hot sauce =%n" +
                "= filling sour cream =%n" +
                "(==== white bun ====)%n" +
                "%n" +
                "Price: 700,000000%n");
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Description("Проверяем возможность удаления ингридиентов")
    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(sauce, burger.ingredients.get(0));
    }

    @Description("Проверяем возможно изменения ингридиентов ")
    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);
        assertEquals(filling, burger.ingredients.get(0));
        assertEquals(sauce, burger.ingredients.get(1));
    }
}
