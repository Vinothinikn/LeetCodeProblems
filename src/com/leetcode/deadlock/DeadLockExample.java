package com.leetcode.deadlock;

public class DeadLockExample {
	
	class Track1{
		
		synchronized void crossTrack2(Track2 t2) {
			System.out.println("Train on Track 1 crossing Track2: "+Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				System.err.println(e.getMessage());
			}
			t2.clearTrack();
		}
		
		synchronized void clearTrack() {
			System.out.println(" Track1 clear");
		}
	}
	class Track2{
		
		synchronized void crossTrack1(Track1 t1) {
			System.out.println("Train on Track 2 crossing Track1: "+Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				System.err.println(e.getMessage());
			}
			t1.clearTrack();
		}
		
		synchronized void clearTrack() {
			System.out.println(" Track2 clear");
		}
		
	}
	public static void main(String[] args) {
		DeadLockExample ex = new DeadLockExample();
		Track1 t1 = ex.new Track1();
		Track2 t2 = ex.new Track2();
		Runnable r1 = ()-> {
			synchronized (t2) {
				t1.crossTrack2(t2);
			}
			
		};
		Runnable r2 = ()->{
			synchronized (t1) {
				t2.crossTrack1(t1);
			}
		
		};
		Thread th1 = new Thread(r1, "Train1");
		Thread th2 = new Thread(r2, "Train2");
		th1.start();
		th2.start();

	}

}
