package com.company;

import java.awt.*;

public class DrawLine extends Canvas {
    int i, j;

    public DrawLine() {
//        setSize(1000, 500);
//        setBackground(Color.cyan);
    }

    public void putpixel(int x, int y) {
        Graphics g = getGraphics();
        int xm = x + 200 / 2;
        int ym = 100 / 2 - y;
        g.setColor(Color.BLACK);
        g.fillRect(xm * 5, ym * 5, 5, 5);
        g.dispose();
    }

    void LineBres(int x1, int y1, int x2, int y2) {
        int Dx, Dy, p, Const1, Const2;
        int x, y;

        Dx = x2 - x1;
        Dy = y2 - y1;
        p = 2 * Dy - Dx;    //   (Dy <<1)  - Dx
        Const1 = 2 * Dy;        // Dy <<1
        Const2 = 2 * (Dy - Dx);    // (Dy-Dx) <<1
        x = x1;
        y = y1;
        int c = 1;
        putpixel(x, y);
        for (i = x1; i < x2; i++) {
            if (p < 0) p += Const1;
            else {
                p += Const2;
                y++;
            }
            x++;
            if (c < 3) {
                putpixel(x, y);
            } else
                c = 0;
            c++;
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

    void drawHCN(int x1, int y1, int x2, int y2) {
        lineBresenhamNetLien(x1,y1,x1,y2);
        lineBresenhamNetLien(x1,y2,x2,y2);
        lineBresenhamNetLien(x2,y2,x2,y1);
        lineBresenhamNetLien(x2,y1,x1,y1);

    }
void drawMuiTen(int x1, int y1, int x2, int y2 )
{
    lineBresenhamNetLien(x1,y1,x2,y2);
    lineBresenhamNetLien(x2-3,y2-3,x2,y2);
    lineBresenhamNetLien(x2+3,y2-3,x2,y2);
}
    void drawCoordinate() {
        Graphics g = getGraphics();
        g.drawLine(500, 0, 500, 500);
        g.drawLine(0, 250, 1000, 250);
    }

    int x1 = 10, y1 = 10, x2 = -50, y2 = -50;

    //Canvas chay paint sau khi tao. Ham paint trong Canvas
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCoordinate();
//        lineBresenham(x1, y1, x2, y2);

    }

}
