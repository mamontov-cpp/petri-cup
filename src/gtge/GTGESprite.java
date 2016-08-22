/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import com.golden.gamedev.object.Sprite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import lml.GameMath;
import model.Dish;
import model.dishobjects.SpriteModel;
import view.SpriteView;

/**
 * Мост между спрайтом GTGE и интерфейсами модели и представления
 */
public class GTGESprite extends Sprite implements SpriteModel, SpriteView {

    /**
     * Размер объекта
     */
    private int size;
    
    /**
     * Цвет объекта
     */
    private Color color = null;
    
    /**
     * Иконка объекта
     */
    private BufferedImage icon = null;
    
    /**
     * Угол перемещения относительно восточного направления
     */
    private int angle = 0;
    
    /**
     * Скорость перемещения объекта
     */
    private double speed = 0;
    
    /**
     * Графика для отрисовки
     */
    private Graphics2D g2d;
    
    @Override
    public void update(long l) {
        // Проверить на выход за границы поля
        if (getX() <= 0 && getHorizontalSpeed() < 0)
            setHorizontalSpeed(0);
        if (getX() + getWidth() >= Dish.fieldWidth && getHorizontalSpeed() > 0)
            setHorizontalSpeed(0);
        if (getY() <= 0 && getVerticalSpeed() < 0)
            setVerticalSpeed(0);
        if (getY() + getHeight() >= Dish.fieldHeight && getVerticalSpeed() > 0)
            setVerticalSpeed(0);
        
        super.update(l);
    }
    
    // Перерисовать фон объекта
    private void repaint() {
        if (color != null) {
            // Зарисовать площадь нужным цветом
            BufferedImage bi = new BufferedImage(getSize(), getSize(), BufferedImage.TYPE_INT_ARGB);
            g2d = bi.createGraphics();
            g2d.setColor(color);
            g2d.fillOval(0, 0, bi.getWidth(), bi.getHeight());

            // Обозначить периметр
            g2d.setColor(color.darker().darker());
            g2d.setStroke(new BasicStroke(2));
            g2d.drawOval(1, 1, getSize()-2, getSize()-2);
            this.setImage(bi);

            if (icon != null) {
                int newWidth = icon.getWidth() * getSize() / icon.getHeight();
                int newHeight = getSize();
                g2d.drawImage(icon.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT), (getWidth() - newWidth) / 2, (getHeight() - newHeight) / 2, null);
            }
        }
    }
    
    @Override
    public void setPosition(Point position) {
        this.setX(position.getX() - size / 2);
        this.setY(position.getY() - size / 2);
    }

    @Override
    public Point getPosition() {
        Point position = new Point();
        position.x = (int) (getX() + size / 2);
        position.y = (int) (getY() + size / 2);
        
        return position;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
        setHorizontalSpeed(speed * Math.cos(GameMath.degreesToRadians(angle)));
        setVerticalSpeed(speed * Math.sin(GameMath.degreesToRadians(angle)));
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    public void setIcon(BufferedImage icon) {
        this.icon = icon;
        repaint();
    }

    @Override
    public void setSize(int size) {
        this.size = size;
        repaint();
    }

    /**
     * Получить размер объекта
     * @return размер объекта
     */
    public int getSize() {
        return size;
    }

    @Override
    public void setDirection(int angle) {
        this.angle = angle;
    }

    @Override
    public int getDirection() {
        return angle;
    }
}
