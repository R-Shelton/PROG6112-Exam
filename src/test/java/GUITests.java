import org.example.ProductCalculations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUITests {
    private ProductCalculations calcs = new ProductCalculations(1200);

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValues() {
        assertEquals(180, calcs.getVat());
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(1440, calcs.getTotal());
    }
}
