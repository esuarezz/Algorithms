import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class KComplementaryTest {

    private KComplementary kComplementary;

    @Before
    public void init(){
         kComplementary = new KComplementary();
    }


    @Test
    public void getKcomplementaries() throws Exception {
        int[] testArray = {1,3,2,5,11,12,13,20,23};
        int[] testArray2 = {15,1,7,5,25,3,6,9,2,4};
        int[] testArrayEmtpy = {};

         kComplementary = new KComplementary();

        assertEquals(1,kComplementary.getKcomplementaries(testArray,7));
        assertEquals(3,kComplementary.getKcomplementaries(testArray2,9));
        assertEquals(0,kComplementary.getKcomplementaries(testArrayEmtpy,9));


        //Test efficiency

        int[] testArrayEfficiency = {15,1,7,5,25,3,6,9,2,4,56,5,6,448,46,5,12,9,78,45,65,566556,31,45,84,71,156,819,15,156,849,
        864,456,123,846,123,546,13254,351432,21321,231,54,867};


        long startTime = System.nanoTime();
        assertEquals(3,kComplementary.getKcomplementaries(testArray2,9));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);


        long startTimeElegant = System.nanoTime();
        assertEquals(3,kComplementary.getKcomplementariesElegant(testArray2,9));
        long endTimeElegant = System.nanoTime();

        long durationElegant = (endTimeElegant - startTimeElegant);


        assertTrue(duration<durationElegant);



    }

}