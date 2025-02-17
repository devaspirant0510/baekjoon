import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays

var count = 0;
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,s) = br.readLine().split(' ').map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    getSubset(list,0, mutableListOf(),s)
    println(count)


}
fun getSubset(list: List<Int>, index:Int, subset:MutableList<Int>,s:Int){
    if(subset.isNotEmpty() && subset.sum()==s){
        count++
    }
    for (i in index until list.size){
        subset.add(list[i])
        getSubset(list,i+1,subset,s)
        subset.removeAt(subset.size-1)
    }
}
fun nCr(list:List<Int>,output:Array<Int>,start:Int,depth:Int,n:Int,r:Int){
    if(depth==r){
        println(output.toList())
        return
    }
    for(i in start..n-1){
        output[depth] = list[i]
        nCr(list,output,i+1,depth+1,n,r)

    }

}
