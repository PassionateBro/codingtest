package com.test;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.io.IOException;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-12-01 15:53
 */
public class PdfTest {

    static double theta = 0;// 选择的角度
    static float per = 1;// 镜像的大小比例
    static boolean isAdd = true;// 镜像大小是+计算还是-计算
    static Frame frame = new Frame("这里测试绘图");
    static MyCanvas drawArea = new MyCanvas();

    public static void main(String[] args) throws IOException {
        frame.add(drawArea);
        drawArea.setPreferredSize(new Dimension(400,600));
        frame.pack();
        frame.setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    theta += 2;
                    if (isAdd) {
                        per += 0.1;
                        if (per > 1.3) {
                            isAdd = false;
                        }
                    } else {
                        per -= 0.1;
                        if (per < 0.6) {
                            isAdd = true;
                        }
                    }
                    drawArea.repaint();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }

    public static class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            GeneralPath generalPath = new GeneralPath();
            g2d.setColor(new Color(0,0,0));
            generalPath.moveTo(getWidth() / 2 - 6, getHeight() * 3 / 10);
            generalPath.quadTo(getWidth() / 2, getHeight() * 3 / 10 + 5, getWidth() / 2 + 6, getHeight() * 3 / 10);// 上中
            generalPath.quadTo(getWidth() * 5 / 8, getHeight() * 2 / 10, getWidth() * 3 / 4, getHeight() * 2 / 10);// 右上
            generalPath.quadTo(getWidth(), getHeight() * 2 / 10 + 10, getWidth() - 5, getHeight() * 2 / 5);
            generalPath.quadTo(getWidth(), getHeight() * 3 / 5, getWidth() / 2 + 5, getHeight() * 4 / 5);
            generalPath.quadTo(getWidth() / 2, getHeight() * 4 / 5 + 3, getWidth() / 2 - 5, getHeight() * 4 / 5);
            generalPath.quadTo(10, getHeight() * 3 / 5, 5, getHeight() * 2 / 5);
            generalPath.quadTo(0, getHeight() * 2 / 10, getWidth() * 1 / 4, getHeight() * 2 / 10);
            generalPath.quadTo(getWidth() * 3 / 8, getHeight() * 2 / 10, getWidth() / 2 - 6, getHeight() * 3 / 10);

            for (int i = 0; i < 9; i++) {
                AffineTransform transform = g2d.getTransform();
                transform.scale(0.6d, 0.6d);
                transform.translate(getWidth() * 0.34, getHeight() * 0.34);
                if (i > 3) {
                    transform.rotate(theta % 360, getWidth() / 2, getHeight() / 2);
                }
                g2d.setTransform(transform);
                g2d.draw(generalPath);
                g2d.setColor(Color.RED);
                Color[] colors = {new Color(255,0,124), Color.WHITE, new Color(255,0,124)};
                float[] dist = {0.13f, 0.55f, 1.0f};
                Point2D center = new Point2D.Float(0.5f * getWidth(), 0.5f * getHeight() - 10);

                RadialGradientPaint p = new RadialGradientPaint(center, 0.5f * getWidth() * per, dist, colors);
                g2d.setPaint(p);
                g2d.fill(generalPath);
            }

        }
    }
}
