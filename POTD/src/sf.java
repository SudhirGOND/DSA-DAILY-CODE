class seventeenjune2026 {
    public char processStr(String s, long k) {
        int n = s.length();
        long len = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*')
                len = Math.max(len - 1, 0L);
            else if (c == '#')
                len *= 2;
            else if (c != '%')
                len++;
        }

        if (k >= len)
            return '.';

        for (int i = n - 1; ; i--) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    len++;
                    break;
                case '#':
                    if (k >= len / 2)
                        k -= len / 2;
                    len /= 2;
                    break;
                case '%':
                    k = len - 1 - k;
                    break;
                default:
                    if (len == k + 1)
                        return c;
                    len--;
            }
        }
    }


    public char processStrMLE(String s, long k) {
        //// the edge cases is so much important in the HARD question()
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z')
                result.append(arr[i]);
            else if (arr[i] == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }

            } else if (arr[i] == '#')
                result.append(result);
            else if (arr[i] == '%')
                result.reverse();
        }

        if (k >= result.length())
            return '.'; //// included the zero index also

        return result.charAt((int) k);
    }
}
