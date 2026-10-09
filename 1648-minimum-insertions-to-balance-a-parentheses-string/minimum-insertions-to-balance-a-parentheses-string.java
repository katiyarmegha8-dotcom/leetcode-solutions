class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0; // number of ')' needed

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                need += 2;

                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }
            } else { // ')'
                need--;

                if (need == -1) {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}