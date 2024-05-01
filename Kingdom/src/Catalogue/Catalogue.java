package Catalogue;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue
{
  private static Catalogue instance;
  private static ArrayList<String> miningLogs; // log of mining
  private static ArrayList<String> treasureRoomValueLog; // log of treasure room
  private static ArrayList<String> treasureRoomActivityLog; // log of treasure room
  private static ArrayList<String> newsFromTheKing; // items to enter in treasure room
  private static ArrayList<String> waitingLine; // waiting line for treasure room

  private Catalogue()
  {
    miningLogs = new ArrayList<>();
    treasureRoomValueLog = new ArrayList<>();
    newsFromTheKing = new ArrayList<>();
    treasureRoomActivityLog = new ArrayList<>();
    waitingLine = new ArrayList<>();
  }

  public static Catalogue getInstance()
  {
    if (instance == null)
    {
      instance = new Catalogue();
    }
    return instance;
  }

  // Mining logs
  public static void addToMiningLogs(String logToAdd)
  {
    miningLogs.add(logToAdd);
    System.out.println("Mining logs: " + logToAdd);
  }

  // TreasureRoomValueLog
  public static void addToTreasureRoom(int totalValueAdded)
  {
    treasureRoomValueLog.add("Added " + totalValueAdded + " to treasure room.");
    System.out.println(
        "TREASURE ROOM VALUE: Added " + totalValueAdded + " to treasure room.");
  }

  public static void removeFromTreasureRoom(int totalValueRemoved)
  {
    treasureRoomValueLog.remove(
        "Removed " + totalValueRemoved + " from treasure room.");
    System.out.println("TREASURE ROOM VALUE: Removed " + totalValueRemoved
        + " from treasure room.");
  }

  // Documents all activities in the treasure room
  public static void enterTreasureRoom(String actorName)
  {
    Date date = new Date();
    treasureRoomActivityLog.add(
        date + "//" + actorName + " entered the treasure room.");
    System.out.println("TREASURE ROOM " + date + "// " + actorName
        + " entered the treasure room.");
  }

  public static void exitTreasureRoom(String actorName)
  {
    Date date = new Date();
    treasureRoomActivityLog.add(
        date + "//" + actorName + " exited the treasure room.");
    System.out.println("TREASURE ROOM " + date + "// " + actorName
        + " exited the treasure room.");
  }

  public static void actorDeniedAccess(String actorName)
  {
    Date date = new Date();
    treasureRoomActivityLog.add(
        date + "//" + actorName + " was denied access to the treasure room.");
    System.out.println("TREASURE ROOM " + date + "// " + actorName
        + " was denied access to the treasure room.");
  }

  public static void documentTreasureRoomsTotalValue(int totalValue)
  {
    Date date = new Date();
    treasureRoomActivityLog.add(
        "The current value of the treasure room is: " + totalValue);
    System.out.println("TREASURE ROOM: " + date
        + " Accountant counted total value of treasure room: " + totalValue);
  }

  public static void addNewsFromKing(String news)
  {
    newsFromTheKing.add(news);
    System.out.println("NEWS FROM THE KING: " + news);
  }

  // Waiting line acitivity

  public static void addToWaitingLine(String actorName)
  {
    waitingLine.add(actorName);
    System.out.println(actorName + " added to waiting line.");
  }

  public static void removeFromWaitingLine(String actorName)
  {
    waitingLine.remove(actorName);
    System.out.println(actorName + " removed from waiting line.");
  }
}
