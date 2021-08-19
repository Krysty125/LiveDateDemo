package my.edu.tarc.livedatedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import my.edu.tarc.livedatedemo.databinding.ActivityMainBinding
import my.edu.tarc.livedatedemo.models.AccountModel

class MainActivity : AppCompatActivity() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }

    private val myAccount = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myAccount = myAccount //the object at activity_main (inside data)
        binding.lifecycleOwner = this

        //display()
        //myAccount.balance.observe(this, Observer {newBalance -> binding.tvBalance.text = newBalance.toString()})

        binding.btnDeposit.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()

            myAccount.deposit(amount)
            //myAccount.balance.value = -10000.0
            //binding.tvBalance.text = myAccount.balance.toString()

        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccount.witdraw(amount)
            //binding.tvBalance.text = myAccount.balance.toString()

        }
    }

//    fun display(){
//
//        binding.tvAccNo.text = myAccount.accNo
//        binding.tvName.text = myAccount.owner
//        binding.tvBalance.text = myAccount.balance.value.toString()
//
//    }
}