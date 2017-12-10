import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @Test
  public void Squad_instantiatesCorrectly_true() {
    Squad testSquad = new Squad("testSquad", "poverty");
    assertEquals(true, testSquad instanceof Squad);
  }

  @Test
  public void Squad_instantiateswithName_testSquad() {
    Squad testSquad = new Squad("testSquad", "poverty");
    assertEquals("testSquad", testSquad.getName());
  }

  @Test
  public void Squad_instantiateswithCause_poverty() {
    Squad testSquad = new Squad("testSquad", "poverty");
    assertEquals("poverty", testSquad.getCause());
  }



  @Test
    public void getId_SquadsInstantiateWithAnId_1() {
     Squad.clear();
     Squad testSquad = new Squad("testSquad", "poverty");
    assertEquals(1, testSquad.getId());
  }

  @Test
  public void find_returnsHedroWithSameId_testSquad2() {
    Squad.clear();
    Squad testSquad = new Squad("testSquad", "poverty");
    Squad testSquad2 = new Squad("testSquad2", "hunger");
    assertEquals(Squad.find(testSquad2.getId()), testSquad2);
  }

  @Test
  public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
    Squad testSquad = new Squad("testSquad", "poverty");
    assertEquals(0, testSquad.getHeroes().size());
  }
  @Test
   public void find_returnsNullWhenNoHeroFound_null() {
     assertTrue(Squad.find(1000) == null);
   }

  @Test

  public void clear_emptiesAllSquadsFromArrayList_0() {
    Squad testSquad = new Squad("testSquad", "poverty");
    Squad.clear();
    assertEquals(0, Squad.all().size());
  }

  @Test
  public void addHero_addsHeroToList_true() {
    Squad testSquad = new Squad("testSquad", "poverty");
    Hero newHero = new Hero("githeriMan", 30, "Super strength", "avocado");
    testSquad.addHero(newHero);
    assertTrue(testSquad.getHeroes().contains(newHero));
  }

}
