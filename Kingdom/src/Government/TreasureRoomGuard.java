package Government;

import Catalogue.Catalogue;
import Mining.Gems.Gem;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class TreasureRoomGuard implements TreasureRoomDoor
{
  private TreasureRoom treasureRoom; // This is the treasure room that the guard is guarding

  private Queue<Thread> queue;
  private int readers;
  private int writers;


  public TreasureRoomGuard(TreasureRoom treasureRoom) {
    this.treasureRoom = treasureRoom;

    queue = new ArrayDeque<>();
    readers = 0;
    writers = 0;
  }

  @Override
  public synchronized void acquireReadAccess(String actorName) {
    queue.offer(Thread.currentThread()); // Add the current thread to the queue
    Catalogue.addToWaitingLine(actorName);

    while (queue.peek() != Thread.currentThread() || writers > 0) {
      try {
        wait(); // Wait until it is the current thread's turn
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        Catalogue.removeFromWaitingLine(actorName);
        return;
      }
    }

    readers++;
    queue.poll();
    treasureRoom.acquireReadAccess(actorName);

    notifyAll();
  }

  @Override
  public synchronized void acquireWriteAccess(String actorName) {
    if (actorName.contains("Transporter") || actorName.contains("King")) {
      queue.offer(Thread.currentThread()); // Add the current thread to the queue
      Catalogue.addToWaitingLine(actorName);

      while (queue.peek() != Thread.currentThread() || readers > 0 || writers > 0) {
        try {
          wait(); // Wait until it is the current thread's turn
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          Catalogue.removeFromWaitingLine(actorName);
          return;
        }
      }

      writers++;
      queue.poll();
      treasureRoom.acquireWriteAccess(actorName);

      notifyAll();
    } else {
      Catalogue.actorDeniedAccess(actorName);
    }
  }

  @Override
  public synchronized void releaseReadAccess(String actorName) {
    readers--;
    treasureRoom.releaseReadAccess(actorName);

    if (readers == 0) {
      notifyAll();
    }
  }

  @Override
  public synchronized void releaseWriteAccess(String actorName) {
    writers--;
    treasureRoom.releaseWriteAccess(actorName);

    notifyAll();
  }

  @Override
  public Gem retrieveValuable() {
    Gem gemToRetrieve = treasureRoom.retrieveValuable();
    return gemToRetrieve;
  }

  @Override
  public void addValuable(Gem v) {
    treasureRoom.addValuable(v);
  }

  @Override
  public List<Gem> lookAtAllGems() {
    return treasureRoom.lookAtAllGems();
  }
}
