public class CleanFloorTest {
    
    public static void main(String[] args){

         
        FloorSweeper sweeper = new FloorSweeper(FloorPlan.scatterDirt(FloorPlan.getFloorPlan2()),0,9);
        sweeper.printLearnedMap();
        sweeper.beginSweep();
        sweeper.printLearnedMap();
        
        /*
        String[][] floorPlan = FloorPlan.getFloorPlan();
        String temp = "";
        for(int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                if (floorPlan[y][x].charAt(2) == '1'){
                    temp = temp + "N";
                }
                else temp = temp + "_";
                if (floorPlan[y][x].charAt(3) == '1'){
                    temp = temp + "S";
                }
                else temp = temp + "_";
                if (floorPlan[y][x].charAt(4) == '1'){
                    temp = temp + "E";
                }
                else temp = temp + "_";
                if (floorPlan[y][x].charAt(5) == '1'){
                    temp = temp + "W";
                }
                else temp = temp + "_";
                System.out.print(temp +", ");
                temp = "";
            }
            System.out.println("");
        }
            */
    }
}
