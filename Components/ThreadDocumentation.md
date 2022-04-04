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
