/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.bolton;

import uk.ac.bolton.services.ChannelObservable;
import uk.ac.bolton.services.impl.ChannelObservableImpl;
import uk.ac.bolton.view.HomePageForm;

/**
 *
 * @author sachi
 */
public class AppInitializer {
    public static void main(String[] args) {
        ChannelObservable channelObservable = new ChannelObservableImpl();
        
        new HomePageForm(channelObservable).setVisible(true);
    }
}
