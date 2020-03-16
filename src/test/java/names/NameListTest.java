package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameListTest {

    @Test
    void testToString() {
        NameList nameList = new NameList("Hugo", "Vestberg", "male", "Europe");
        String result = nameList.toString();
        assertEquals("Hugo Vestberg", result);
    }
}