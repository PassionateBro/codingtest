package com.learn;

/**
 * @describtion: 273. 整数转换英文表示
 * @author: CaiJm
 * @Date: 2021-10-11 9:34
 */
public class NumberToWords {
    static String[] a = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", "Twenty Five", "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine", "Thirty", "Thirty One", "Thirty Two", "Thirty Three", "Thirty Four", "Thirty Five", "Thirty Six", "Thirty Seven", "Thirty Eight", "Thirty Nine", "Forty", "Forty One", "Forty Two", "Forty Three", "Forty Four", "Forty Five", "Forty Six", "Forty Seven", "Forty Eight", "Forty Nine", "Fifty", "Fifty One", "Fifty Two", "Fifty Three", "Fifty Four", "Fifty Five", "Fifty Six", "Fifty Seven", "Fifty Eight", "Fifty Nine", "Sixty", "Sixty One", "Sixty Two", "Sixty Three", "Sixty Four", "Sixty Five", "Sixty Six", "Sixty Seven", "Sixty Eight", "Sixty Nine", "Seventy", "Seventy One", "Seventy Two", "Seventy Three", "Seventy Four", "Seventy Five", "Seventy Six", "Seventy Seven", "Seventy Eight", "Seventy Nine", "Eighty", "Eighty One", "Eighty Two", "Eighty Three", "Eighty Four", "Eighty Five", "Eighty Six", "Eighty Seven", "Eighty Eight", "Eighty Nine", "Ninety", "Ninety One", "Ninety Two", "Ninety Three", "Ninety Four", "Ninety Five", "Ninety Six", "Ninety Seven", "Ninety Eight", "Ninety Nine"};

    public String numberToWords(int num) {
        StringBuilder strb = new StringBuilder();
        if (num >= 1000000000) {
            strb.append(numberToWords(num / 1000000000));
            strb.append(" Billion ");
            if (num % 1000000000 > 0) strb.append(numberToWords(num % 1000000000));
        } else if (num >= 1000000) {
            strb.append(numberToWords(num / 1000000));
            strb.append(" Million ");
            if (num % 1000000 > 0) strb.append(numberToWords(num % 1000000));
        } else if (num >= 1000) {
            strb.append(numberToWords(num / 1000));
            strb.append(" Thousand ");
            if (num % 1000 > 0) strb.append(numberToWords(num % 1000));
        } else if (num >= 100) {
            strb.append(numberToWords(num / 100));
            strb.append(" Hundred ");
            if (num % 100 > 0) strb.append(numberToWords(num % 100));
        } else strb.append(a[num]);
        return strb.toString().trim();
    }
}
