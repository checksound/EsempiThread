# ESEMPI THREAD

## ESEMPIO SIMPLE THREAD

Esempio di utilizzo delle primitive dei thread: `join()`, `sleep()`, `isAlive()`, `interrupt()`: [io.checksound.concurrency.SimpleThreads](./src/io/checksound/concurrency/SimpleThreads.java).

## ESEMPIO CALCOLO DEI NUMERI PRIMI

Per sapere il numero di processori su PC:

```java

Runtime.getRuntime().availableProcessors();

```

Codice esempio calcolo numeri primi:

Vesrsione 1 - creazione di thead: [javanotes8.ThreadTest1](./src/javanotes8/ThreadTest1.java)

Versione 2 - coordinamento tramite **join** e utilizzo di **synchronized**: [javanotes8.ThreadTest2](./src/javanotes8/ThreadTest2.java)

Versione 3 - utilizzo di variabili atomiche: [javanotes8.ThreadTest3](./src/javanotes8/ThreadTest3.java)

Teoria: [http://math.hws.edu/eck/cs124/javanotes8/c12/s1.html](http://math.hws.edu/eck/cs124/javanotes8/c12/s1.html)

## ESEMPIO DEADLOCK

Esempio di deadlock [io.checksound.concurrency.Deadlock](./src/io/checksound/concurrency/Deadlock.java) 

ed esempio di utilizzo della classe `java.util.concurrent.locks.Lock` con l'utilizzo del lock esplicito per risolvere le problematiche del deadlock: [io.checksound.concurrency.Safelock](./src/io/checksound/concurrency/Safelock.java)

## ESEMPIO BANCA

Nel package [racecondition](./src/racecondition) c'è la versione non sincronizzata in cui si vede che si verifica la race condition.

Nel package [synch](./src/synch) c'è la versione che utilizza 
`java.util.concurrent.locks.Lock` e `java.util.concurrent.locks.Condition`.

Nel package [synch2](./src/synch2) c'è la versione che utilizza `synchronized`, `wait` e `notify`.

## ESEMPI JAVAXF

Argomento per JVM:  

`--module-path "C:\dev\openjfx-11.0.2\lib" --add-modules javafx.controls,javafx.fxml`

## ESEMPI UTILIZZO DEI THREAD 

Serie di esempi calcolo del Mandelbrot Set https://en.wikipedia.org/wiki/Mandelbrot_set  utilizzando diverse tecniche 
con per suddivitere la visualizzazione delle righe dell'immagine su più thread.

Pseudo codice visualizzazione:

```
for each pixel (Px, Py) on the screen do
    x0 = scaled x coordinate of pixel (scaled to lie in the Mandelbrot X scale (-2.5, 1))
    y0 = scaled y coordinate of pixel (scaled to lie in the Mandelbrot Y scale (-1, 1))
    x := 0.0
    y := 0.0
    iteration := 0
    max_iteration := 1000
    while (x×x + y×y ≤ 2×2 AND iteration < max_iteration) do
        xtemp := x×x - y×y + x0
        y := 2×x×y + y0
        x := xtemp
        iteration := iteration + 1
 
    color := palette[iteration]
    plot(Px, Py, color)

```

Esempio [javanotes8.BackgroundComputationDemo](javanotes8.BackgroundComputationDemo) per visualizzazione con unico thread in background.

[javanotes8.MultiprocessingDemo1](javanotes8.MultiprocessingDemo1) utilizza più thread, potendo selezionare il numero da 1 a 8, suddividendo le righe da disegnare in zone, una per ogni thread.

![](./MultiprocessingDemo.PNG)

![](./MultiprocessingDemo2.PNG)

L'esempio [javanotes8.MultiprocessingDemo2](javanotes8.MultiprocessingDemo2) utilizza `ConcurrentLinkedQueue<Runnable> taskQueue` per suddividere il lavoro tra i diversi thread.

L'esempio [javanotes8.MultiprocessingDemo3](javanotes8.MultiprocessingDemo3) utilizza `LinkedBlockingQueue<Runnable> taskQueue` per suddividere il lavoro tra i diversi thread; il numero dei thread utilizzati dall'applicazione è stabilito in base al numero dei processori.

L'esempio [javanotes8.MultiprocessingDemo4](javanotes8.MultiprocessingDemo4) utilizza invece `ExecutorService executor` del package `java.util.concurrent`; per istanziare l'executor service:

```
	int processors = Runtime.getRuntime().availableProcessors();
	executor = Executors.newFixedThreadPool(processors);
```







