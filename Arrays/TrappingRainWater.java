package Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        // left = 0 right = n-1
        // res
        // maxLeft so far and maxRight sofar
        // compare value left <= right
        // update if current > leftMax
        // left++
        // we can add if left leftmax > current
        // res += leftmax - current
        // similar for right ptr
        // update current > rightmax
        // right--
        // we can add if rightmax > current
        // res += rightmax - current
        // repeat utnitl l <= r

        int left = 0;
        int right = height.length - 1;
        int trapped = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trapped += rightMax - height[right];
                }
                right--;
            }
        }

        return trapped;
    }

}
