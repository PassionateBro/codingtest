package com.test;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-01-11 17:29
 */
public class PdfSwitch {
    public static void main(String[] args) {
        // D:\雅思大作文2022.9.pdf
        // ysxzZY789
        Scanner scan = new Scanner(System.in);
        String path = "", password = "";
        System.out.println("输入文件路径：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            path = str1.trim();
        }
        System.out.println("输入文件密码：");
        if (scan.hasNext()) {
            String str2 = scan.next();
            password = str2.trim();
        }
        scan.close();
        File file = new File(path);
        try {
            PDDocument pdd = PDDocument.load(file,password);
            pdd.setAllSecurityToBeRemoved(true);
            pdd.save(file);
            pdd.close();
        } catch (Exception e) {
            System.err.println("处理发生异常");
        }
        System.out.println("pdf解密完成");
    }
}
