abstract class Monster {
    private final String name;
    private final int health;
    private final int firePower;

    public Monster(String name, int health, int firePower) {
        this.name = name;
        this.health = health;
        this.firePower = firePower;
    }

    @Override
    public String toString() {
        return String.format("%s [HP=%d, FirePower=%d]", name, health, firePower);
    }
}

class Dragon extends Monster {
    public Dragon(int health, int firePower) {
        super("Dragon", health, firePower);
    }
}

class Slime extends Monster {
    public Slime(int health, int firePower) {
        super("Slime", health, firePower);
    }
}

// Новый тип монстра (добавлен без изменения существующих классов)
class Goblin extends Monster {
    public Goblin(int health, int firePower) {
        super("Goblin", health, firePower);
    }
}

abstract class MonsterCreator {
    protected final Random random = new Random();

    public abstract Monster hatchMonster();
}

class DragonCreator extends MonsterCreator {
    @Override
    public Monster hatchMonster() {
       
        int hp = 150 + random.nextInt(50);
        int fire = 50 + random.nextInt(51);
        return new Dragon(hp, fire);
    }
}

class SlimeCreator extends MonsterCreator {
    @Override
    public Monster hatchMonster() {

        int hp = 20 + random.nextInt(20);
        int fire = random.nextInt(11);
        return new Slime(hp, fire);
    }
}

class GoblinCreator extends MonsterCreator {
    @Override
    public Monster hatchMonster() {
        int hp = 60 + random.nextInt(30);
        int fire = 10 + random.nextInt(15);
        return new Goblin(hp, fire);
    }
}