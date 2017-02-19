package game;

import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Математические функции, используемые в игре
 */
public class GameMath {
    
    /**
     * Переводит угол из градусов в радианы
     * @param angle угол в градусах
     * @return угол в радианах
     */
    public static double degreesToRadians(int angle) {
        return angle * Math.PI / 180.0;
    }
    
    /**
     * Переводит угол из радианов в градусы
     * @param angle угол в радианах
     * @return угол в градусах
     */
    public static int radiansToDegrees(double angle) {
        return (int) (angle * 180.0 / Math.PI);
    }
    
    /**
     * Возвращает расстояние между двумя точками
     * @param x1 координата х первой точки
     * @param y1 координата y первой точки
     * @param x2 координата х второй точки
     * @param y2 координата y второй точки
     * @return 
     */
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    /**
     * Возвращает расстояние между двумя точками
     * @param p1 координаты первой точки
     * @param p2 координаты второй точки
     * @return 
     */
    public static double distance(Point p1, Point p2) {
        return GameMath.distance(p1.x, p1.y, p2.x, p2.y);
    }
    
    /**
     * Возвращает угол между двумя точками относительно восточного направления
     * @param p1 первая точка
     * @param p2 вторая точка
     * @return угол между точками в градусах
     */
    public static int angle(Point p1, Point p2) {
        int angle = radiansToDegrees(Math.atan((p2.y - p1.y) / (double)(p2.x - p1.x)));
        if (p2.x < p1.x)
            angle += 180;
        return angle;
    }
    
    /**
     * Возвращает точку на том же расстоянии от центра, что и переданая,
     * но в противоположном от центра направлении
     * @param p точка, для которой надо определить противоположную
     * @param center центр, относительно которого будет строиться противоположная точка
     * @return противоположная точка
     */
    public static Point getOppositePoint(Point p, Point center) {
        int newX = p.x - 2 * (p.x - center.x);
        int newY = p.y - 2 * (p.y - center.y);
        return new Point(newX, newY);
    }
    /**
     * Возвращает центр спрайта
     * @param s спрайт
     * @return 
     */
    public static Point getCenter(com.golden.gamedev.object.Sprite s)  {
        return new Point(
            (int)(s.getX() + s.getWidth() / 2), 
            (int)(s.getY() + s.getHeight() / 2)
        );
    }
    /**
     * Определяет, пересекаются ли два спрайта
     * @param s1 первый спрайт
     * @param s2 второй спрайт
     * @return пересекаются ли спрайты
     */
    public static boolean collide(
        com.golden.gamedev.object.Sprite s1,
        com.golden.gamedev.object.Sprite s2
    )  {
        Point center1 = GameMath.getCenter(s1);
        Point center2 = GameMath.getCenter(s2);
        double radiussum = s1.getWidth() / 2.0 + s2.getWidth() / 2.0;
        double distance = GameMath.distance(center1, center2);
        return distance <= radiussum;
    }
    
    /**
     * Проверяет не является ли число близким к 0
     * @param a
     * @return 
     */
    public static boolean isFuzzyZero(
        double a
    ) {
        return Math.abs(a) < 0.001;
    }
}
