fun main(args: Array<String>) {
    /*val list= mutableListOf(MyItem(1,"1"))
    list.addItem(MyItem(1,"1"))
    println(list)

    val item = MyItem(1,"1")
    val list1 = mutableListOf(item)
    list1.addItem(item)
    println(list1)*/

    val myItemKotlin=MyItemKotlin(1,"2")
    val myItemKotlinNew=myItemKotlin.copy(i = 1, s = "3")
    println(myItemKotlin)
    println(myItemKotlinNew)

    val set = HashSet<Int>()
    val size = 16_000_000
/*    for (i in 0 until size){
        set.add(MyItem(i,"$i").hashCode())
    }
    print(set.size-size)*/

    val map= HashMap<MyItem,Int>()
    var hashcodeCalls=0
    var equalsCalls=0
    val callback=object :MyCallback{
        override fun hashCodeCalled() {
            hashcodeCalls++
            if (hashcodeCalls%100000==0)
                println("hashcodecalls $hashcodeCalls")
        }

        override fun equalsCalled() {
            equalsCalls++
            println("equalscalled $equalsCalls")
        }
    }
    for(i in 0 until size){
        map[MyItem(i,"$i",callback)]=i
    }
    print("hashcodes $hashcodeCalls equals $equalsCalls")
}

fun<T> MutableList<T>.addItem(item : T){
    if(!contains(item)){
        add(item)
    }
}


