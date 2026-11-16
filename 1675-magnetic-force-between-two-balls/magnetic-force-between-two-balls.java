import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        
        int low = 1;
        int high = (position[n - 1] - position[0]) / (m - 1);
        int maxForce = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlaceBalls(position, m, mid)) {
                maxForce = mid;
                low = mid + 1;   // Try to find a larger minimum force
            } else {
                high = mid - 1;  // Reduce the required minimum force
            }
        }

        return maxForce;
    }

    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int ballsPlaced = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minDist) {
                ballsPlaced++;
                lastPosition = position[i];
                if (ballsPlaced == m) {
                    return true;
                }
            }
        }

        return false;
    }
}