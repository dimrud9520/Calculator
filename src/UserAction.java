import java.util.Scanner;

/**
 * Класс  получения выражения от пользователя
 */
public final class UserAction {
    private Scanner sc;
    private String mathAction;
    private int value1;
    private int value2;
    private int whod;
    private char znak;
    private boolean rimAction = false;

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public boolean getRimAction() {
        return rimAction;
    }

    /**
     * Метод получения знака из введенного выражения
     * @return знак
     */
    public Character getZnak() {
        for (ActionMath count : ActionMath.values()) {
            if (count.getmathAction() == (mathAction.charAt(getWhod()))) {
                znak = count.getmathAction();
            }
        }
        return znak;
    }


    public UserAction() {
        value1 = 0;
        value2 = 0;

        System.out.println("Введите действие римскими либо арабскими цифрами");
        sc = new Scanner(System.in);
        mathAction = sc.nextLine();

        try {
            znackEx();
        } catch (MathematicActionExteption mathematicActionExteption) {
            mathematicActionExteption.printStackTrace();
            System.exit(0);
        }

        if (isNumber(0, 1)) {

            try {
                arabNumber();
            } catch (VariablesExteption variablesExteption) {
                variablesExteption.printStackTrace();
                System.exit(0);
            }

        } else {

            try {
                rimNumber();
            } catch (VariablesExteption variablesExteption) {
                variablesExteption.printStackTrace();
                System.exit(0);
            }
            rimAction = true;

        }
    }

    /**
     * Метод получения переменных, если пользователь ввел выражения арабскими числами
     */
    private void arabNumber() throws VariablesExteption {
        value1 = Integer.parseInt(mathAction.substring(0, getWhod()));
        value2 = Integer.parseInt(mathAction.substring(getWhod() + 1, mathAction.length()));
        if (value1 > 10 || value1 < 1 || value2 > 10 || value2 < 1)
            throw new VariablesExteption("Числа могут быть только от 1 до 10");
    }

    /**
     * Метод определия ялвляются ли переменные арабскими цифрами
     */
    private boolean isNumber(int oneCount, int twoCount) {
        try {
            String str = mathAction.substring(oneCount, twoCount);
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Метод получения переменных, если пользователь ввел выражения римскими числами
     */
    private void rimNumber() throws VariablesExteption {
        for (RimNumber count : RimNumber.values()) {
            if (count.getRim().equalsIgnoreCase(mathAction.substring(0, getWhod()))) {
                value1 = count.getArab();
            }
            if (count.getRim().equalsIgnoreCase(mathAction.substring(getWhod() + 1, mathAction.length()))) {
                value2 = count.getArab();
            }
        }
        if (value1 == 0) throw new VariablesExteption("Некорректно введено первое число");
        if (value2 == 0) throw new VariablesExteption("Некорректно введено второе число");
    }

    /**
     * Метод определения точки входа знака
     * return позицию входа знака
     */
    private Integer getWhod() {
        for (int i = 0; i < mathAction.length(); i++) {
            for (ActionMath count : ActionMath.values()) {
                if (count.getmathAction() == (mathAction.charAt(i))) {
                    whod = i;
                }
            }
        }
        return whod;
    }

    /**
     * Метод проверки корректности математического знака
     */
    private void znackEx() throws MathematicActionExteption {
        int ok = 0;
        for (ActionMath count : ActionMath.values()) {
            for (int i = 0; i < mathAction.length(); i++) {
                if (mathAction.charAt(i) == count.getmathAction()) ok += 1;
            }
        }
        if (ok > 1 || ok == 0) throw new MathematicActionExteption("Ошибка математического знака");
    }


}