package com.bank.sample.java8.programming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OracleIterviewMultiThreading {

//	1. how to print even and odd numbers in sync order using 2 threads in java.

//	using java1.7 create a class and either implements Runnable/Callable or extends with thread.

	static class ThreadChecker implements Runnable {

		static int count = 0; // created count obj for while loop.
		Object obj;

		public ThreadChecker(Object obj) {
			super();
			this.obj = obj;
		}

		@Override
		public void run() {
			while (count <= 10) {
				if (count % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("even")) {
					synchronized (obj) { // synchronized will help in attaining thread execution one by one.
						System.out.println("Thread name :: " + Thread.currentThread().getName() + " value :: " + count);
						count++;
						try {
							obj.wait(); // wait until second operations is done.
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				if (count % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("odd")) {
					synchronized (obj) {
						System.out.println("Thread name :: " + Thread.currentThread().getName() + " value :: " + count);
						count++;
						obj.notify(); // wil notify once the execution of thread is complete.
					}
				}

			}
		}
	}

	public static void main(String[] args) {
//		1. how to print even and odd numbers in sync order using 2 threads in java.

//		using traditional approach.

		Object lock = new Object();
//		2 threads since 2 threads required to perform this task.
		Runnable r1 = new ThreadChecker(lock);
		Runnable r2 = new ThreadChecker(lock);

		new Thread(r1, "even").start();
		new Thread(r2, "odd").start();

//		Using java 8 Executor Service and completable feature.

		ExecutorService exService = Executors.newFixedThreadPool(2);

		IntStream.rangeClosed(1, 10).forEach(s -> {
			CompletableFuture<Integer> evenCompletableFeature = CompletableFuture.completedFuture(s)
					.thenApplyAsync(x -> {
						if (x % 2 == 0) {
							System.out.println("Thread Name :: " + Thread.currentThread().getName() + " value :: " + x);
						}
						return s;
					}, exService);
			evenCompletableFeature.join();

			CompletableFuture<Integer> oddCompletableFeature = CompletableFuture.completedFuture(s)
					.thenApplyAsync(x -> {
						if (x % 2 != 0) {
							System.out.println("Thread Name :: " + Thread.currentThread().getName() + " value :: " + x);
						}
						return s;
					}, exService);
			oddCompletableFeature.join();

		});
	}
}
