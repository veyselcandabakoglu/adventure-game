public class Inventory {
    private boolean food;
    private boolean wood;
    private boolean water;
    private String weapon;
    private String armour;
    private int damage;
    private int avoid;

    public Inventory() {
        this.food = false;
        this.wood = false;
        this.water = false;
        this.damage = 0;
        this.avoid = 0;
        this.weapon = null;
        this.armour = null;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmour() {
        return armour;
    }

    public void setArmour(String armour) {
        this.armour = armour;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAvoid() {
        return this.avoid;
    }

    public void setAvoid(int avoid) {
        this.avoid = avoid;
    }

    
}
