package algorithm.leetCode.stack.validParentheses;

/**
 * 第20题
 * https://leetcode-cn.com/problems/valid-parentheses/
 * label:stack
 * <p>
 * 题目描述：
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * time:2ms
 * mem:35.6MB
 * 基本思路：构建栈来消除对应符号。(貌似可以不用自己构建栈对象)
 *
 * @author ltw
 * on 2019-10-05.
 */
public class MySolution {

    int top = 0;

    public boolean isValid(String s) {
        if (s.trim().length() % 2 != 0) {
            return false;
        }
        String[] stack = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i); // 获取第i个元素值
            push(stack, x, i);
            compare(stack);
        }
        return (s.trim().length() == 0 || stack[0] == null);
    }

    private void compare(String[] stack) {
        if (top > 1) {
            switch (stack[top - 1]) {
                case ")":
                    if (stack[top - 2].equals("(")) {
                        pop(stack);
                        pop(stack);
                    }
                    break;
                case "]":
                    if (stack[top - 2].equals("[")) {
                        pop(stack);
                        pop(stack);
                    }
                    break;
                case "}":
                    if (stack[top - 2].equals("{")) {
                        pop(stack);
                        pop(stack);
                    }
                    break;
            }
        }
    }

    private void push(String[] stack, char x, int i) { // push 并扩容
        int size = stack.length;
        if (size == (stack.length - 1)) {
            String[] temp = new String[stack.length * 2];
            for (int j = 0; j < stack.length; j++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        stack[top++] = x + "";
    }

    private void pop(String[] stack) {
        stack[--top] = null;
    }
//
//    public static void main(String[] args) {
//        ValidParentheses solution = new ValidParentheses();
//        System.out.print(solution.isValid("((("));
//    }


}
