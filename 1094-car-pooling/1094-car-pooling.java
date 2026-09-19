class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // Array to store net passenger changes at each location
        // Assuming max location can be up to 1000 based on problem constraints
        int[] passengerChanges = new int[1001];

        // Record passenger changes at pickup and drop-off points
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            passengerChanges[from] += passengers;
            passengerChanges[to] -= passengers;
        }

        // Track current passengers in the car
        int currentPassengers = 0;

        // Traverse through all locations to check if capacity exceeded at any point
        for (int i = 0; i < passengerChanges.length; i++) {
            currentPassengers += passengerChanges[i];
            if (currentPassengers > capacity) {
                return false; // Capacity exceeded
            }
        }

        return true; // All trips possible without exceeding capacity
    
    }
}