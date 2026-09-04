class Solution {
    public boolean isValid(String s) {
        // Create a stack of open parenthesis
        // Add open parenthesis to the stack
        // If closed parenthesis, make sure it matches top of stack for open parenthesis

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (isOpenCharacter(c)) {
                stack.offerFirst(c);
            } else {
                if (stack.isEmpty()) return false;

                char open = stack.pollFirst();

                // Validate character
                if (
                    (open == '(' && c != ')') ||
                    (open == '{' && c != '}') ||
                    (open == '[' && c != ']')
                ) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenCharacter(char c) {
        return c == '(' || c == '{' || c == '[';
    } 
}
