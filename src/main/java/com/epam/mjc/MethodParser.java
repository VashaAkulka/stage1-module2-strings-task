package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */


    public MethodSignature parseFunction(String signatureString) {
        List<MethodSignature.Argument> arguments = new ArrayList<>();

        int i = signatureString.indexOf('(');
        String par = signatureString.substring(i + 1, signatureString.length() - 1);
        String[] parametrs = par.split(", ");

        if (!parametrs[0].isEmpty()) {
            for (String parametr : parametrs) {
                String[] buff = parametr.split(" ");

                MethodSignature.Argument argument = new MethodSignature.Argument(buff[0], buff[1]);
                arguments.add(argument);
            }
        }

        String str = signatureString.substring(0, i);
        String[] split = str.split(" ");

        MethodSignature methodSignature = null;
        if (split.length == 2) {
            methodSignature = new MethodSignature(split[1], arguments);
            methodSignature.setReturnType(split[0]);
        } else {
            methodSignature = new MethodSignature(split[2], arguments);
            methodSignature.setAccessModifier(split[0]);
            methodSignature.setReturnType(split[1]);
        }
        return methodSignature;
    }
}
