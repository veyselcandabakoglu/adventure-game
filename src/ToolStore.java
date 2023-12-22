public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean getLocation() {
        System.out.println("MAĞAZADASINIZ. PARA : "+player.getMoney());
        System.out.println("1- SİLAHLAR");
        System.out.println("2- ZIRHLAR");
        System.out.println("3- ÇIKIŞ YAP");
        System.out.println();
        System.out.print("SEÇİMİNİZ : ");
        int selectedTool = input.nextInt();

        int selItemId;
        switch(selectedTool) {
            case 1:
                System.out.println("---------------------SİLAHLAR MENÜSÜ-------------------------------"); 
                selItemId = weaponMenu();
                buyWeapon(selItemId);
                break;
            case 2:
                System.out.println("---------------------ZIRHLAR MENÜSÜ-------------------------------");
                selItemId = armourMenu();
                buyArmour(selItemId);
                break;
            default: 
                break;        
        }
        return true;
    }

    public int weaponMenu() {
        System.out.println("1- TABANCA \tHASAR : 2 \tPARA : 25");
        System.out.println("2- KILIÇ.. \tHASAR : 3 \tPARA : 35");
        System.out.println("3- TÜFEK.. \tHASAR : 7 \tPARA : 45");
        System.out.println("4- ÇIKIŞ YAP");
        System.out.print("SEÇİMİNİZ : ");
        int selectedWeapon = input.nextInt();

        return selectedWeapon;
    }

    public void buyWeapon(int itemId) {
        int damage = 0;
        int prize = 0;
        String weaponName = null;

       
            switch(itemId) {
                case 1: 
                    damage = 2;
                    weaponName = "Tabanca";
                    prize = 25;
                    break;
                case 2: 
                    damage = 3;
                    weaponName = "Kılıç";
                    prize = 35;
                    break;
                case 3: 
                    damage = 7;
                    weaponName = "Tüfek";
                    prize = 45;
                    break;
                case 4: 
                    System.out.println("Çıkış Yapıldı!");  
                    break;  
                default:
                    System.out.println("GEÇERSİZ İŞLEM !");            
            }
            
            if(prize > 0) {
                if(player.getMoney() >= prize) {
                player.getInv().setDamage(damage);
                player.getInv().setWeapon(weaponName);
                player.setMoney(player.getMoney() - prize); 
                System.out.println(weaponName+" SİLAHINI SATIN ALDINIZ. ESKİ HASAR : " + player.getDamage());
                System.out.println("YENİ HASAR : "+ player.getTotalDamage());
                System.out.println("KALAN PARA : "+player.getMoney());
        } else {
                System.out.println("PARANIZ YETERSİZ !");
        }
            }
    
    }

    public int armourMenu() {
        System.out.println("1- HAFİF \tENGELLEME : 1 \tPARA : 15");
        System.out.println("2- ORTA. \tENGELLEME : 3 \tPARA : 25");
        System.out.println("3- AĞIR. \tENGELLEME : 5 \tPARA : 40");
        System.out.println("4- ÇIKIŞ YAP");
        System.out.print("SEÇİMİNİZ : ");
        int selectedArmour = input.nextInt();

        return selectedArmour;
    }
    
    public void buyArmour(int itemId) {
        int avoid = 0;
        int prize = 0;
        String avoidName = null;

       
            switch(itemId) {
                case 1: 
                    avoid = 1;
                    avoidName = "Hafif";
                    prize = 15;
                    break;
                case 2: 
                    avoid = 3;
                    avoidName = "Orta";
                    prize = 25;
                    break;
                case 3: 
                    avoid = 5;
                    avoidName = "Ağır";
                    prize = 40;
                    break;
                case 4: 
                    System.out.println("Çıkış Yapıldı!");  
                    break;  
                default:
                    System.out.println("GEÇERSİZ İŞLEM !");            
            }
            
            if(prize > 0) {
                if(player.getMoney() >= prize) {
                player.getInv().setAvoid(avoid);
                player.getInv().setArmour(avoidName);
                player.setMoney(player.getMoney() - prize); 
                System.out.println(avoidName+" ZIRH SATIN ALDINIZ. ENGELLEME : " + player.getInv().getAvoid());
                System.out.println("KALAN PARA : "+player.getMoney());
        } else {
                System.out.println("PARANIZ YETERSİZ !");
        }
            }
    }

}
