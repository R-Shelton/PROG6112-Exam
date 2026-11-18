import org.example.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTests {
    private Product product = new Product();

    @BeforeEach
    public void initialize() {
        // Dummy data for the tests, the same as the example provided
        product.setCompanies(new String[] {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
        product.setSalesOverMonths(new int[][] {
                {25, 18, 20},
                {15, 10, 12},
                {18, 15, 20}
        });

        product.calculateValues();
    }

    @Test
    public void getTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, product.getTotalProductsSold());
    }


    @Test
    public void getAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17, product.getAverageProductSold());
    }
}
