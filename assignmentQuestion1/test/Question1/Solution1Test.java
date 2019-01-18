package Question1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {


    @Test // test to check item type
    public void checkItemType(){

        Solution1 inv = new Solution1();
        assertEquals(true, inv.correctItemType("imported"));

    }

    @Test// test to check tax
    public void checkTax(){

        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(12.50, taxCalculator.calculate_tax("raw", 100));
    }

}