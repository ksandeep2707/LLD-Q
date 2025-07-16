
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Windows w=new Windows();
        //tightly coupled with the contreate class
        WiredKeyboard1 k=new WiredKeyboard1();
        WiredMouse1 m=new WiredMouse1();
        WirelessKeyboard wk=new WirelessKeyboard();
        WirelessMouse wm=new WirelessMouse();

        Window nw=new Window(k, m);
        Window wd=new Window(wk, wm);
        //Same class can be used for wired and wireless devices
        //No need to touch window class but in above case we will hav to change the class to suppose wireless devices.
        

    }
}

//Code without DIP
class WiredKeyboard{

}
class WiredMouse{

}

class Windows{
    WiredKeyboard keyboard;
    WiredMouse mouse;

    Windows()
    {
        keyboard=new WiredKeyboard();
        mouse=new WiredMouse();//dependency on the concreate classes
    }
}
//SOme day i want to extend this class to suppose wireless keyboard and mouse.
//For this change only you will have to change this class because this class is tighlty coupled with concreate class. So scalablity of the code is very low.

//Code using DIP
//Rather then depending on the concreate class you should depend on the Interface.

interface keyboard{

}

interface Mouse{

}

class WiredKeyboard1 implements keyboard{

}

class WirelessKeyboard implements keyboard{

}

class WiredMouse1 implements Mouse{

}

class WirelessMouse implements Mouse{

}


class Window {
    keyboard keyboard;
    Mouse mouse;

    Window(keyboard keyboard,Mouse mouse)
    {
        this.keyboard=keyboard;
        this.mouse=mouse;
    }

}

