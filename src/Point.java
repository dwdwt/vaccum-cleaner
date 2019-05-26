class Point {
    private int location;
    private int maxLocation;

    Point(int locationValue, int maxLocationValue) {
        setLocation(locationValue);
        setMaxLocation(maxLocationValue);
    }

    private void setLocation(int value) {
        location = value;
    }

    private void setMaxLocation(int value) {
        maxLocation = value;
    }

    int getLocation() {
        return location;
    }

    int getMaxLocation() {
        return maxLocation;
    }

    void moveForward() {
        if (location < maxLocation) {
            location++;
        }
    }

    void backForward() {
        if (location > 0) {
            location--;
        }
    }
}
