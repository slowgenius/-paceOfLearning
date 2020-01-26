package slowgenius.designPatterns.creationalPatterns.factoryPattern.demo;

/**
 * @author slowgenius
 * @date 2019/12/14 18:52
 * @description
 */
public class TheChineseFeastChef extends Chef{

    public Menu cookDishes() {
        return new TheChineseFeast();
    }

}
