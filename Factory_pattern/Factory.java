package design_patterns;

//Product Interface
interface Weapon {
 void attack();
}

//Concrete Products
class Sword implements Weapon {
 public void attack() {
     System.out.println("Swinging a sword!");
 }
}

class Bow implements Weapon {
 public void attack() {
     System.out.println("Shooting an arrow!");
 }
}

class Gun implements Weapon {
 public void attack() {
     System.out.println("Firing a gun!");
 }
}

//Creator (Abstract Factory)
abstract class WeaponFactory {
 public abstract Weapon createWeapon();
}

//Concrete Factories
class WarriorFactory extends WeaponFactory {
 public Weapon createWeapon() {
     return new Sword();
 }
}

class ArcherFactory extends WeaponFactory {
 public Weapon createWeapon() {
     return new Bow();
 }
}

class SoldierFactory extends WeaponFactory {
 public Weapon createWeapon() {
     return new Gun();
 }
}

//Client
public class Factory {
 public static void main(String[] args) {
     WeaponFactory factory = new ArcherFactory();  // Could also be WarriorFactory or SoldierFactory
     Weapon weapon = factory.createWeapon();
     weapon.attack();
 }
}
