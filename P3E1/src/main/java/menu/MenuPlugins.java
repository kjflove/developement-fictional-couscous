package menu;

import menu.plugin.BasePlugin;

/**
 * Class description ...
 * Included in menu
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jan 2017
 */
public class MenuPlugins {

    private BasePlugin[] arrayPlugins;

    public MenuPlugins(BasePlugin... plugs){
        arrayPlugins = plugs;
    }

    public BasePlugin[] getPlugins() {
        return arrayPlugins;
    }

}
