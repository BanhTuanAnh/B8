package base;

import game.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class GameObjectManager {//chi can 1 vaf goij bat ky dau
    public List<GameObject>list;
    private List<GameObject>tempList;
    static public GameObjectManager instance = new GameObjectManager();//design patern single tern
    private GameObjectManager() {
        tempList=new ArrayList<>();
        this.list = new ArrayList<>();
    }
    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }
    public void runAll(){
        this.list.forEach(gameObject ->gameObject.run());
        this.list.addAll(tempList);
        tempList.clear();
    }
    public Vector2D playerPosition(){
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getClass()==Player.class){
                return list.get(i).position;
            }
        }
        return null;
    }
    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }
}

