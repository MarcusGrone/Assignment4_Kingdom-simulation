package Mining.Gems;

public class Diamond implements Gem
{
  @Override public String getName()
  {
      return "Diamond";
  }

  @Override public int getValue()
  {
    return 15000;
  }
}
