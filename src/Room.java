class Room {
    private Point x;
    private Point y;
    private Direction facingDirection;
    private String[][] cell;
    private final int widthBorder = 3;

    Room(int width, int height) {
        this.x = new Point(0, width - 1);
        this.y = new Point(0, height - 1);
        this.facingDirection = Direction.NORTH;
        this.cell = initialFrame(width, height);
    }

    Point getX() {
        return x;
    }

    Point getY() {
        return y;
    }

    Direction getFacingDirection() {
        return facingDirection;
    }

    void setPath() {
        cell[y.getMaxLocation() - y.getLocation()][x.getLocation()] = "*";
    }

    void setFinalPos() {
        cell[y.getMaxLocation() - y.getLocation()][x.getLocation()] = "F";
    }

    void turnLeft() {
        int leftIndex = facingDirection.getValue() - 1;
        facingDirection = leftIndex < Direction.NORTH.getValue() ? Direction.WEST : Direction.values()[leftIndex];
    }

    void turnRight() {
        int rightIndex = facingDirection.getValue() + 1;
        facingDirection = rightIndex > Direction.WEST.getValue() ? Direction.NORTH : Direction.values()[rightIndex];
    }

    void moveForward() {
        switch (facingDirection) {
            case NORTH:
                y.moveForward();
                break;
            case EAST:
                x.moveForward();
                break;
            case SOUTH:
                y.backForward();
                break;
            case WEST:
                x.backForward();
                break;
        }
    }

    void printPath() {
        printTop();
        int counter = y.getMaxLocation();
        for (String[] aCell : cell) {
            System.out.print(counter + "|");
            for (String anACell : aCell) {
                if (anACell == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(anACell);
                }

            }
            System.out.println("|");
            counter--;
        }
        printBottom();
    }

    private void printTop() {
        int frameWidth = x.getMaxLocation() + widthBorder + 1;
        for (int i = 0; i < frameWidth; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else if (i == 1 || i == frameWidth - 1) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    private void printBottom() {
        int frameWidth = x.getMaxLocation() + widthBorder + 1;
        for (int i = 0; i < frameWidth; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else if (i == 1 || i == frameWidth - 1) {
                System.out.print("+");
            } else {
                System.out.print(i - 2);
            }
        }
    }

    private String[][] initialFrame(int width, int height) {
        String[][] frame = new String[height][width];
        frame[height - 1][0] = "*";
        return frame;
    }


}
