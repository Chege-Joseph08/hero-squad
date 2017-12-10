import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero newHero = new Hero("githeriMan", 30, "Super strength", "avocado");
    assertEquals(true, newHero instanceof Hero);
  }

  @Test

  public void Hero_instantiateswithName_githeriMan() {
    Hero newHero = new Hero("githeriMan", 30, "Super strength", "avocado");
    assertEquals("githeriMan", newHero.getName());
  }

  @Test
  public void Hero_instantiateswithAge_30() {
    Hero newHero = new Hero("githeriMan", 30, "Super strength", "avocado");
    assertEquals(30, newHero.getAge());
  }

  @Test
  public void all_returnsAllInstancesOfHero_true() {
    Hero Hero1 = new Hero("githeriMan", 30, "Super strength", "avocado");
    Hero Hero2  = new Hero("tazerFace", 55, "Super speed", "puppies");
    assertEquals(true, Hero.all().contains(Hero1));
    assertEquals(true, Hero.all().contains(Hero2));
  }

  @Test
  public void clear_emptiesAllHeroesFromArrayList_0() {
    Hero Hero1 = new Hero("githeriMan", 30, "Super strength", "avocado");
    Hero.clear();
    assertEquals(Hero.all().size(), 0);
  }

  @Test
  public void getId_HeroInstantiateWithAnID_1() {
    Hero.clear();
    Hero hero = new Hero("githeriMan", 30, "Super strength", "avocado");
    assertEquals(1, hero.getId());
  }

  @Test
  public void find_returnsHeroWithSameId_Hero2() {
    Hero Hero1 = new Hero("githeriMan", 30, "Super strength", "avocado");
    Hero Hero2  = new Hero("tazerFace", 55, "Super speed", "puppies");
  assertEquals(Hero.find(Hero2.getId()), Hero2);
}
}
