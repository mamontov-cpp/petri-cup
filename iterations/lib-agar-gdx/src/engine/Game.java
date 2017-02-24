package engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Главный класс игры
 */
public class Game extends ApplicationAdapter {

    /**
     * Инициализация ресурсов игры
     */
    @Override
    public void create () {
        m_camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        m_camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        m_camera.update();
        m_current_camera = m_camera;
        
        m_batch = new SpriteBatch();    
        m_ctx = new engine.Graphics2D(m_batch);
        
        this.initResources();
    }    
    
    /**
     * Инициализация ресурсов игры
     */
    public void initResources() { 
        
    }
    
    /**
     * Обновляет состояние игры
     * @param elapsedTime время, прошедшее с предыдущего обновления
     */
    public void update(long elapsedTime) {
        
    }
 
    /**
     * Рендеринг игры
     */
    @Override
    public void render () {
        m_camera.update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update((long) (Gdx.graphics.getDeltaTime() * 1000.0));
        
        m_ctx.begin();
        renderInContext(m_ctx);
        m_ctx.end();
    }
        
    /**
     * Отрисовывет состояние игры
     * @param g 
     */    
    public void renderInContext(engine.Graphics2D g) {
        
    }
    
    /**
     * Освобождение ресурсов игры
     */
    @Override
    public void dispose () {
           TextureManager.disposeTextures();
    }
    
    /**
     * Получение координаты X курсора мыши в окне
     * @return 
     */
    public int getMouseX() {
        return Gdx.input.getX();
    }

    /**
     * Получение координаты Y курсора мыши в окне
     * @return 
     */    
    public int getMouseY() {
        return Gdx.input.getY();
    }
    
    /**
     * Камера
     */
    OrthographicCamera m_camera;
    
    /**
     * Глобальная камера игры для работы с позициями
     */
    static Camera m_current_camera;
    
    /**
     * Batch для рисования
     */
    SpriteBatch m_batch;
    
    /**
     * Контекст
     */
    Graphics2D  m_ctx;
}
