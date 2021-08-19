package my.edu.tarc.livedatedemo.models

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    private var accNo : String = ""
    var owner : String = ""
    private var _balance = MutableLiveData<Double>()
    //var balance: Double = 0.0

    //the person can only read the data, cannot modify
    val balance : LiveData<Double>
                get() = _balance

    init {
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
    }

    fun getAccNo() :String{
        return accNo
    }

    fun deposit(amount: Double) {
        //balance += amount
//        if(amount < 10){
//            Toast()
//        }
        _balance.value = (_balance.value)?.plus(amount)
    }

    fun witdraw(amount:Double){
        //balance -= amount
        _balance.value =  (_balance.value)?.minus(amount)
    }

}