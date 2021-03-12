/**
 * Класс перечисления возможных математических действий
 */
public enum ActionMath {
    PLUS('+'),
    MINUS('-'),
    DEV('/'),
    MULTI('*');

    private char d;

    ActionMath(char s) {
        this.d = s;
    }

    public Character getmathAction() {
        return d;
    }

}
