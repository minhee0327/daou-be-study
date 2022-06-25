package chapter07

import java.beans.PropertyChangeListener

//나이나 급여가 바뀌면 그 사실을 리스너에 통지한다.
class Person4(
    val name: String, age: Int, salary: Int
):PropertyChangeAware(){
    var age: Int = age
        set(newValue){
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }
    var salary:Int = salary
        set(newValue){
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

fun main(){
    val p = Person4("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 35
    p.salary = 2100
}