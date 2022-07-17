import java.util.*;

public class Water extends Pokemon implements Types{

  String _name;
  int _hp;
  int _attack;
  int _defense;
  int _mana;

  public Water(String name, int lvl, int exp){
    _hp = 7;
    _attack = 7;
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

  // FIRE
  public void move(String moveName, Fire name, String type){
    // Water Gun
    if(moveName.equals("Water Gun") || moveName.equals("water gun")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 25;
        name._hp = (int)((name.getHP() + name.getDefense()) - (0.5 * getAttack()));
        System.out.println(name + " has casted Water Gun!");
        if(name.isAlive() == false){
          System.out.println("You have defeated your opponent!");
          increaseExp();
          lvlUp();
        }
      }
      display();
      name.display();
    }
    // Rain Dance
    if(moveName.equals("Rain Dance") || moveName.equals("rain dance")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 20;
        _defense += 10;
        System.out.println("Defense increased by 10!");
      }
      display();
      name.display();
    }
    // Rest
    if(moveName.equals("Rest") || moveName.equals("rest")){
      _mana += 20;
      System.out.println("Mana increased by 20!");
    }
    display();
    name.display();
  }


  // WATER
  public void move(String moveName, Water name, String type){
    // Water Gun
    if(moveName.equals("Water Gun") || moveName.equals("water gun")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 25;
        name._hp = (int)((name.getHP() + name.getDefense()) - (0.4 * getAttack()));
        System.out.println(name + " has casted Water Gun!");
        if(name.isAlive() == false){
          System.out.println("You have defeated your opponent!");
        }
      }
      display();
      name.display();
    }
    // Rain Dance
    if(moveName.equals("Rain Dance") || moveName.equals("rain dance")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 20;
        _defense += 10;
        System.out.println("Defense increased by 10!");
      }
      display();
      name.display();
    }
    // Rest
    if(moveName.equals("Rest") || moveName.equals("rest")){
      _mana += 20;
      System.out.println("Mana increased by 20!");
    }
    display();
    name.display();
  }


  // GRASS
  public void move(String moveName, Grass name, String type){
    // Water Gun
    if(moveName.equals("Water Gun") || moveName.equals("water gun")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 25;
        name._hp = (int)((name.getHP() + name.getDefense()) - (0.3 * getAttack()));
        System.out.println(name + " has casted Water Gun!");
        if(name.isAlive() == false){
          System.out.println("You have defeated your opponent!");
        }
      }
      display();
      name.display();
    }
    // Rain Dance
    if(moveName.equals("Rain Dance") || moveName.equals("rain dance")){
      if(_mana < 20){
        System.out.println("You cannot use " + moveName + ".");
      }
      else{
        _mana = getMana() - 20;
        _defense += 10;
        System.out.println("Defense increased by 10!");
      }
      display();
      name.display();
    }
    // Rest
    if(moveName.equals("Rest") || moveName.equals("rest")){
      _mana += 20;
      System.out.println("Mana increased by 20!");
    }
    display();
    name.display();
  }

}
