import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class IngredientTest {
    List<String> expectedIngredientType = List.of("Начинка", "Соус");
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "name", 300);
    }

    @Description("Проверяем, что метод getPrice возвращает правильную цену ингридиента")
    @Test
    public void ingredientGetPriceTest() {
        float expectedResult = 300;
        assertEquals(expectedResult, ingredient.getPrice(),0);
    }

    @Description("Проверяем, что метод getName возвращает правильное название ингридиента")
    @Test
    public void ingredientGetNameTest() {
        assertEquals("name", ingredient.getName());
    }

    @Description("Проверяем, что метод getType возвращает правильный тип ингридиента")
    @Test
    public void ingredientGetTypeTest() throws Exception {
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
