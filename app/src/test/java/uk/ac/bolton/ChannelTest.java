///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package uk.ac.bolton;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import uk.ac.bolton.services.impl.ChannelObservableImpl;
//
///**
// *
// * @author sachi
// */
//public class ChannelTest {
//    ChannelObservableImpl channelImpl = null;
//    
//   @BeforeEach
//    public void init() {
//        ChannelObservableImpl channelObservableImpl = new ChannelObservableImpl();
//    }
//    
//    @Test
//    public void testIfUserCanCreateChannel(){
//        channelImpl.addChannel("Telusko");
//        assertEquals(1,ChannelObservableImpl.channelList.size());
//    }
//    
//    @Test
//    public void userGetExceptionWhileNotInputChannelName(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Channel name can not be null or empty");
//        channel.addChannel("");
//        channel.addChannel(null);
//    }
//
//    @Test
//    public void userGetExceptionWhileDuplicatingChannelName(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Channel name already taken!");
//        channel.addChannel("Telusko");
//        channel.addChannel("Telusko");
//    }
//
//    @Test
//    public void userRemoveChanel(){
//        channel.addChannel("Telusko");
//        assertEquals(1,ChannelObservableImpl.channelList.size());
//        channel.removeChannel("Telusko");
//        assertEquals(0,ChannelObservableImpl.channelList.size());
//    }
//
//    @Test
//    public void userGetExceptionWhileNullOrEmptyUserName(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Channel name can not be null or empty");
//        channelObservableImpl.addChannel("Telusko");
//        System.out.println(ChannelObservableImpl.channelList.size());
//        channelObservableImpl.removeChannel("");
//        channelObservableImpl.removeChannel(null);
//    }
//
//    @Test
//    public void userCanSubscribeChannel() {
//        channelObservableImpl.addChannel("Telusko");
//        channelObservableImpl.subscribeToChannel("Telusko", new Subscriber());
//        assertEquals(1, ChannelObservableImpl.channels.get("Telusko").size());
//    }
//
//    @Test
//    public void userGetExceptionWhileEmptyUserNameWithChannelSubcription(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Channel name can't be empty");
//        channelObservableImpl.subscribeToChannel("",new Subscriber());
//        channelObservableImpl.subscribeToChannel(null,new Subscriber());
//    }
//
//    @Test
//    public void userGetExceptionDuplicationSubcription(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("User already subscribed!");
//        channelObservableImpl.addChannel("Telusko");
//        ChannelObserver subscriber = new Subscriber();
//        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
//        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
//    }
//
//    @Test
//    public void userGetExceptionWhileSubscribingNonExistingChannels(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Channel Not Found!");
//        ChannelObserver subscriber = new Subscriber();
//        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
//    }
//
//    @Test
//    public void userCanSubscribeToChannel() {
//        channelObservableImpl.addChannel("Telusko");
//        channelObservableImpl.addChannel("PewDiePie");
//        ChannelObserver subscriber = new Subscriber();
//        channelObservableImpl.subscribeToChannel("Telusko", subscriber);
//        channelObservableImpl.subscribeToChannel("PewDiePie", subscriber);
//        channelObservableImpl.unSubscribe("a",subscriber);
//        assertEquals(0, ChannelObservableImpl.channels.get("PewDiePie").size());
//    }
//
//    @Test
//    public void userGetExceptionWhileSuscribingNotExistingChannel(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Channel Not Found!");
//        channelObservableImpl.addChannel("Telusko");
//        channelObservableImpl.addChannel("PewDiePie");
//        ChannelObserver subscriber = new Subscriber();
//        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
//        channelObservableImpl.unSubscribe("",subscriber);
//        channelObservableImpl.unSubscribe(null,subscriber);
//    }
//
//    @Test
//    public void userGetExceptionWhileSameChannelSubscribeAgain(){
//        exceptionRule.expect(RuntimeException.class);
//        exceptionRule.expectMessage("Same Channel Subscribe Again!");
//        channelObservableImpl.addChannel("Telusko");
//        ChannelObserver subscriber = new Subscriber();
//        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
//        channelObservableImpl.unSubscribe("Telusko",subscriber);
//        channelObservableImpl.unSubscribe("Telusko",subscriber);
//    }
//
//    @Test
//    public void userGetExceptionChannelNameAlreadyTaken(){
//        channelObservableImpl.addChannel("Telusko");
//        boolean a = channelObservableImpl.checkChannelName("Telusko");
//        assertTrue(a);
//    }
//
//    @Test
//    public void subscriberRecievedNotification(){
//        channelObservableImpl.addChannel("Telusko");
//        ChannelObserver subscriber = a -> {
//            System.out.println(a);
//            assertEquals("Test Message",a);
//        };
//        channelObservableImpl.subscribeToChannel("Telusko",subscriber);
//        channelObservableImpl.sendMessage("Telusko","Test Message");
//    }
//}
