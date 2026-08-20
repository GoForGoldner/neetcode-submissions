class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // two arrays position speed
        // Goal is to determine how many car fleets will be at the end 
        // A car can meet at the desintation and still be a fleet

        // Can compute time using double turns = (target - position) / speed;

        // Goal: for each car in descending order of position compute the numbers of turns to get to the target and keep track of times where the turn count increases (new fleet)

        int n = position.length;
        // [position, speed]
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{ position[i], speed[i] };
        }

        // Sort cars in descending order of position
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double prevT = -1;

        for (int i = 0; i < n; i++) {
            int p = cars[i][0], s = cars[i][1];
            double t = (double) (target - p) / s;

            if (t > prevT) {
                fleets++;
                prevT = t;
            }
        }

        return fleets;
    }
}
