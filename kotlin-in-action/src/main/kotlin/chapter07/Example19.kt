package chapter07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/*
* 필드를 모든 클래스에 추가하고 싶지 않아서
* PropertyChangeSupport 인스턴스를 changeSupport라는 필드에 저장하고
* 프로퍼티 변경 리스너를 추적해주는 작은 도우미 클래스
* */
open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}