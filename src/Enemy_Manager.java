package src;

import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import src.GameWorldState;
import src.Megaman;

public class Enemy_Manager {
    private List<Enemy> listOfEnemies;
    private GameWorldState gameWorld;

    public Enemy_Manager(GameWorldState gameWorld) {
        this.gameWorld = gameWorld;
        listOfEnemies = Collections.synchronizedList(new LinkedList<Enemy>());
    }

    public GameWorldState getGameWorld() {
        return gameWorld;
    }

    public void addEnemy(Enemy e) {
        synchronized (listOfEnemies) {
            listOfEnemies.add(e);
        }
    }

    public void removeEnemy(Enemy e) {
        synchronized (listOfEnemies) {
            for (int i = 0; i < listOfEnemies.size(); i++) {
                Enemy enemy = listOfEnemies.get(i);
                if (enemy == e)
                    listOfEnemies.remove(i);
            }
        }
    }

    public Enemy getCollisionMegaman(Megaman man) {
        synchronized (listOfEnemies) {
            for (int i = 0; i < listOfEnemies.size(); i++) {
                Enemy e = listOfEnemies.get(i);
                if (man.getBodyRect().intersects(e.getBoundForCollisionWithEnemy()))
                    return e;
            }
        }
        return null;
    }

    public Enemy getCollisionBullet(Bullet_Megaman bullet) {
        synchronized (listOfEnemies) {
            for (int i = 0; i < listOfEnemies.size(); i++) {
                Enemy e = listOfEnemies.get(i);
                if (bullet.bound().intersects(e.getBoundForCollisionWithEnemy()))
                    return e;
            }
        }
        return null;
    }

    public void UpdateEnemy() {
        synchronized (listOfEnemies) {
            for (int i = 0; i < listOfEnemies.size(); i++) {
                Enemy e = listOfEnemies.get(i);
                if (!e.checkVisible())
                    e.updateState();
                if (e.getState() == 2) // 2 = DEATH
                    listOfEnemies.remove(i);
            }
        }
    }

    public void draw(Graphics2D g2) {
        synchronized (listOfEnemies) {
            for (Enemy e : listOfEnemies) {
                if (!e.checkVisible())
                    e.draw(g2);
            }
        }
    }

    public int getSize() {
        return listOfEnemies.size();
    }
}
