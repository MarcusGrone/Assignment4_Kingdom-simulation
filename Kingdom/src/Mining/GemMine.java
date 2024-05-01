package Mining;

import Mining.Gems.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GemMine
{
  private static GemMine instance;
  private static final Map<String, Gem> gemInstances = new HashMap<>();

  private GemMine()
  {
  }

  public static GemMine getInstance()
  {
    if (instance == null)
    {
      instance = new GemMine();
    }

    return instance;
  }

  public static Gem getGem(String gemType)
  {
    Gem gem = gemInstances.get(gemType);
    if (gem == null)
    {
      switch (gemType)
      {
        case "GoldNugget":
          gem = new GoldNugget();
          break;
        case "SilverOre":
          gem = new SilverOre();
          break;
        case "Sapphire":
          gem = new Sapphire();
          break;
        case "Ruby":
          gem = new Ruby();
          break;
        case "Diamond":
          gem = new Diamond();
          break;
        default:
          throw new IllegalArgumentException("Invalid gem type: " + gemType);
      }
      gemInstances.put(gemType, gem);
    }
    return gem;
  }

  public static Gem getGem()
  {
    return getRandomGem();
  }

  private static Gem getRandomGem()
  {
    String[] gemTypes = {"GoldNugget", "SilverOre", "Sapphire", "Ruby",
        "Diamond"};
    Random random = new Random();
    int randomIndex = random.nextInt(gemTypes.length);
    String randomGemType = gemTypes[randomIndex];
    return getGem(randomGemType);

  }
}
