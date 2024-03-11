package app.testcode.tdd.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = getMetCriteriaCounts(s);

        if (metCounts <= 1)return PasswordStrength.WEAK; // 이전의 if 구문을 하나로 제거하였다.
        if (metCounts == 2)return PasswordStrength.NORMAL; // 이전의 if 구문을 하나로 제거하였다.

        return PasswordStrength.STRONG;
    }

    public boolean meetsContainingNumberCriteria(String s){
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                return true;
            }
        }
        return false;
    }
    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if (s.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(s)) metCounts++;
        if (meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;
    }
}
