package com.lei;

import java.util.ArrayList;

        public class Gearbox {
            private ArrayList<Gear> gears;
            private int maxGears;
            //private int currentGear;
            private int gearNumber=0;
            private boolean clutchIsIn;

            public Gearbox(int maxGears) {
                this.maxGears = maxGears;
                this.gears=new ArrayList<Gear>();
                Gear neutral=new Gear(0,0.0);
                this.gears.add(neutral);}


    public void operateClutch(boolean in){
        this.clutchIsIn=in;
    }
    public void addGear(int number, double ratio){
        if ((number>0) && (number<=maxGears)){
            this.gears.add(new Gear(number,ratio));
        }
    }
    public void changeGear(int newGear){
        if((newGear>=0)&&(newGear<this.gears.size())&& this.clutchIsIn){
            this.gearNumber=newGear;
            System.out.println("Gear "+newGear+" selected.");
        } else {
            System.out.println("Grind!");
            this.gearNumber=0;
        }
    }

    public double wheelSpeed(int revs){
                if(clutchIsIn){
                    System.out.println("Scream!!!");
                    return 0.0;
                }
                return revs*gears.get(gearNumber).getRatio();
    }
    private class Gear{
        private int currentGear;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.currentGear = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs*(this.ratio);
        }
    }
}
