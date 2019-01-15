import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by chenchangxing on 2019/1/15.
 */
public class MinStack {
    int[] nums = new int[10];
    int index = 0;
    int min = 0;

    public MinStack() {

    }

    public void push(int x) {
        if (index == nums.length) {
            int[] tmp = new int[nums.length + 10];
            System.arraycopy(nums, 0, tmp, 0, nums.length);
            nums = tmp;
        }

        min = index == 0 ? x : Math.min(x, min);
        nums[index++] = x;
    }

    public void pop() {
        int tmp = nums[(index - 1)];
        index--;
        if (min == tmp) {
            for (int i = 0; i < index; i++) {
                min = i == 0 ? nums[i] : Math.min(min, nums[i]);
            }
        }
    }

    public int top() {
        return nums[index-1];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-124);
        stack.push(-164);
        stack.push(-24);
        stack.push(-100);
        stack.push(33);
        stack.push(34);
        stack.push(35);
        stack.push(36);
        stack.push(37);
        stack.push(38);
        stack.push(39);


        System.out.println(Arrays.toString(stack.nums));
        System.out.println(stack.index);
    }
}

class MinStackBest {
    private Deque<Integer> mainStack; // 主栈，存储所有数据

    private Deque<Integer> minStack; // 将数据压入主栈时，存储最小值

    /** initialize your data structure here. */
    public MinStackBest() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        mainStack.push(x);

        Integer min = minStack.peek();
        if (min == null || x <= min) {
            minStack.push(x);
        }
    }

    public int pop() {
        int cur = mainStack.pop();
        if (cur == minStack.peek()) {
            minStack.pop();
        }
        return cur;

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}