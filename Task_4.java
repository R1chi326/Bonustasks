class Spaceship {
    private final String name;
    private final int weaponPower;
    private final int corePower;
    private final int armor;
    private final int shieldCapacity; // Доп. категория деталей для защиты

    public Spaceship(String name, int weaponPower, int corePower, int armor, int shieldCapacity) {
        this.name = name;
        this.weaponPower = weaponPower;
        this.corePower = corePower;
        this.armor = armor;
        this.shieldCapacity = shieldCapacity;
    }

    @Override
    public String toString() {
        return String.format("Spaceship[Name='%s', WeaponPower=%d, CorePower=%d, Armor=%d, Shields=%d]",
                name, weaponPower, corePower, armor, shieldCapacity);
    }
}

class SpaceshipBuilder {
    private String name = "Default Ship";
    private int weaponPower = 0;
    private int corePower = 0;
    private int armor = 0;
    private int shieldCapacity = 0;

    public SpaceshipBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SpaceshipBuilder addWeapons(int power) {
        this.weaponPower += power;
        return this;
    }

    public SpaceshipBuilder setPowerCore(int power) {
        this.corePower = power;
        return this;
    }

    public SpaceshipBuilder setArmor(int armor) {
        this.armor = armor;
        return this;
    }

    // Новая категория деталей, добавленная без изменения валидации оружия/ядра
    public SpaceshipBuilder addShields(int capacity) {
        this.shieldCapacity += capacity;
        return this;
    }

    public Spaceship build() {
        // Правило: суммарная мощность оружия не должна превышать мощность ядра
        if (weaponPower > corePower) {
            throw new IllegalStateException(
                    String.format("Ошибка сборки '%s': Мощность оружия (%d) превышает ядро (%d)!",
                            name, weaponPower, corePower)
            );
        }
        return new Spaceship(name, weaponPower, corePower, armor, shieldCapacity);
    }
}