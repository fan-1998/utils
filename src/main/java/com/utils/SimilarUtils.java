package com.utils;

/**
 * @Description
 * @date 2022-08-14 17:17
 * @Author fanxg
 * 相似度对比
 */
public class SimilarUtils {


    public static void main(String[] args) {
        double x =  getStringSimilarity("b>0 && a>0","b>0 && a>0 c==0");
        System.out.println(x);
    }


    public static double getStringSimilarity(String sourceString, String targetString) {
        int[][] matrix;
        int sourceStringLength = sourceString.length();
        int targetStringLength = targetString.length();
        int indexOfSourceString;
        int indexOfTargetString;
        char charOfSourceString;
        char charOfTargetString;
        int temp;

        if (sourceStringLength == 0 || targetStringLength == 0) return 0;

        matrix = new int[sourceStringLength + 1][targetStringLength + 1];
        for (indexOfSourceString = 0; indexOfSourceString <= sourceStringLength; indexOfSourceString++) {
            matrix[indexOfSourceString][0] = indexOfSourceString;
        }
        for (indexOfTargetString = 0; indexOfTargetString <= targetStringLength; indexOfTargetString++) {
            matrix[0][indexOfTargetString] = indexOfTargetString;
        }

        for (indexOfSourceString = 1; indexOfSourceString <= sourceStringLength; indexOfSourceString++) {
            charOfSourceString = sourceString.charAt(indexOfSourceString - 1);
            for (indexOfTargetString = 1; indexOfTargetString <= targetStringLength; indexOfTargetString++) {
                charOfTargetString = targetString.charAt(indexOfTargetString - 1);
                if (charOfSourceString == charOfTargetString || charOfSourceString == charOfTargetString + 32 || charOfSourceString + 32 == charOfTargetString) {
                    temp = 0;
                } else temp = 1;
                matrix[indexOfSourceString][indexOfTargetString] =
                        Math.min(Math.min(matrix[indexOfSourceString - 1][indexOfTargetString] + 1,
                                matrix[indexOfSourceString][indexOfTargetString - 1] + 1),
                                matrix[indexOfSourceString - 1][indexOfTargetString - 1] + temp);
            }
        }
        return (1 - (double) matrix[sourceStringLength][targetStringLength] / Math.max(sourceString.length(), targetString.length())) * 100F;
    }

}
