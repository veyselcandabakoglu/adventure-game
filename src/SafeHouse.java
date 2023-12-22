public class SafeHouse extends NormalLoc{
    
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getOriginalHealth());
        System.out.println("SAĞLIĞINIZ YENİLENDİ !!");
        System.out.println("ŞU AN GÜVENLİ EVDESİNİZ !!");
        return true;
    }
}
