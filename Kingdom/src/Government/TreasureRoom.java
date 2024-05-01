package Government;

import Catalogue.Catalogue;
import Mining.Gems.Gem;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
  private List<Gem> gems;

  public TreasureRoom() {
    gems = new ArrayList<>();
  }

  // access methods

  public synchronized void acquireReadAccess(String actorName) {
    // note in the catalogue a person entered
    Catalogue.enterTreasureRoom(actorName);
  }

  public synchronized void acquireWriteAccess(String actorName) {
    // note in the catalogue a person entered
    Catalogue.enterTreasureRoom(actorName);
  }

  public synchronized void releaseReadAccess(String actorName) {
    // note in the catalogue a person left
    Catalogue.exitTreasureRoom(actorName);
  }

  public synchronized void releaseWriteAccess(String actorName) {
    // note in the catalogue a person left
    Catalogue.exitTreasureRoom(actorName);
  }

  // interact methods

  public Gem retrieveValuable() {
    Gem v = null;
    if (gems.size() > 0) {
      v = gems.remove(0);
    }
    return v;
  }

  public void addValuable(Gem v) {
    gems.add(v);
  }

  @Override
  public List<Gem> lookAtAllGems() {
    return new ArrayList<Gem>(gems);
  }
}

