/**
 * Класс получения результата вычисления
 */
public final class Result {

    private UserAction action;
    private int arabResult;
    private String rimResult = "";

    public Result(UserAction action) {
        this.action = action;
        if (action.getRimAction()) {
            getResultat();
            if (arabResult < 0) {
                System.out.println(minusRimResult());
            } else if (arabResult == 0) {
                System.out.println(arabResult);
            } else System.out.println(transformRim());
        } else {
            getResultat();
            System.out.println(arabResult);
        }
    }

    /**
     * Метод преобразования ответа в рискую цифру
     *
     * @return строку с римской цифрой
     */
    private String transformRim() {
        int input = arabResult;
        while (input >= 90) {
            rimResult += "XC";
            input -= 90;
        }
        while (input >= 50) {
            rimResult += "L";
            input -= 50;
        }
        while (input >= 40) {
            rimResult += "XL";
            input -= 40;
        }
        while (input >= 10) {
            rimResult += "X";
            input -= 10;
        }
        while (input >= 9) {
            rimResult += "IX";
            input -= 9;
        }
        while (input >= 5) {
            rimResult += "V";
            input -= 5;
        }
        while (input >= 4) {
            rimResult += "IV";
            input -= 4;
        }
        while (input >= 1) {
            rimResult += "I";
            input -= 1;
        }
        return rimResult;
    }

    /**
     * Метод действия над двумя переменными
     */
    private void getResultat() {
        if (action.getZnak() == '+') {
            arabResult = action.getValue1() + action.getValue2();
        }
        if (action.getZnak() == '-') {
            arabResult = action.getValue1() - action.getValue2();
        }
        if (action.getZnak() == '*') {
            arabResult = action.getValue1() * action.getValue2();
        }
        if (action.getZnak() == '/') {
            arabResult = action.getValue1() / action.getValue2();
        }
    }

    /**
     * Метод получения отрицательного значения римских цифр
     */
    private String minusRimResult() {
        for (RimNumber count : RimNumber.values()) {
            if (arabResult == count.getMinusArab()) {
                rimResult = "-" + count.getRim();
            }
        }
        return rimResult;
    }
}
