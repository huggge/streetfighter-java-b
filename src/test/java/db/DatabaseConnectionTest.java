package db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    public void checkDataBaseConnectionNotNull() {

        // Lägg till mockito test? lr assertThrow test
        DatabaseConnection dbconn = DatabaseConnection.getInstance();
        assertNotNull(dbconn);
    }

}