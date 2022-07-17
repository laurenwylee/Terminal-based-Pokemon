public interface Types {
  public int getHP();
  public int getAttack();
  public int getDefense();
  public int getMana();
  public boolean isAlive();
  public void display();
  public void move(String moveName, Fire name, String type);
  public void move(String moveName, Water name, String type);
  public void move(String moveName, Grass name, String type);
}
