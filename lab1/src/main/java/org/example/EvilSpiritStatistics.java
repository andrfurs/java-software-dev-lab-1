package org.example;

import java.util.stream.Collector;

/**
 * Клас, який має методи для обчислення статистистичних даних
 */
public class EvilSpiritStatistics {
    private int minAttackPower = Integer.MAX_VALUE;
    private int maxAttackPower = Integer.MIN_VALUE;
    private double sumAttackPower = 0;
    private double sumOfSquares = 0;
    private long count = 0;

    /**
     * Метод, який приймає об'єкт EvilSpirit і оновлює статистику
     *
     * @param evilSpirit хтонічна істота для обробки
     */
    public void accept(EvilSpirit evilSpirit) {
        int attackPower = evilSpirit.getAttackPower();
        minAttackPower = Math.min(minAttackPower, attackPower);
        maxAttackPower = Math.max(maxAttackPower, attackPower);
        sumAttackPower += attackPower;
        sumOfSquares += attackPower * attackPower;
        count++;
    }

    /**
     * Метод, що поєднує EvilSpiritStatistics з іншою статистикою
     *
     * @param otherStatistics інша статистика для поєднання
     * @return об'днана статистика
     */
    public EvilSpiritStatistics combine(EvilSpiritStatistics otherStatistics) {
        minAttackPower = Math.min(minAttackPower, otherStatistics.minAttackPower);
        maxAttackPower = Math.max(maxAttackPower, otherStatistics.maxAttackPower);
        sumAttackPower += otherStatistics.sumAttackPower;
        sumOfSquares += otherStatistics.sumOfSquares;
        count += otherStatistics.count;
        return this;
    }

    /**
     * Повертає мінімальну силу атаки хтонічної істоти
     *
     * @return мінімальна сила атаки хтонічної істоти
     */
    public int getMinAttackPower() {
        return minAttackPower;
    }

    /**
     * Повертає максимальну силу атаки хтонічної істоти
     *
     * @return максимальна сила атаки хтонічної істоти
     */
    public int getMaxAttackPower() {
        return maxAttackPower;
    }

    /**
     * Повертає середню силу атаки хтонічної істоти
     *
     * @return середня сила атаки хтонічної істоти
     */
    public double getAverageAttackPower() {
        return count > 0 ? sumAttackPower / count : 0;
    }

    /**
     * Повертає стандартне відхилення сили атаки хтонічної істоти
     *
     * @return стандартне відхилення сили атаки хтонічної істоти
     */
    public double getStandardDeviation() {
        double mean = getAverageAttackPower();
        return Math.sqrt((sumOfSquares / count) - (mean * mean));
    }

    /**
     * Створює колектор для збирання статистики з потоку об'єктів EvilSpirit
     *
     * @return колектор для статистики
     */
    public static Collector<EvilSpirit, ?, EvilSpiritStatistics> collector() {
        return Collector.of(
                EvilSpiritStatistics::new,
                EvilSpiritStatistics::accept,
                EvilSpiritStatistics::combine
        );
    }
}
