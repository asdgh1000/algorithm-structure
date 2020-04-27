package algorithm.leetCode.No67;

class Solution {

//    class Solution {
//        public String addBinary(String a, String b) {
//            StringBuilder ans = new StringBuilder();
//            int ca = 0;
//            for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
//                int sum = ca;
//                sum += i >= 0 ? a.charAt(i) - '0' : 0;
//                sum += j >= 0 ? b.charAt(j) - '0' : 0;
//                ans.append(sum % 2);
//                ca = sum / 2;
//            }
//            ans.append(ca == 1 ? ca : "");
//            return ans.reverse().toString();
//        }
//    }

//    class Solution {
//        public String addBinary(String a, String b) {
//            StringBuilder ans = new StringBuilder();
//            int pa = a.length()-1;
//            int pb = b.length()-1;
//            int carry = 0;
//            while (pa >=0 || pb >= 0) {
//                int va = pa<0 ? 0 : a.charAt(pa)-'0';
//                int vb = pb<0 ? 0 : b.charAt(pb)-'0';
//                int sum = (va + vb + carry)%2;
//                ans.append(sum);
//                carry = (va + vb + carry)/2;
//                pa--;
//                pb--;
//            }
//            ans.append(carry==0 ? "" : carry);
//            return  ans.reverse().toString();
//        }
//    }

    public String addBinary(String a, String b) {
        int size = Math.max(a.length(), b.length());
        if (a.length() >= b.length()) {
            int diff = a.length() - b.length();
            for (int i = 0; i < diff; i++) {
                b = "0" + b;
            }
        } else {
            int diff = b.length() - a.length();
            for (int i = 0; i < diff; i++) {
                a = "0" + a;
            }

        }
        System.out.println(a);
        System.out.println(b);
        int flag = 0;
        String result = "";
        for (int i = size - 1; i >= 0; i--) {
            int tmp = flag + (a.charAt(i) - '0') + (b.charAt(i) - '0');
            result = (tmp % 2) + result;
            if (tmp >= 2) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        if(flag ==1){
            return "1"+result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1", "1"));
    }
}