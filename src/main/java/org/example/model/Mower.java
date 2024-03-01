package org.example.model;

import java.util.Objects;

public class Mower {

    int posx;
    int posy;
    Direction direction;

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public Direction getDirection() {
        return direction;
    }

    public Mower(int posx, int posy, Direction direction) {
        this.posx = posx;
        this.posy = posy;
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return  posx +""+posy+""+direction;
    }
}
