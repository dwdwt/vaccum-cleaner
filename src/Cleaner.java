class Cleaner {
    private int battery;
    private Room room;

    Cleaner(Room room) {
        this.room =room;
        this.battery = 100;
    }

    void processingInstructions(String instructions) {
        for (int i = 0; i < instructions.length(); i++) {
            char singleInstruction = instructions.charAt(i);
            processEachInstruction(singleInstruction);
        }
        room.setFinalPos();
    }

    private void processEachInstruction(char instruction) {
        if (battery == 0) {
            throw new RuntimeException("Vacuum Cleaner no energy.");
        } else {
            switch (instruction) {
                case 'L':
                    room.turnLeft();
                    break;
                case 'R':
                    room.turnRight();
                    break;
                case 'M':
                    room.moveForward();
                    room.setPath();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction.");
            }
            battery--;
            chargeBattery();
        }
    }

    private void setBattery(int battery) {
        this.battery = battery;
    }

    private void chargeBattery() {
        int x = room.getX().getLocation();
        int y = room.getY().getLocation();
        if (x == 0 & y == 0) {
            setBattery(100);
        }
    }

    void printResult() {
        System.out.println(room.getX().getLocation() + " " + room.getY().getLocation() + " " + room.getFacingDirection().getShortName()+" "+battery);
        room.printPath();
    }


}
