/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import engine.CollisionMath;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Satu
 */
public class CollisionTest {
    
    public CollisionTest() {
    }


    @Test
    public void testCollision() {
        // Начало координат, круг
        {
            double k1 = 0;
            double k2 = 1;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 1;
            double b = 1;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, -1.0, 0.001);
            Assert.assertEquals(pair.y1, 0.0, 0.001);
            Assert.assertEquals(pair.x2, 1.0, 0.001);
            Assert.assertEquals(pair.y2, 0.0, 0.001);            
        }
        {
            double k1 = 1;
            double k2 = 0;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 2;
            double b = 2;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, 0.0, 0.001);
            Assert.assertEquals(pair.y1, 2.0, 0.001);
            Assert.assertEquals(pair.x2, 0.0, 0.001);
            Assert.assertEquals(pair.y2, -2.0, 0.001);            
        }
        // Начало координат, эллипс
        {
            double k1 = 0;
            double k2 = 1;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 2;
            double b = 1;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, -2.0, 0.001);
            Assert.assertEquals(pair.y1, 0.0, 0.001);
            Assert.assertEquals(pair.x2, 2.0, 0.001);
            Assert.assertEquals(pair.y2, 0.0, 0.001);            
        }
        {
            double k1 = 1;
            double k2 = 0;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 1;
            double b = 2;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, 0.0, 0.001);
            Assert.assertEquals(pair.y1, 2.0, 0.001);
            Assert.assertEquals(pair.x2, 0.0, 0.001);
            Assert.assertEquals(pair.y2, -2.0, 0.001);            
        }
        // Смещение кординат
        {
            double k1 = 0;
            double k2 = 1;
            double k3 = 3;
            double x0 = 2;
            double y0 = 3;
            double a = 2;
            double b = 1;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, 0.0, 0.001);
            Assert.assertEquals(pair.y1, 3.0, 0.001);
            Assert.assertEquals(pair.x2, 4.0, 0.001);
            Assert.assertEquals(pair.y2, 3.0, 0.001);            
        }
        {
            double k1 = 1;
            double k2 = 0;
            double k3 = 2;
            double x0 = 2;
            double y0 = 3;
            double a = 1;
            double b = 2;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, 2.0, 0.001);
            Assert.assertEquals(pair.y1, 5.0, 0.001);
            Assert.assertEquals(pair.x2, 2.0, 0.001);
            Assert.assertEquals(pair.y2, 1.0, 0.001);            
        }
        // Диагональ
        {
            double k1 = 1;
            double k2 = -1;
            double k3 = 0;
            double x0 = 2;
            double y0 = 2;
            double a = 2;
            double b = 2;
            CollisionMath.CollisionPointPair pair = CollisionMath.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            Assert.assertEquals(pair.x1, 3.4142, 0.001);
            Assert.assertEquals(pair.y1, 3.4142, 0.001);
            Assert.assertEquals(pair.x2, 0.5857, 0.001);
            Assert.assertEquals(pair.y2, 0.5857, 0.001);            
        }
    }
}
