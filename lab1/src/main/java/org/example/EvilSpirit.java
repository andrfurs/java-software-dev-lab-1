package org.example;

/**
 * Клас, який представняє хтонічну істоту з такими параметрами: вид, кількість років з моменту першої згадки в літературі,
 * вид істоти та сила атаки
 */
public class EvilSpirit {
    private String type;
    private int yearsFromAppear;
    private String creatureType;
    private int attackPower;

    /**
     * Конструктор класу EvilSpirit
     *
     * @param type            вид
     * @param yearsFromAppear кількість років з моменту першої згадки в літературі
     * @param creatureType    вид істоти
     * @param attackPower     сила атаки
     */
    public EvilSpirit(String type, int yearsFromAppear, String creatureType, int attackPower) {
        this.type = type;
        this.yearsFromAppear = yearsFromAppear;
        this.creatureType = creatureType;
        this.attackPower = attackPower;
    }

    /**
     * Повертає вид істоти
     *
     * @return вид істоти
     */
    public String getType() {
        return type;
    }

    /**
     * Встановлює вид істоти
     *
     * @param type вид істоти
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Повертає кількість років з моменту першої згадки в літературі хтонічної істоти
     *
     * @return кількість років з моменту першої згадки в літературі
     */
    public int getYearsFromAppear() {
        return yearsFromAppear;
    }

    /**
     * Встановлює кількість років з моменту першої згадки в літературі хтонічної істоти
     *
     * @param yearsFromAppear кількість років з моменту першої згадки в літературі тип хтонічної істоти
     */
    public void setYearsFromAppear(int yearsFromAppear) {
        this.yearsFromAppear = yearsFromAppear;
    }

    /**
     * Повертає вид хтонічної істоти
     *
     * @return вид хтонічної істоти
     */
    public String getCreatureType() {
        return creatureType;
    }

    /**
     * Встановлює вид хтонічної істоти
     *
     * @param creatureType вид хтонічної істоти
     */
    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    /**
     * Повертає силу атаки хтонічної істоти
     *
     * @return сила атаки хтонічної істоти
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Встановлює силу атаки хтонічної істоти
     *
     * @param attackPower сила атаки хтонічної істоти
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
