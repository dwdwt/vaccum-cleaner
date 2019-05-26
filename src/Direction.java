enum Direction {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private int value;
    private char shortName;

    Direction(int newValue, char shortNameValue) {
        value = newValue;
        shortName = shortNameValue;
    }

    int getValue() {
        return value;
    }

    char getShortName() {
        return shortName;
    }
}
