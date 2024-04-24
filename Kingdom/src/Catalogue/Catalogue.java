package Catalogue;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue
{
  private File catalogueFile;
  private static Catalogue instance;
  private static Lock lock = new ReentrantLock();

  private Catalogue()
  {
    catalogueFile = new File("CataLogueFile.txt");
  }

  public static Catalogue getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Catalogue();
        }
      }
    }
    return instance;
  }

  public void log(String txt)
  {
    try
    {
      Writer out = new BufferedWriter(new FileWriter(catalogueFile, true));
      out.append(txt);
      out.flush();
      out.close();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

}
