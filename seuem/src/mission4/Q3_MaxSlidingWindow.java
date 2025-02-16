import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q3_MaxSlidingWindow {
    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//      출력: [3,3,5,5,6,7]

        System.out.println("maxSlidingWindow(nums, k) = " + Arrays.toString(maxSlidingWindow(nums, k)));

    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            //
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                //deque안에 안에 인덱스가 지금 지금 i 인덱스 기준 k 범위에 못들어오는 오래된 위치면 삭제한다.
                deque.pollFirst();
            }
            //-3>-1
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                //while문이니 지금 nums[i]가 deque안에 있는 수보다 크면 poll해서 없애버린다
                deque.pollLast(); //그밑에 nums[i]넣는 코드 있음.
            }
            deque.offerLast(i);
            //모든 수가 하나씩 다 들어가지만 최신으로 들어오는 아이가 기존에 있는 수보다 크면 기존것들이 삭제된다

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()]; //deque에 오래 있는게 제일 큰수이다.
            }

        }
        return result;
    }
}
