package Question2;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class Solution2Test {

    @org.junit.Test
    public void checkOption(){

        Solution2 st = new Solution2();
        assertEquals(true, st.checkChoice(5));
    }

    @Test void checkCourses(){

        Solution2 st = new Solution2();
        String str = "ABEF";        //courses after character removal
        char[] courses = str.toCharArray();
        assertEquals(true,st.correctCourse(courses));
    }
}
