package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Vector;

public class EnemyFollow extends GameObject {

    public Vector2D velocity;

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/star.png", 20, 20);
    }
    public void run() {
        super.run();
        update();
        this.position.addUp(this.velocity);
    }
    public void update() {
        this.velocity.set(
                    GameObjectManager.instance.playerPosition().subtract(this.position).normalized()
            ).multiply(1.5f);
    }
}
