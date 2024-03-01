package org.example.service;

import org.example.model.Direction;
import org.example.model.Lawn;
import org.example.model.Mower;
import org.example.model.Operation;

import java.util.Arrays;
import java.util.Optional;

public class MowerOperator {
    private Mower mower;

    public MowerOperator(Mower mower) {
        this.mower = mower;
    }

    public void operate(Lawn lawn, Character operation) {
        Optional<Operation> operationEnum = Arrays.stream(Operation.values()).filter(val -> val.toString().equalsIgnoreCase(operation.toString())).findFirst();
        if (operationEnum.isPresent()) {
            switch (operationEnum.get()) {
                case D:
                case G: rotate(operationEnum.get());
                                  break;
                case A: move(lawn);
                        break;
            }
        }
    }

    private void rotate(Operation operation){
        Direction direction=mower.getDirection();
        if(operation.equals(Operation.G)){
           switch(mower.getDirection()){
               case N: direction= Direction.W;
                       break;
               case W: direction= Direction.S;
                   break;
               case S: direction= Direction.E;
                   break;
               case E: direction= Direction.N;
                   break;
           }
        }else if(operation.equals(Operation.D)){
            switch(mower.getDirection()){
                case N: direction= Direction.E;
                    break;
                case E: direction= Direction.S;
                    break;
                case S: direction= Direction.W;
                    break;
                case W: direction= Direction.N;
                    break;
            }
        }
        mower.setDirection(direction);
    }
    private void move(Lawn lawn) {
        if(mower.getDirection() ==  Direction.E || mower.getDirection() ==  Direction.W){
            if(mower.getDirection() ==  Direction.W){
                int nextPos=mower.getPosx()-1< 0 ?  mower.getPosx():mower.getPosx()-1;
                mower.setPosx(nextPos);
            }
            if(mower.getDirection() ==  Direction.E){
                int nextPos=mower.getPosx()+1> lawn.getLength()?  mower.getPosx():mower.getPosx()+1;
                mower.setPosx(nextPos);
            }

        }
        if(mower.getDirection() ==  Direction.N || mower.getDirection() ==  Direction.S){
            if(mower.getDirection() ==  Direction.S){
                int nextPos=mower.getPosy()-1< 0 ?  mower.getPosy():mower.getPosy()-1;
                mower.setPosy(nextPos);
            }
            if(mower.getDirection() ==  Direction.N){
                int nextPos=mower.getPosy()+1> lawn.getWidth()?  mower.getPosy():mower.getPosy()+1;
                mower.setPosy(nextPos);
            }
        }
    }
}
