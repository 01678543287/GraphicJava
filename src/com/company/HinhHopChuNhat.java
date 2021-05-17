package com.company;

import java.awt.*;

public class HinhHopChuNhat extends Canvas {
    public int x, y, z, chieuDai, chieuCao, chieuRong;

    public int[][] Dinh;

    public HinhHopChuNhat() {
        setSize(1000, 500);
        setBackground(Color.cyan);
    }

    public HinhHopChuNhat(int x, int y, int z, int cd, int cr, int cc) {
        setSize(1000, 500);
        setBackground(Color.cyan);

        this.chieuDai = cd;
        this.chieuRong = cr;
        this.chieuCao = cc;
        int[][] temp = {{x, y, z},
                {x + cd, y, z},
                {x + cd, y, z + cr},
                {x, y, z + cr},
                {x, y + cc, z},
                {x + cd, y + cc, z},
                {x + cd, y + cc, z + cr},
                {x, y + cc, z + cr}};
        this.Dinh = temp;
    }

    public static Point chuyen3DThanh2D(int x, int y, int z) {
        float alpha = (float) Math.PI / 4,
                phi = (float) Math.PI / 4,
                L,
                Xp,
                Yp;

        L = z / (float) Math.tan(alpha);

        Xp = (float) (x - (float) z * Math.sqrt(2) / 2);
        Yp = (float) (y - (float) z * Math.sqrt(2) / 2);

        return new Point((int) Xp, (int) Yp);
    }

    void drawHinhHopChuNhat() {
        // Vẽ nét đứt
        drawLine(0, 1, 2);
        drawLine(3, 0, 2);
        drawLine(0, 4, 2);
        // Vẽ nét liền
        drawLine(1, 2, 1);
        drawLine(2, 3, 1);
        drawLine(4, 5, 1);
        drawLine(5, 6, 1);
        drawLine(6, 7, 1);
        drawLine(7, 4, 1);
        drawLine(1, 5, 1);
        drawLine(2, 6, 1);
        drawLine(3, 7, 1);
    }

    void drawLine(int A, int B, int n) {

        Point point1 = new Point(this.Dinh[A][0], this.Dinh[A][1], this.Dinh[A][2]);
        Point point2 = new Point(this.Dinh[B][0], this.Dinh[B][1], this.Dinh[B][2]);

        point1 = chuyen3DThanh2D(point1.x, point1.y, point1.z);
        point2 = chuyen3DThanh2D(point2.x, point2.y, point2.z);

        if (n == 2) {
            this.lineBresenhamNetDut(point1.x, point1.y, point2.x, point2.y);
        } else {
            this.lineBresenhamNetLien(point1.x, point1.y, point2.x, point2.y);
        }


    }

    void lineBresenhamNetDut(int x1, int y1, int x2, int y2) {
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
        x = x1;
        y = y1;

        int xUnit = 1, yUnit = 1;

        if (x2 - x1 < 0)
            xUnit = -xUnit;
        if (y2 - y1 < 0)
            yUnit = -yUnit;
        int c = 1;
        putpixel(x, y);

        if (Dx >= Dy) {
            // Trường hợp này ta chạy vòng lặp while theo biến x

            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) p += 2 * Dy;
                else {
                    p += 2 * (Dy - Dx);
                    y += yUnit;
                }
                x += xUnit;

                if (c < 3) {
                    putpixel(x, y);
                } else
                    c = 0;
                c++;

            }
        } else {
            // Trường hợp này ta chạy vòng lặp while theo biến y

            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) p += 2 * Dx;
                else {
                    p += 2 * (Dx - Dy);
                    x += xUnit;
                }
                y += yUnit;

                if (c < 3) {
                    putpixel(x, y);
                } else
                    c = 0;
                c++;

            }
        }

    }

    void lineBresenhamNetLien(int x1, int y1, int x2, int y2) {
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
        x = x1;
        y = y1;

        int xUnit = 1, yUnit = 1;

        if (x2 - x1 < 0)
            xUnit = -xUnit;
        if (y2 - y1 < 0)
            yUnit = -yUnit;
        putpixel(x, y);

        if (Dx >= Dy) {
            // Trường hợp này ta chạy vòng lặp while theo biến x

            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) p += 2 * Dy;
                else {
                    p += 2 * (Dy - Dx);
                    y += yUnit;
                }
                x += xUnit;
                putpixel(x, y);

            }
        } else {
            // Trường hợp này ta chạy vòng lặp while theo biến y

            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) p += 2 * Dx;
                else {
                    p += 2 * (Dx - Dy);
                    x += xUnit;
                }
                y += yUnit;

                putpixel(x, y);

            }
        }

    }

    public void putpixel(int x, int y) {
        Graphics g = getGraphics();
        int xm = x + 200 / 2;
        int ym = 100 / 2 - y;
        g.setColor(Color.BLACK);
        g.fillRect(xm * 5, ym * 5, 5, 5);
        g.dispose();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawHinhHopChuNhat();

    }
}
