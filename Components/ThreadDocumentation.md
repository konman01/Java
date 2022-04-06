### What is Multitasking

Multitasking is a process of executing multiple tasks simultaneously. We use multitasking to utilize the CPU. Multitasking can be achieved in two ways:

* Process-based Multitasking (Multiprocessing)
* Thread-based Multitasking (Multithreading)

### Difference between Prcocess Based MultiTasking and Thread Based Multitasking

| Process-based Multitasking (Multiprocessing) | Thread-based Multitasking (Multithreading) |
|-----------------------------------------------|--------------------------------------------|
| Multiprocessing creates a separate address space for each process | Multithreading uses a common address space for all the threads|
| multithreading uses a common address space for all the threads. | A process is heavyweight. |
| Switching from one process to another requires some time for saving and loading registers, memory maps, updating lists, etc. | Multiple Process works on same Memory Space |

### Life Cycle of a Thread in Java

The java.lang.Thread class contains a static State enum – which defines its potential states. During any given point of time, the thread can only be in one of these states

* A NEW Thread (or a Born Thread) is a thread that's been created but not yet started. It remains in this state until we start it using the start() method.
* When we've created a new thread and called the start() method on that, it's moved from NEW to RUNNABLE state. Threads in this state are either running or ready to run, but they're waiting for resource allocation from the system.
* A thread is in the BLOCKED state when it's currently not eligible to run. It enters this state when it is waiting for a monitor lock and is trying to access a section of code that is locked by some other thread.
* A thread is in WAITING state when it's waiting for some other thread to perform a particular action. According to JavaDocs, any thread can enter this state by calling any one of the following three methods:

object.wait()
thread.join() or
LockSupport.park()

* This is the state of a dead thread. It's in the TERMINATED state when it has either finished execution or was terminated abnormally.

### Java Thread Scheduler

The thread scheduler in Java is an important concept in multi-threading which is part of the JVM. The scheduler decides which thread to pick up for execution and mainly depends on two factors: time-slicing and preemptive scheduling.

A thread scheduler picks up those threads that are in the Runnable state. When there are multiple threads in Runnable state, there is no guarantee which thread it picks up first.

#### Criteria for thread scheduling

Below are the different factors based on which a Java thread scheduler works:

Priority: Every thread has a priority which is an integer value between 1 and 10 where 1 is the lowest and 10 is the highest. Thread scheduler picks up threads first which has a high priority. In case multiple threads have the same priority, then it schedules in a random manner.

Arrival time: Another factor is arrival time which means when the thread is ready for scheduling. Suppose different threads have the same priority, then it considers the arrival time of the threads for pick up. The thread that arrives first or has a larger waiting time will be considered first for scheduling by the thread scheduler.


##### Preemptive scheduling

Generally, the thread scheduler always considers high priority threads for execution. When the processor is already executing a high priority thread, and if another high priority thread comes into the active pool, then the thread scheduler preempts the already executing thread from the processor and moves it to the waiting state, and allows the new high priority thread to execute. This process is known as preemptive scheduling where the currently executing thread is preempted when a higher priority thread enters and the latest thread is given preference.

##### Time slicing scheduling

Time slicing is the process in which the Java thread scheduler assigns a fixed time slot to all threads for execution. The threads execute for a specific time and then re-enters the active pool again. This process continues until the processor executes all the threads. The specific time slot allocated is called a time slice. The scheduler assigns the CPU for each thread based on the time slice. Once the thread execution is complete, it terminates and proceeds with other thread execution.

##### First come first serve based scheduling (FCFS)

First come first serve is similar to a queue where the scheduler picks the thread that came first to the ready pool for execution. In other words, the thread scheduler gives high priority to the threads that have more waiting time or that arrives first at the pool. The thread scheduler in Java considers this factor when there are multiple threads of the same priority and decides which thread to execute first based on the FCFS concept.


#### Working of a thread scheduler in JAVA

A thread scheduler in Java works on different mechanisms like preemptive scheduling, time slicing, etc which we will discuss in detail in this section.

A process consists of several threads where every thread has a priority and waiting time. Based on these 2 factors, the thread scheduler picks up the thread for execution and sends it to the processor.

* Initially, the processor has 3 threads with priority 9,3, and 5. Hence based on the priority, the scheduler picks up Thread 1 with priority 9 and sends it to the processor.
* Next, it picks up Thread 3 with priority 5 for execution.
* Suppose another thread Thread 4 with priority 7 comes into the waiting pool. Now, the scheduler pauses the execution of Thread 3 and preempts it. It then picks up Thread 4 for execution since it has a higher priority. This process is preemptive scheduling.
* Once thread 3 and 4 complete execution and another thread Thread 5 with priority 3 which is the same as Thread 2 enters. Based on the FCFS concept, the scheduler picks up Thread 2 for execution since it has a long waiting time and arrived first.


### How to create thread in Java?
We can create threads in Java by 2 ways, by inheriting the Thread class and overriding the run() method, and by implementing Ruunable interface and providing implementation for run() method. We want to inherit other class, then we have to use the Runnable interface since Java does not support multiple inheritance.


### What is Syncronization?

If there are multiple threads executing on same resource, then it might corrupt the resource. To aviod this we can define a block or function as syncronized so that only once thread will be allowed at a time. When a thread start to execute the Syncronised block, then the block will be locked for other threads and will be released once the tread completes its execution.

There are two types of thread synchronization mutual exclusive and inter-thread communication.

