class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Cars can meet at the target and become a fleet
        // Return the number of fleets

        // Some sort of stack problem
        // numOfTurns = Math.ceiling(target - position[1]) / speed[i]

        // Sort the car's based on their position

        // Not sure how I'm handling speed of 0 yet
        
        int n = position.length;
        int[][] cars = new int[n][];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{ position[i], speed[i] };
        }

        // Sort array in descending order
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double prevTime = -1;

        for (int[] car : cars) {
            int p = car[0], s = car[1];
            double time = (double) (target - p) / s;

            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }

        }

        return fleets;
    }
}
