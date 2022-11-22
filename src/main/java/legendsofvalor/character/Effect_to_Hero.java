package character;

import Hero;

public interface Effect_to_Hero {

    /**我觉得不如分开给cell和potion各自写各自的effect。理论上是执行了这样一个interface但是会导致用的时候名字相同*/

    /**目前的每个属性都写一个class我觉得很没必要，而且很难根据hero本身来操作数值和影响。坚持要用吗？*/
    void effect(Hero hero);

}
