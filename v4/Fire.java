import java.util.*;

public class Fire extends Pokemon implements Types{

  String _name;
  int _hp;
  int _attack;
  int _defense;
  int _mana;

  public Fire(String name, int lvl, int exp){
    _hp = 7;
    _attack = 8;
    _defense = 7;
    _mana = 10;
    _name = name;
    _lvl = lvl;
    _exp = exp;
  }

  public int getHP(){
    _hp = _hp * _lvl;
    return _hp;
  }

  public int getAttack(){
    _attack = _attack * _lvl;
    return _attack;
  }

  public int getDefense(){
    _defense = _defense * _lvl;
    return _defense;
  }

  public int getMana(){
    _mana = _mana * _lvl;
    return _mana;
  }

  public boolean isAlive(){
    return _hp >= (7 * _lvl);
  }

  public void display(){
    System.out.println(_name + " / Stats:");
    System.out.println("HP: " + _hp);
    System.out.println("Attack: " + _attack);
    System.out.println("Defense:" + _defense);
    System.out.println("Mana: " + _mana);
  }

  public void displayMove() {
    System.out.println("Your available moves are: Ember, Bulk Up, and Restore.");
    System.out.println("Ember deals damage and inflicts Burn.");
    System.out.println("Bulk Up bulks up your defense.");
    System.out.println("Restore restores your mana.");
  }

  // FIRE
  public void move(String moveName, Pokemon name){
    // Ember
    if(moveName.equals("Ember") || moveName.equals("ember")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 25;
        name._hp = (int)((name.getHP() + name.getDefense()) - (0.4 * getAttack()));
        System.out.println(name + " has casted Ember!");
        System.out.println("The target is attacked with small flames.");
        if(name.isAlive() == false){
          System.out.println("You have defeated your opponent!");
          increaseExp();
          lvlUp();
        }
      }
      display();
      name.display();
    }
    // Bulk Up
    if(moveName.equals("Bulk Up") || moveName.equals("bulk up")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 20;
        _defense += 10;
        System.out.println(name._name + " tenses its muscles.");
        System.out.println("Defense increased by 10!");
      }
      display();
      name.display();
    }
    // Restore
    if(moveName.equals("Restore") || moveName.equals("restore")){
      _mana += 20;
      System.out.println(name._name + " restores its own cells.");
      System.out.println("Mana increased by 20!");
    }
    display();
    name.display();
  }

}
