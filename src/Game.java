import java.util.Scanner;

public class Game {
    Player player;
    Location location;

    Scanner input = new Scanner(System.in);
    public void login() {
        

        System.out.println("Macera Oyununa Hoşgeldiniz... ");
        System.out.print("Oyuna Başlamadan Önce İsminizi Giriniz : ");
        String playerName = input.nextLine();
        player = new Player(playerName); 
        player.selectChar();
        start();

    }

    public void start() {
       while(true) {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println("LOKASYONLAR ");
        System.out.println("1- GÜVENLİ EV --> SİZE AİT GÜVENLİ BİR YER, DÜŞMAN YOK");
        System.out.println("2- MAĞARA.... --> BURADA KARŞINIZA ZOMBİ ÇIKABİLİR");        
        System.out.println("3- ORMAN..... --> BURADA KARŞINIZA VAMPİR ÇIKABİLİR");
        System.out.println("4- NEHİR..... --> BURADA KARŞINIZA AYI ÇIKABİLİR");
        System.out.println("5- MAĞAZA.... --> SİLAH VEYA ZIRH ALABİLİRSİNİZ");
        System.out.print("LOKASYON SEÇİNİZ : ");
        int selectedLoc = input.nextInt();
        while(selectedLoc < 1 || selectedLoc > 5) {
            System.out.print("LÜTFEN GEÇERLİ BİR LOKASYON SEÇİNİZ : ");
            selectedLoc = input.nextInt();
        }

        switch(selectedLoc) {
            case 1: 
                location = new SafeHouse(player);
                break;
            case 2: 
                location = new Cave(player);
                break;
            case 3:
                location = new Forest(player);
                break;
            case 4:
                location = new River(player);
                break;    
            case 5: 
                location = new ToolStore(player);
                break;    
            default :
                location = new SafeHouse(player);    
        }

        if(location.getClass().getName().equals("SafeHouse")) {
            if(player.getInv().isFood() && player.getInv().isWood() && player.getInv().isWater()) {
                System.out.println("TEBRİKLER OYUNU KAZANDINIZ !!");
                break;
            }
        }

        if(!location.getLocation()) {
            System.out.println("OYUN BİTTİ !!");
            break;
        }
       }

    }
}
