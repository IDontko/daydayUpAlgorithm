package Array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/3/18
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
       int length  = 0;
        for (int i = 0; i < distance.length ; i++) {
            length += distance[i];
        }

        int currentL = 0;
        for(int j = Math.min(start, destination); j< Math.max(start, destination); j++){
            currentL += distance[j];
        }
        return Math.min(currentL, length - currentL);
    }

    public int minCostToMoveChips(int[] position) {
        int maxCountPosition =  0;
        HashMap<Integer , Integer> map = new HashMap<>();
        int positionIndex = -1;
        for (int i = 0; i < position.length; i++) {
            if (map.getOrDefault(position[i], 0) + 1 > maxCountPosition){
                positionIndex = i;
            }

            maxCountPosition = Math.max(maxCountPosition, map.getOrDefault(position[i], 0) + 1);
            map.put(position[i], map.getOrDefault(position[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < position.length; i++) {
            if (Math.abs(positionIndex - i) % 2 == 1){
                ans++;
            }
        }
        return ans;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int numCols = grid[0].length;
        int numRows = grid.length;

        // Setup the 2d list.
        List<List<Integer>> newGrid = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>();
            newGrid.add(newRow);
            for (int col = 0; col < numCols; col++) {
                newRow.add(0);
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int newCol = (col + k) % numCols;
                int wrapAroundCount = (col + k) / numCols;
                int newRow = (row + wrapAroundCount) % numRows;
                newGrid.get(newRow).set(newCol, grid[row][col]);
            }
        }

        return newGrid;

    }


    public static void main(String[] args) {
        int[] pos = {1, 2, 3};
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;

        DistanceBetweenBusStops obj = new DistanceBetweenBusStops();
        obj.minCostToMoveChips(pos);
        obj.shiftGrid(test, k);
    }

}

