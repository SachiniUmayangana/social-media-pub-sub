/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.bolton;

import java.util.ArrayList;
import java.util.List;
import uk.ac.bolton.view.LoginForm;
import uk.ac.bolton.view.NewChannelForm;
import uk.ac.bolton.view.custom.SuperChannel;

/**
 *
 * @author sachi
 */
public class AppInitializer {
    private static final List<SuperChannel> list = new ArrayList<>();
    
    static {
        list.add(new NewChannelForm());
    }
    
    public static void main(String[] args) {        
        new LoginForm().setVisible(true);
        channelInit();
    }
    
     private static void channelInit() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).displayChannel(true);
        }
    }
}
