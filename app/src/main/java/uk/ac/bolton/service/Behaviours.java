/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.bolton.service;

import uk.ac.bolton.view.ProfileForm;

/**
 *
 * @author sachi
 */
public interface Behaviours {
    
    void addSubscribers(String userName, ProfileForm userProfile);
    
    void removeSubscribers(String userName);
}
