import kotlin.concurrent.thread
import kotlinx.coroutines.*

//fun main() { //executed on the main thread
//
//    println("Main program starts: ${Thread.currentThread().name}")
//
//   thread{
//       println("Fake work starts: ${Thread.currentThread().name}")
//       Thread.sleep(2000) //pretending to do some work
//       println("Fake work finished: ${Thread.currentThread().name}")
//   }
//
//    println("Main program ends: ${Thread.currentThread().name}")
//
//}

//==============Using Coroutine
//fun main() { //executed on the main thread
//
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    val parentJob = CoroutineScope(Dispatchers.Default).launch{
//        println("Fake work starts: ${Thread.currentThread().name}")
//        //Thread.sleep
//        delay(2000) //pretending to do some work
//        println("Fake work finished: ${Thread.currentThread().name}")
//    }
//
//    runBlocking {
//        parentJob.join()
//    }
//
//    //Thread.sleep(2500)
//
//    println("Main program ends: ${Thread.currentThread().name}")
//
//}

//==========================COROUTINE BUILDERS
//fun main() { //executed on the main thread
//
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    val start = System.currentTimeMillis()
//    val parentJob = CoroutineScope(Dispatchers.Default).launch {
//       val job1 = launch {
//            val result1 = getData1(Thread.currentThread().name)
//            println(result1)
//        }
//        job1.join()
//        val job2 = launch {
//            val result2 = getData2(Thread.currentThread().name)
//            println(result2)
//        }
//    }
//
//    runBlocking {
//        parentJob.join()
//    }
//    println("Total time: ${System.currentTimeMillis() - start} ms")
//
//    println("Main program ends: ${Thread.currentThread().name}")
//
//}
//private suspend fun getData1(threadName: String): String {
//    println("Fake work1 starts: $threadName")
//    delay(2000)
//    println("Fake work1 finished: $threadName")
//    return "Result 1"
//}
//
//private suspend fun getData2(threadName: String): String {
//    println("Fake work2 starts: $threadName")
//    delay(2000)
//    println("Fake work2 finished: $threadName")
//    return "Result "
//}

//================async Coroutine Builder
//fun main() { //executed on the main thread
//
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    val start = System.currentTimeMillis()
//    val parentJob = CoroutineScope(Dispatchers.Default).launch {
//
//        val jobDeferred1: Deferred<String> = async {
//            getData1(Thread.currentThread().name)
//
//        }
//        val jobDeferred2: Deferred<String> = async {
//            val result2 = getData2(Thread.currentThread().name)
//            getData2(Thread.currentThread().name)
//        }
//        println(jobDeferred1.await() + "\n${jobDeferred2.await()}")
//    }
//
//    runBlocking {
//        parentJob.join()
//    }
//    println("Total time: ${System.currentTimeMillis() - start} ms")
//
//    println("Main program ends: ${Thread.currentThread().name}")
//
//}
//private suspend fun getData1(threadName: String): String {
//    println("Fake work1 starts: $threadName")
//    delay(2000)
//    println("Fake work1 finished: $threadName")
//    return "Result 1"
//}
//
//private suspend fun getData2(threadName: String): String {
//    println("Fake work2 starts: $threadName")
//    delay(2000)
//    println("Fake work2 finished: $threadName")
//    return "Result "
//}   Look at GlobalScope

//======================Cancellation
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default

fun main() { //executed on the main thread

    println("Main program starts: ${Thread.currentThread().name}")

    val start = System.currentTimeMillis()
    val parentJob = CoroutineScope(Dispatchers.Default).launch {

        val job1 = launch {
            println(getData1(Thread.currentThread().name))

        }
        job1.cancel()
        job1.join()
        val job2 = launch {
            println(getData2(Thread.currentThread().name))
        }
        //println(jobDeferred1.await() + "\n${jobDeferred2.await()}")
    }

    runBlocking {
        parentJob.join()
    }
    println("Total time: ${System.currentTimeMillis() - start} ms")

    println("Main program ends: ${Thread.currentThread().name}")

}
private suspend fun getData1(threadName: String): String {
    println("Fake work1 starts: $threadName")
    delay(2000)
    println("Fake work1 finished: $threadName")
    return "Result 1"
}

private suspend fun getData2(threadName: String): String {
    println("Fake work2 starts: $threadName")
    delay(2000)
    println("Fake work2 finished: $threadName")
    return "Result "  //Adding Timer and Exception Handler, do more research. Throwing own Exceptions.
    // SupervisorScope Lambda Expression. SupervisorScope recommended to have a clean code.
    // Can use cancellation Exception. Exceuting Sequencially, concurrently and Lazily.
    //Coroutines need more understanding
    //Dowload SQL-Lite Database for windows.
}