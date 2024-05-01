package Government;


import Catalogue.Catalogue;
import Mining.Gems.Gem;

import java.util.List;

public class Accountant implements Runnable {
  private TreasureRoomDoor treasureRoomDoor;
  private String name;

  public Accountant(int id, TreasureRoomDoor treasureRoomDoor) {
    this.name = "Accountant " + id;
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override
  public void run() {
    while(true) {
      treasureRoomDoor.acquireReadAccess(name);

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      List<Gem> gemsInTreasureRoom = treasureRoomDoor.lookAtAllGems();
      int totalValue = 0;

      for (Gem gem : gemsInTreasureRoom) {
        totalValue += gem.getValue();
      }

      Catalogue.documentTreasureRoomsTotalValue(totalValue);
      treasureRoomDoor.releaseReadAccess(name);

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
