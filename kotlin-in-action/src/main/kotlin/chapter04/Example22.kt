package chapter04

//클래스 위임하기
class CountingSet<T>(
    val innerset: MutableSet<T> = HashSet<T>()
): MutableSet<T> by innerset //mutableSet의 구현을 innerSet에 위임한다
{
    var objectsAdded = 0

    //아래 두 메서드는 위임하지 않고 새로운 구현을 제공한다
    override fun add(element: T): Boolean {
        objectsAdded ++
        return innerset.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerset.addAll(elements)
    }
}