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
