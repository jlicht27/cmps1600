import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BallotTests {

  Ballot b = new Ballot("Coolest Person Award");
  Candidate j = new Candidate("Jonathan", "RI");
  Candidate f = new Candidate("Forrest", "CA");
  Candidate l = new Candidate("Luke", "OR");

  @BeforeEach
  public void setUp() {

  }

  @Test
  public void testGetOfficeName() {
    assertEquals("Coolest Person Award", b.getOfficeName());
  }

  @Test
  public void testAddCandidate() {
    b.addCandidate(j);
    b.addCandidate(f);
    b.addCandidate(l);
    assertEquals("Jonathan - RI", b.getCandidates().get(0).toString());
    assertEquals("Forrest - CA", b.getCandidates().get(1).toString());
    assertEquals("Luke - OR", b.getCandidates().get(2).toString());
  }

  @Test
  public void testGetCandidates() {
    b.addCandidate(j);
    b.addCandidate(f);
    b.addCandidate(l);
    String result = "";
    for (Candidate c : b.getCandidates()) {
      result += c.toString() + " ";
    }
    assertEquals("Jonathan - RI Forrest - CA Luke - OR ", result);
  }
}
