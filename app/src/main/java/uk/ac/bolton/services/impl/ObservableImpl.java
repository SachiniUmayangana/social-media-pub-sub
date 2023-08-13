/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.bolton.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import uk.ac.bolton.view.ProfileForm;
import uk.ac.bolton.service.Observable;

/**
 *
 * @author sachi
 */
public class ObservableImpl implements Observable {
    
    public static Map<String, ProfileForm> userProfileList = new HashMap<>();

    @Override
    public void updateTheTimeLine(String content) {
        Set<String> keySet = userProfileList.keySet();
        
        for (String userName : keySet) {
            userProfileList.get(userName).getTxtAreaTimeLine().append(userProfileList.get(userName).getCmbChannels().getSelectedItem() + ": " + content + "\n");
        }
    }
}
