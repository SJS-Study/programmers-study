class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(String current, String target, String[] words, int depth) {
        if (current.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(current, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}