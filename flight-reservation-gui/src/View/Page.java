package View;

import Controller.*;

public  interface Page {
    //  method declaration without a body
    public void run();
    
    // Center the component
    public default int centerComponent(int window_width, int x) {
        int x_coordinate = (x - window_width) / 2;
        return x_coordinate;
    }
    
}
