package algorithm.leetCode.No58;

class Solution {
    public String reverseWords(String s) {
        if ("".equals(s.trim())) {
            return "";
        }
        String[] tmp = s.split(" ");
        int i = 0;
        int j = tmp.length - 1;
        while (i < j) {
            swap(tmp, i, j);
            i++;
            j--;
        }
        StringBuilder result = new StringBuilder();
        for (int x = 0; x < tmp.length; x++) {
            if (!"".equals(tmp[x])) {
                result.append(" ").append(tmp[x].trim());
            }
        }
        return result.toString().substring(1, result.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("    "));
    }

    private void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}