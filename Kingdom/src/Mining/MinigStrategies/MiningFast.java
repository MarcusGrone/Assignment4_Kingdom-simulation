package Mining.MinigStrategies;

import Mining.GemMine;
import Mining.Gems.Gem;

import java.util.Random;

public class MiningFast implements MiningStrategies {
  private final GemMine gemMine;

  public MiningFast(GemMine gemMine) {
    this.gemMine = gemMine;
  }

  @Override
  public Gem mineGem() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Random random = new Random();
    int randomIndex = random.nextInt(5);
    switch (randomIndex) {
      case 0:
        return gemMine.getInstance("GoldNugget");
      case 1:
        return gemMine.getInstance("SilverOre");
      case 2:
        return gemMine.getInstance("Sapphire");
      case 3:
        return gemMine.getInstance("Ruby");
      case 4:
        return gemMine.getInstance("Diamond");
      default:
        return null;
    }
  }
}
