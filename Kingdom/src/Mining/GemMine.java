package Mining;

import Mining.Gems.*;

import java.util.HashMap;
import java.util.Map;

public class GemMine {
  private static final Map<String, Gem> gemInstances = new HashMap<>();

  private GemMine() {
  }

  public static Gem getInstance(String gemType) {
    Gem gem = gemInstances.get(gemType);
    if (gem == null) {
      switch (gemType) {
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
}
