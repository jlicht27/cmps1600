import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CandidateTests {

  Candidate j = new Candidate("Jonathan", "RI");
  Candidate f = new Candidate("Forrest", "CA");

  @BeforeEach
  public void setUp(){

  }

  @Test
  public void testCreateCandidate() {
    assertNotNull(new Candidate("Jonathan", "RI"));
  }

  @Test
  public void testGetName(){
    assertEquals("Jonathan", j.getName());
  }

  @Test
  public void testGetAffiliation(){
    assertEquals("RI", j.getAffiliation());
  }

  @Test
  public void testTallyVote(){
    j.tallyVote();
    assertEquals(1, j.getVoteCount());
    j.tallyVote();
    assertEquals(2, j.getVoteCount());
  }

  @Test
  public void testGetVoteCount(){
    assertEquals(0, j.getVoteCount());
    j.tallyVote();
    assertEquals(1, j.getVoteCount());
    for(int i = 0; i < 499; i++) {
      j.tallyVote();
    }
    assertEquals(500, j.getVoteCount());
  }

  @Test
  public void testToString(){
    assertEquals("Jonathan - RI", j.toString());
  }

  @Test
  public void testCompareNumVotes(){
    assertEquals(0, j.compareNumVotes(f));
    for(int k = 0; k < 500; k++){
      j.tallyVote();
    }
    assertEquals(500, j.compareNumVotes(f));
  }
}
