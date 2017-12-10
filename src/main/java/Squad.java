import java.util.List;
import java.util.ArrayList;

public class Squad {
  private String mName;
  private String mCause;
  private int mId;
  private List<Hero> mHeroes;
  private static List<Squad> instances = new ArrayList<Squad>();

  public Squad(String name, String cause) {
    mName = name;
    mCause = cause;
    instances.add(this);
    mId = instances.size();
    mHeroes = new ArrayList<Hero>();
  }

  public String getName() {
    return mName;
  }

  public String getCause() {
    return mCause;
  }


  public static List<Squad> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Squad find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public List<Hero> getHeroes() {
    return mHeroes;
  }

  public void addHero(Hero hero) {
    mHeroes.add(hero);
  }
}

