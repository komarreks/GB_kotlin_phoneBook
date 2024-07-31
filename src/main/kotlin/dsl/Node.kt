package dsl

fun jsonArr(callback: JsonArr.() -> Unit): String {
    val node = JsonArr()
    node.apply(callback)
    return node.toString();
}

open class JsObject(){
    private var nodes: MutableList<Node> = mutableListOf()

    fun field(key: String, str: String){
        nodes.add(Node(key, "\"\"$str\"\"").apply {  })
    }

    fun field(key: String, strArr: List<String>){

        var str = "["
        var separator = ""
        strArr.forEach {
            str += "$separator\"\"$it\"\""
            separator = ", "
        }

        str += "]"

        nodes.add(Node(key, str).apply {  })
    }

    override fun toString(): String {
        var str = "{${System.lineSeparator()}"

        var separator = ""

        nodes.forEach {
            str += "$separator${it.toString()}"
            separator = ", ${System.lineSeparator()}"
        }

        return "$str}"
    }
}

open class JsonArr(){

    private var jsObjects: MutableList<JsObject> = mutableListOf()

    fun jsObject(callback: JsObject.() -> Unit){
        jsObjects.add(JsObject().apply(callback))
    }

    override fun toString(): String {
        var str = "["
        var separator = ""
        jsObjects.forEach {
            str += "$separator${it.toString()}"
            separator = ",${System.lineSeparator()}"
        }

        str += "]"

        return str
    }

}

open class Node(open var key: String, open var str:String) {
    override fun toString(): String {
        return "\"\"$key\"\": $str"
    }
}





