import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @Test
  public void Squad_instantiatesCorrectly_true() {
    Squad testSquad = new Squad("testSquad", "Yoga");
    assertEquals(true, testSquad instanceof Squad);
  }

  @Test
  public void Squad_instantiateswithName_testSquad() {
    Squad testSquad = new Squad("testSquad", "Yoga");
    assertEquals("testSquad", testSquad.getName());
  }

  @Test
  public void Squad_instantiateswithReason_poverty() {
    Squad testSquad = new Squad("testSquad", "Yoga");
    assertEquals("Yoga", testSquad.getCause());
  }

  @Test
    public void getId_SquadsInstantiateWithAnId_1() {
     Squad.clear();
     Squad testSquad = new Squad("testSquad", "Yoga");
    assertEquals(1, testSquad.getId());
  }

  
  }