# ESEMPI THREAD

## ESEMPIO SIMPLE THREAD

Esempio di utilizzo delle primitive dei thread: `join`, `sleep`, `isAlive`, `interrupt`: [io.checksound.concurrency.SimpleThreads](./src/io/checksound/concurrency/SimpleThreads.java).

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


## ESEMPI JAVAXF

Argomento per JVM:  

`--module-path "C:\dev\openjfx-11.0.2\lib" --add-modules javafx.controls,javafx.fxml`

