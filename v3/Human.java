public class Human {
  String _name;
  boolean _gender;
  int _role;

/**
Key:
0 -- pokemon trainer
1 -- gym leader
2 -- nurse
3 -- civilian
4 -- doctor

true -- female
false -- male
**/

  public Human(){
      _gender = true;
      _role = 0;
      _name = "Dawn";
  }

  public Human(boolean gender, int role, String name ){
    _gender = gender;
    _role = role;
    _name = name;
  }

  public boolean getGender(){
    return _gender;
  }

  public String getRole(){
    if (_role == 0) {
      return "Pokemon trainer";
    }
    if (_role == 1) {
      return "gym leader";
    }
    if (_role == 2) {
      return "nurse";
    }
    if (_role == 3) {
      return "citizen of this town";
    }
    else {
      return "doctor";
    }
  }

  public String getName(){
    return _name;
  }

  public void greet(Human name){
    System.out.println("Hello " + name.getName() + ", " + "my name is " + _name + ". I am a " + getRole() + ".");
  }

  public void goodbye(Human name){
    System.out.println("Goodbye" + name.getName() + "! See you next time.");
  }
}
