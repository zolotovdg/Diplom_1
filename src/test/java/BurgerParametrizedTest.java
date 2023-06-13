import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private float bunPrice;
    private float ingridientPrice;
    private float expectedPrice;

    public BurgerParametrizedTest(float bunPrice, float ingridientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingridientPrice = ingridientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Стоимость булочки. Тестовые данные: {0} {1}")
    public static Object[][] getPriceData() {
        return new Object[][]{{10, 10, 30},
                {20, 20, 60}
        };
    }

    @Test
    public void getParametrizedPrice() {
        Bun bun = new Bun("white", ingridientPrice);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "filling", ingridientPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float fullPrice = expectedPrice;
        assertEquals(fullPrice, burger.getPrice(), 0);
    }
}
