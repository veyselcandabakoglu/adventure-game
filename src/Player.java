import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inv;
    private int originalHealth;

    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChar() {
       switch(charMenu()) {
        case 1:
            initPlayer("Samuray", 5, 21, 15);
            break;
        case 2:
            initPlayer("Okçu", 7, 18, 20);
            break;
        case 3:
            initPlayer("Şovalye", 8, 24, 5);
            break; 
        default:
            initPlayer("Samuray", 5, 21, 15);
            break;             
       }
       System.out.println("SEÇTİĞİNİZ KARAKTER : "+ this.getCharName()+"\tHASAR : "+this.getDamage()+"\tSAĞLIK : "+this.getHealth()+"\tPARA : "+this.getMoney());
    }

    public int charMenu() {
        System.out.println("Lütfen Bir Karakter Seçiniz : ");
        System.out.println("1- Adı: Samuray , Hasar : 5, Sağlık : 21, Para : 15");
        System.out.println("2- Adı: Okçu... , Hasar : 7, Sağlık : 18, Para : 20");
        System.out.println("3- Adı: Şovalye , Hasar : 8, Sağlık : 24, Para : 5");
        System.out.println();
        System.out.print("Karakter Seçiminiz : ");
        int selectedChar = input.nextInt();

        while(selectedChar < 1 || selectedChar > 3) {
            System.out.print("Lütfen Geçerli Bir Karakter Numarası Giriniz : ");
            selectedChar = input.nextInt();
        }

        return selectedChar;
    }

    public int getTotalDamage() {
        return this.getDamage()+ this.getInv().getDamage();
    }

    public void initPlayer(String cName, int dmg, int hlt, int mny) {
        setCharName(cName);
            setDamage(dmg);
            setHealth(hlt);
            setMoney(mny);
            setOriginalHealth(hlt);
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCharName() {
        return charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }
    public Inventory getInv() {
        return inv;
    }
    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getOriginalHealth() {
        return this.originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    
}
