public abstract class BattleLoc extends Location{
    protected Monster monster;
    protected String awardItem;

    public BattleLoc(Player player, String name, Monster monster, String awardItem) {
        super(player);
        this.name = name;
        this.monster = monster;
        this.awardItem = awardItem;
    }

    public boolean getLocation() {
        int count = monster.monsterCount();
        System.out.println("ŞU AN "+ this.getName()+" LOKASYONUNDASINIZ.");
        System.out.println(count+ " TANE "+ this.monster.getName()+" VAR");
        System.out.print("SAVAŞMAK İÇİN <S> | KAÇMAK İÇİN <K> GİRİN : ");
        String selected  = input.nextLine().toUpperCase();
        System.out.print("selected : "+selected);
        if(selected.equals("S")) {
            System.out.println("\nSAVAŞ SEÇİLDİ");
            if(combat(count)) {
                System.out.println(this.getName()+ " BÖLGESİNDEKİ TÜM DÜŞMANLARI YENDİNİZ !");
                
                System.out.println("GÜNCEL PARANIZ : "+player.getMoney());
                if(this.awardItem.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println(this.awardItem+ " KAZANDINIZ!!!!");
                    player.getInv().setFood(true);
                } else  if(this.awardItem.equals("Water") && player.getInv().isWater() == false) {
                    System.out.println(this.awardItem+ " KAZANDINIZ!!!!");
                    player.getInv().setWater(true);
                } else  if(this.awardItem.equals("Fire Wood") && player.getInv().isWood() == false) {
                    System.out.println(this.awardItem+ " KAZANDINIZ!!!!");
                    player.getInv().setWood(true);
                }
                return true;
            } else {
                System.out.println("ÖLDÜNÜZ !!!!!!!");
                return false;
            }
        } else if(selected.equals("K")) {
            System.out.println("\nKAÇTINIZ");
            return true;
        } 
        return true;
    }
    
    public boolean combat(int obstacleNumber) {
        for(int i = 1 ; i <= obstacleNumber; i++) {
            this.monster.setHealth(this.monster.getOriginalHealth());
            playerStats();
            enemyStats(i);
            while(this.getPlayer().getHealth() > 0 && this.monster.getHealth() > 0) {
                System.out.print("<V>ur Veya <K>aç : ");
                String selectCase = input.nextLine().toUpperCase();
                if(selectCase.equals("V")) {
                    System.out.println("SİZ VURDUNUZ ! ");
                    this.monster.setHealth(this.monster.getHealth() - this.getPlayer().getDamage());
                    afterHit();

                    if(this.monster.getHealth() > 0) {
                        System.out.println();
                        System.out.println("CANAVAR SİZE VURDU !");
                        int obstacleDamage = this.monster.getDamage() -  this.getPlayer().getInv().getAvoid();
                        if(obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    } else {
                        System.out.println("CANAVAR ÖLDÜ");
                        player.setMoney(player.getMoney()+monster.getAward());
                        //System.out.println("GÜNCEL PARANIZ : "+player.getMoney());
                    }
                } else {
                    break;
                }
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("----------------OYUNCU DEĞERLERİ------------");
        System.out.println("SAĞLIK : "+player.getHealth());
        System.out.println("HASAR : "+player.getTotalDamage());
        System.out.println("PARA : "+ player.getMoney());

        if(player.getInv().getDamage() > 0) {
            System.out.println("SİLAHINIZ : "+ player.getInv().getWeapon());
        }

        if(player.getInv().getAvoid() > 0) {
            System.out.println("ZIRHINIZ : "+ player.getInv().getArmour());
        }
    }

    public void enemyStats(int i) {
        System.out.println("----------------"+i+ ". "+monster.getName().toUpperCase()+ " DEĞERLERİ------------");
        System.out.println("SAĞLIK : "+ monster.getHealth());
        System.out.println("HASAR : "+monster.getDamage());
        System.out.println("ÖDÜL : "+ monster.getAward());

    }

    public void afterHit() {
        System.out.println("OYUNCUNUN SAĞLIĞI : "+player.getHealth());
        System.out.println("CANAVARIN SAĞLIĞI : "+monster.getHealth());
    }
    


}
