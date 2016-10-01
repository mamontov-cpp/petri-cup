package game;

import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ImageBackground;
import com.golden.gamedev.object.font.SystemFont;
import game.controllers.AIController;
import game.controllers.Controller;
import game.controllers.PlayerController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 */
public class Game extends com.golden.gamedev.Game {
    /**
     * Фон игры
     */
    private ImageBackground bg;
    /**
     * Картинка с бочкой для препятствия
     */
    private BufferedImage barrelImage;
    /**
     * Картинка для агара
     */
    private BufferedImage agarImage;

    /**
     * Группа объектов, участвующих в коллизиях
     */
    private final SpriteGroup spriteGroup = new SpriteGroup("Objects");
    /**
     * Группа бочек
     */
    private final SpriteGroup barrelGroup = new SpriteGroup("Barrels");
    /**
     * Группа агара
     */
    private final SpriteGroup agarGroup = new SpriteGroup("Agar");
    /**
     * Требуемое число агара
     */
    private final int requiredAgarQuantity = 200;
    /**
     * Спрайт игрока
     */
    private Sprite playerSprite;
    /**
     * Список контроллеров
     */
    private final List<Controller> controllers = new ArrayList<>();
    /**
     * Число ботов
     */
    private final int botsCount = 3;
    /**
     * Менеджер коллизий
     */
    private CollisionManager manager;
    
    /**
     * Текущее время последнего респауна
     */
    private long lastRespawnTime = 0;
    /**
     * Период для респауна агара
     */
    private final long respawnPeriod = 4000;   
    /**
     * Число агара для респауна за раз
     */
    private final int agarRespawnQuantity = 5;
    /**
     * Число собранного агара
     */
    private int agarCollected = 0;
    /**
     * Шрифт для отображения счета съеденного агара
     */
    private SystemFont fnt;
    
    @Override
    public void initResources() { 
        try {
            fnt = new SystemFont(new Font("Courier New", Font.BOLD, 20), Color.BLACK);
            BufferedImage playerImage = ImageIO.read(new File("resources/PRIMITIVE_PLANT.png"));
            BufferedImage botImage = ImageIO.read(new File("resources/PRIMITIVE_ANIMAL.png"));
            barrelImage = ImageIO.read(new File("resources/BARREL.png"));
            agarImage = game.images.Agar.image();
            
            playerSprite = new Sprite();
            playerSprite.setSpeed(0.1);
            playerSprite.setColor(Color.GREEN);
            playerSprite.setIcon(playerImage);
            playerSprite.setPosition(new Point(320, 240));

            Random r = new Random();
            for(int i = 0; i < 3; i++)
            {
                Sprite botSprite = new Sprite();
                botSprite.setSpeed(0.1);
                botSprite.setColor(Color.GREEN);
                botSprite.setIcon(botImage);
                botSprite.setPosition(new Point(160 + r.nextInt(320), 120 + r.nextInt(240)));
                spriteGroup.add(botSprite);
                controllers.add(new AIController(this, botSprite, playerSprite));
            }
            
            
            bg = new ImageBackground(ImageIO.read(new File("resources/background.jpg")));
            bg.setClip(0, 0, this.dimensions().width, this.dimensions().height);

            spriteGroup.setBackground(bg);            
            spriteGroup.add(playerSprite);
            
            controllers.add(new PlayerController(this, playerSprite));
            SpriteGroup[] groupsForBarrel = { spriteGroup };
            this.spawnSpritesAroundPlayer(barrelImage, playerSprite, 2000, 20, barrelGroup, groupsForBarrel);
            barrelGroup.setBackground(bg);
            
            agarGroup.setBackground(bg);
            this.trySpawnAgar();
            
            manager = new CollisionManager(this, spriteGroup, barrelGroup, agarGroup);
        } catch (IOException ex) {
            Logger.getLogger("main").log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Возвращает спрайт игрока
     * @return спрайт игрока
     */
    public Sprite playerSprite() {
        return playerSprite;
    }
    
    /**
     * Увеличивает число собранного агара
     */
    public void incrementCollectedAgar() {
        agarCollected += 1;
    }

    @Override
    public void update(long elapsedTime) {
        controllers.stream().forEach((controller) -> {
            controller.update(elapsedTime);
        });        
        spriteGroup.update(elapsedTime);        
        bg.update(elapsedTime);
        long curTime = System.nanoTime();
        if ((curTime - lastRespawnTime) / 1.0E+6 >= this.respawnPeriod) {
            this.trySpawnAgar();
        }
        manager.checkCollision();
    }

    @Override
    public void render(Graphics2D g) {
        bg.render(g);                       
        agarGroup.render(g);
        spriteGroup.render(g);
        barrelGroup.render(g);
        fnt.drawString(g, "Agar collected: " + String.valueOf(this.agarCollected), 20, 20);
        if (playerSprite != null)
        {
            bg.setToCenter(playerSprite);
        }
    }
    
    /**
     * Текущая позиция координат мыши
     * @return 
     */
    public Point mousePosition() {
        Point p = new Point(this.getMouseX(), this.getMouseY());
        p.x += bg.getX();
        p.y += bg.getY();
        return p;
    }
    
    /**
     * Возвращает размеры окна для изображения
     * @return 
     */
    public Dimension dimensions() {
        return new Dimension(640, 480);
    }
    
    /**
     * Добавляет в игру агар, если он необходим
     */
    private void trySpawnAgar() {
        lastRespawnTime = System.nanoTime();
        if (agarGroup.getSprites().length < this.requiredAgarQuantity) {
            SpriteGroup[] groupsForAgar = { spriteGroup, barrelGroup };
            this.spawnSpritesAroundPlayer(agarImage, playerSprite, 1000, 20, agarGroup, groupsForAgar);                
        }        
    }
    /**
     * Порождает спрайты в радиусе игрока
     * @param image изображение
     * @param player спрайт игрока
     * @param radius радиус
     * @param quantity число
     * @param targetGroup группа, куда положить спрайты
     * @param groups другие группы с которыми не надо пересекаться
     */
    public void spawnSpritesAroundPlayer(
        BufferedImage image,
        Sprite player,
        int radius,
        int quantity,
        SpriteGroup targetGroup,
        SpriteGroup[] groups
    )
    {
        int generated = 0;
        Random r1 = new Random();
        Random r2 = new Random(); 
        List<com.golden.gamedev.object.Sprite> l = new ArrayList<>();
        while(generated < quantity) {
            int x = r1.nextInt(radius) - (radius / 2);
            int y = r2.nextInt(radius) - (radius / 2);
            if (x > 0) {
                x += player.getX() + player.getWidth();
            } else {
                x -= player.getX();
            }
            
            
            if (y > 0) {
                y += player.getY() + player.getHeight();
            } else {
                y -= player.getY();
            }
            com.golden.gamedev.object.Sprite s = new com.golden.gamedev.object.Sprite(image, x, y);
            boolean collide = false;
            for (SpriteGroup group : groups) {
                com.golden.gamedev.object.Sprite[] sprites = group.getSprites();
                for(com.golden.gamedev.object.Sprite spt : sprites) {
                    if (spt != null) {
                        collide = collide || GameMath.collide(spt, s);
                    }
                }
            }
            for (com.golden.gamedev.object.Sprite l1 : l) {
                collide = collide || GameMath.collide(l1, s);
            }
           
            if (!collide) {
                generated += 1;
                targetGroup.add(s);
                l.add(s);
            }
        }
    }
    
    /**
     * Полная ширина поля
     */
    public static int totalWidth = 6000;
    /**
     * Полная высота поля
     */
    public static int totalHeight = 6000;
}
