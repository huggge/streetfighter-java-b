package tournament;

import fighters.Fighter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MatchTest {

    @Spy
    Match match;

    Fighter fighterOne;
    Fighter fighterTwo;

    @BeforeEach
    void initMatchTest() {
        fighterOne = new Fighter("Lars", "haha", 33, 44, 55, 6);
        fighterTwo = new Fighter("Tommy", "hihi", 99, 22, 12, 7);
        match = spy(new Match(fighterOne, fighterTwo));
    }

    @Test
    void getWinnerAfterMatchIsNotNull() {
        doNothing().when(match).startNextRound();
        match.startMatch();
        Fighter winner = match.getWinner();
        assertNotNull(winner);
    }

    @Test
    void getWinnerBeforeMatchIsNull() {
        Fighter winner = match.getWinner();
        assertNull(winner);
    }

    @Test
    void winnersHPBackTo100() {
        doNothing().when(match).startNextRound();
        match.startMatch();
        Fighter winner = match.getWinner();
        assertEquals(100, winner.getHealth());
    }
}
