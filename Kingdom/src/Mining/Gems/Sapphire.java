package Mining.Gems;

public class Sapphire implements Gem
{
  private String name;
  private int value;

  public Sapphire()
  {
    this.name = "Sapphire";
    this.value = 1000;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getValue() {
    return value;
  }
}
