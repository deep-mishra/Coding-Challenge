
//Find if the brackets are in order, nested and closed properly
public class BalancedBrackets {
	public static boolean isBalanced(String expression) {
        int brk=0,cur=0,sqr=0;
        
        StringBuilder tracker = new StringBuilder(); // Simulates the stack behavior to track which closing bracket is allowed
        
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '(') {
                tracker.append(')');
                brk +=1;
            } else if(c == '{') {
                tracker.append('}');
                cur +=1;
            } else if(c == '[') {
                tracker.append(']');
                sqr +=1;
            }
            
            Character allowedclosingBrk = (tracker.length() == 0) ? null:tracker.charAt(tracker.length()-1);
            
            if(c == ')') {
                if (allowedclosingBrk != null && allowedclosingBrk == ')') {
                    tracker.deleteCharAt(tracker.length()-1);
                    brk -= 1;
                } else {
                    return false;
                }
            } else if(c == '}') {
                if( allowedclosingBrk != null && allowedclosingBrk == '}') {
                    tracker.deleteCharAt(tracker.length()-1);
                    cur -= 1;
                } else {
                    return false;
                }
            } else if(c == ']') {
                if( allowedclosingBrk != null && allowedclosingBrk == ']') {
                    tracker.deleteCharAt(tracker.length()-1);
                    sqr -= 1;
                } else {
                return false;
                }
            }
        }
        
        
        if (brk == 0 && cur == 0 && sqr == 0) {
            return true;
        }
        return false;
        
    }
  
    public static void main(String[] args) {

    	System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
        System.out.println(isBalanced("{()[][{}]}"));
        System.out.println(isBalanced("()[]"));
        System.out.println(isBalanced("[()][{}]{[({})[]]}"));
    }
}