* Mutual Exclusive
	Synchronized method.
	Synchronized block.
	Static synchronization.
* Cooperation (Inter-thread communication in java)

If syncronised ketword is used for a method or a block, then it will be locked and executed by only one thread. Only when the thread compltes its execution, then only other thread can execute it.

### What is the difference between class level lock and object level lock?

#### Object level lock

Object level locking is mechanism when you want to synchronize a non-static method or non-static code block such that only one thread will be able to execute the code block on given instance of the class. This should always be done to make instance level data thread safe. This can be done as below :

```
public class DemoClass 
{ 
  public synchronized void demoMethod(){} 
} 
```
or 

```
public class DemoClass 
{ 
  public void demoMethod(){ 
  synchronized (this) 
  { 
   //other thread safe code 
  } 
 } 
} 

```

or 

```
public class DemoClass 
{ 
  private final Object lock = new Object(); 
  public void demoMethod(){ 
  synchronized (lock) 
 { 
  //other thread safe code 
 } 
} 

```

#### Class level lock

Class level locking prevents multiple threads to enter in synchronized block in any of all available instances on runtime. This means if in runtime there are 100 instances of DemoClass, then only one thread will be able to execute demoMethod() in any one of instance at a time, and all other instances will be locked for other threads. This should always be done to make static data thread safe.

```
public class DemoClass 
{ 
  public synchronized static void demoMethod(){} 
} 

```
or 

```
public class DemoClass 
{ 
  public void demoMethod(){ 
  synchronized (DemoClass.class) 
  { 
   //other thread safe code 
  } 
 } 
} 

```
or 

```
public class DemoClass 
{ 
 private final static Object lock = new Object(); 
 public void demoMethod(){ 
 synchronized (lock) 
  { 
   //other thread safe code 
  } 
 } 
}
```

### If a thread T1 enters a method m1 by obtaining the class level lock, does this mean another thread T2 cannot run a different method m2 by obtaining the object level lock?

Object level lock and Class level locks are different. In above case, T2 can run method m2 by obtaining object level lock. But if m2 is static synchronized, T2 can't invoke m2 method unless T1 release class level lock on method m1.

### Java join() method

When the join() method is invoked, the current thread stops its execution and the thread goes into the wait state. The current thread remains in the wait state until the thread on which the join() method is invoked has achieved its dead state. If interruption of the thread occurs, then it throws the InterruptedException.

````

package com.konman01.threadtest;

class ThreadJoinExample1 extends Thread{
	
	@Override
	public void run() {
		
		//Get the Thread Name
		String threadName = Thread.currentThread().getName();
		
		
		for(int i = 0; i < 5; i++) {
			
			System.out.println(threadName+":"+i);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}

public class ThreadJoinMainExample1{
	
	public static void main(String[] args) {
		
		System.out.println("Main Thread Name is:"+Thread.currentThread().getName());
		
		
		Thread th1 = new ThreadJoinExample1();
		th1.setName("Thread1");
		System.out.println("Starting thread 1");
		th1.start();
		try {
			th1.join();
			// Until Thread1 is completed, the execution will not be continued
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread th2 = new ThreadJoinExample1();
		th2.setName("Thread2");
		System.out.println("Starting Thread2");
		th2.start();
		
		
	}
}

````

output 

```Main Thread Name ismain
Starting thread 1
Thread1:0
Thread1:1
Thread1:2
Thread1:3
Thread1:4
Starting Thread2
Thread2:0
Thread2:1
Thread2:2
Thread2:3
Thread2:4
```

### Priority of a Thread

Each thread has a priority. Priorities are represented by a number between 1 and 10. In most cases, the thread scheduler schedules the threads according to their priority (known as preemptive scheduling).

public final int getPriority(): The java.lang.Thread.getPriority() method returns the priority of the given thread.

public final void setPriority(int newPriority): The java.lang.Thread.setPriority() method updates or assign the priority of the thread to newPriority. The method throws IllegalArgumentException if the value newPriority goes out of the range, which is 1 (minimum) to 10 (maximum).

Default priority of a thread is 5 (Thread.NORM_PRIORITY). The value of Thread.MIN_PRIORITY is 1 and the value of Thread.MAX_PRIORITY is 10.

### Daemon Thread in Java

Daemon thread in Java is a service provider thread that provides services to the user thread. Its life depend on the mercy of user threads i.e. when all the user threads dies, JVM terminates this thread automatically.

There are many java daemon threads running automatically e.g. gc, finalizer etc.

```
public class TestDaemonThread1 extends Thread{  

 public void run(){  
  if(Thread.currentThread().isDaemon()){//checking for daemon thread  
   System.out.println("daemon thread work");  
  }  
  else{  
  System.out.println("user thread work");  
 }  
 }  
 
 public static void main(String[] args){  
  TestDaemonThread1 t1=new TestDaemonThread1();//creating thread  
  TestDaemonThread1 t2=new TestDaemonThread1();  
  TestDaemonThread1 t3=new TestDaemonThread1();  
  
  t1.setDaemon(true);//now t1 is daemon thread  
    
  t1.start();//starting threads  
  t2.start();  
  t3.start();  
 }  
}  

```

### Java Thread Pool
Java Thread pool represents a group of worker threads that are waiting for the job and reused many times.

In the case of a thread pool, a group of fixed-size threads is created. A thread from the thread pool is pulled out and assigned a job by the service provider. After completion of the job, the thread is contained in the thread pool again.


### Points

After starting a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown. In such case, thread will run once but for second time, it will throw exception.


