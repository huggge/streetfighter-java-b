package fighters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    Fighter fighter;

    @BeforeEach
    public void initEach() {
        System.out.println("Before every test.");
        fighter = new Fighter("Lasse", "I am a beast!", 13, 33, 44, 5);
    }

    @Test
    public void getName() {
        String result = fighter.getName();
        assertEquals("Lasse", result);
    }

    @Test
    void getMotto() {
        String result = fighter.getMotto();
        assertEquals("I am a beast!", result);

    }

    @Test
    void getHealth() {
        int result = fighter.getHealth();
        assertEquals(100, result);
    }

    @Test
    void setHealth() {
        int result = 13;
        fighter.setHealth(result);
        assertEquals(13, result);
    }

    @Test
    void testToString() {
        String result = "Lasse med mottot: I am a beast!!";
        assertEquals(fighter.toString(), result);
    }

}
