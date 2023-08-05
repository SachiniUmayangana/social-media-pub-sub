/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.bolton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.bolton.services.impl.ChannelObservableImpl;

/**
 *
 * @author sachi
 */
public class ChannelTest {
    ChannelObservableImpl channelImpl = null;
    
   @BeforeEach
    public void init() {
        ChannelObservableImpl channelObservableImpl = new ChannelObservableImpl();
    }
    
    @Test
    public void testIfUserCanCreateChannel(){
        channelImpl.addChannel("Telusko");
        assertEquals(1,ChannelObservableImpl.channelList.size());
    }
    
    @Test
    public void userGetExceptionWhileNotInputChannelName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel name can not be null or empty");
        channel.addChannel("");
        channel.addChannel(null);
    }
    
    @Test
    public void testIfUserGetExceptionWhenCreatingChannelWithEmptyOrNullChannelName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel name can not be null or empty");
        channel.addChannel("");
        channel.addChannel(null);
    }

    @Test
    public void testIfUseGetExceptionWhenCreatingChannelWithDuplicateChannelName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel name already taken!");
        channel.addChannel("Telusko");
        channel.addChannel("Telusko");
    }

    @Test
    public void testIfUserCanRemoveChannel(){
        channel.addChannel("Telusko");
        assertEquals(1,ChannelObservableImpl.channelList.size());
        channel.removeChannel("Telusko");
        assertEquals(0,ChannelObservableImpl.channelList.size());
    }

    @Test
    public void testIfUserGetExceptionWhenRemovingChannelWithEmptyOrNullChannelName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel name can not be null or empty");
        channelObservableImpl.addChannel("Telusko");
        System.out.println(ChannelObservableImpl.channelList.size());
        channelObservableImpl.removeChannel("");
        channelObservableImpl.removeChannel(null);
    }

    @Test
    public void testIfUserCanSubscribeToTheChannel() {
        channelObservableImpl.addChannel("Telusko");
        channelObservableImpl.subscribeToChannel("Telusko", new Subscriber());
        assertEquals(1, ChannelObservableImpl.channels.get("Telusko").size());
    }

    @Test
    public void testIfUserGetExceptionWhenSubscribeToChannelWithEmptyOrNullChannelName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel name can't be empty");
        channelObservableImpl.subscribeToChannel("",new Subscriber());
        channelObservableImpl.subscribeToChannel(null,new Subscriber());
    }

    @Test
    public void testIfUseGetExceptionWhenSubscribeToSameChannelAgain(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("User already subscribed!");
        channelObservableImpl.addChannel("Telusko");
        ChannelObserver subscriber = new Subscriber();
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
    }

    @Test
    public void testIfUseGetExceptionWhenSubscribeToNonExistingChannel(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel Not Found!");
        ChannelObserver subscriber = new Subscriber();
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
    }

    @Test
    public void testIfUserCanUnsubscribeToTheChannel() {
        channelObservableImpl.addChannel("Telusko");
        channelObservableImpl.addChannel("PewDiePie");
        ChannelObserver subscriber = new Subscriber();
        channelObservableImpl.subscribeToChannel("Telusko", subscriber);
        channelObservableImpl.subscribeToChannel("PewDiePie", subscriber);
        channelObservableImpl.unSubscribe("a",subscriber);
        assertEquals(0, ChannelObservableImpl.channels.get("PewDiePie").size());
    }

    @Test
    public void testIfUserGetExceptionWhenUnsubscribeToChannelWithEmptyOrNullChannelName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel Not Found!");
        channelObservableImpl.addChannel("Telusko");
        channelObservableImpl.addChannel("PewDiePie");
        ChannelObserver subscriber = new Subscriber();
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
        channelObservableImpl.unSubscribe("",subscriber);
        channelObservableImpl.unSubscribe(null,subscriber);
    }

    @Test
    public void testIfUseGetExceptionWhenUnsubscribeToSameChannelAgain(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("User not subscribed!");
        channelObservableImpl.addChannel("Telusko");
        ChannelObserver subscriber = new Subscriber();
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
        channelObservableImpl.unSubscribe("Telusko",subscriber);
        channelObservableImpl.unSubscribe("Telusko",subscriber);
    }

    @Test
    public void testIfUseGetExceptionWhenUnsubscribeToNonExistingChannel(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Channel Not Found!");
        ChannelObserver subscriber = new Subscriber();
        channelObservableImpl.addChannel("Telusko");
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
        channelObservableImpl.unSubscribe("PewDiePie",subscriber);
    }

    @Test
    public void testIfChannelNameAlreadyTaken(){
        channelObservableImpl.addChannel("Telusko");
        boolean a = channelObservableImpl.checkChannelName("Telusko");
        assertTrue(a);
    }

    @Test
    public void testIfSubscriberReceiveChannelMessage(){
        channelObservableImpl.addChannel("Telusko");
        ChannelObserver subscriber = a -> {
            System.out.println(a);
            assertEquals("Test Message",a);
        };
        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
        channelObservableImpl.sendMessage("Telusko","Test Message");
    }
}
