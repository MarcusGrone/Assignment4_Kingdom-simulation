package Mining.Gems;

public class Diamond implements Gem
{
  private String name;
  private int value;
  public Diamond()
  {
    this.name = "Diamond";
    this.value =15000 ;
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
