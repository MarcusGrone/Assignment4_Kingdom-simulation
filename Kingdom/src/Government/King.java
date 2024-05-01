package Government;

import Catalogue.Catalogue;
import Mining.Gems.Gem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King implements Runnable {

  private TreasureRoomDoor treasureRoomDoor;
  private Random random = new Random();

  public King(TreasureRoomDoor treasureRoomDoor) {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override
  public void run() {
    while(true) {
      int totalCostOfParty = random.nextInt(10001) + 1000; // Extended original interval to a higher number
      Catalogue.getInstance().addNewsFromKing("The King wants to throw a party with a budget of " + totalCostOfParty + " gems.");

      treasureRoomDoor.acquireWriteAccess("King");
      int totalValueOfGems = 0;
      List<Gem> gemsToPayForParty = new ArrayList<>();

      while (totalValueOfGems < totalCostOfParty) {
        Gem gem = treasureRoomDoor.retrieveValuable();

        if (gem == null) {
          break;
        }

        gemsToPayForParty.add(gem);
        totalValueOfGems += gem.getValue();
      }

      if (totalValueOfGems < totalCostOfParty) {
        for (Gem gem : gemsToPayForParty) {
          treasureRoomDoor.addValuable(gem);
        }
        Catalogue.addNewsFromKing("The party was cancelled due to lack of funds.");
        treasureRoomDoor.releaseWriteAccess("King");
      } else {
        Catalogue.removeFromTreasureRoom(totalValueOfGems);
        Catalogue.addNewsFromKing("Time for a party! The king is hosting a party with " + gemsToPayForParty.size() + " gems with a total value of " + totalValueOfGems + ".");
        gemsToPayForParty.clear();
        treasureRoomDoor.releaseWriteAccess("King");
      }

      try {
        Thread.sleep(8000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
