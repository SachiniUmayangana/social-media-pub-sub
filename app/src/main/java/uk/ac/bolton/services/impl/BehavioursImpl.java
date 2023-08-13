/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.bolton.services.impl;

import uk.ac.bolton.view.ProfileForm;
import uk.ac.bolton.service.Behaviours;

/**
 *
 * @author sachi
 */
public class BehavioursImpl implements Behaviours {

    @Override
    public void addSubscribers(String userName, ProfileForm userProfile) {
        ObservableImpl.userProfileList.put(userName, userProfile);
    }

    @Override
    public void removeSubscribers(String userName) {
        ObservableImpl.userProfileList.remove(userName);
    }
    
}
