package game.enemy;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject {

    public Vector2D velocity;

    public EnemyShoot enemyShoot;

    public Enemy() {
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((EnemyAttack) this.enemyShoot)
                .bulletEnemies
                .forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
}
