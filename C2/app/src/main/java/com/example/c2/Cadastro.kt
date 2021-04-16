package com.example.c2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ThreadLocalRandom

class Cadastro : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun cadastrar(view: View) {
        val apiCachorro = ConexaoApi.criar()

        val etRaca:EditText = findViewById(R.id.et_raca)
        val raca = etRaca.text.toString()

        val etPreco:EditText = findViewById(R.id.et_preco)
        val preco = etPreco.text.toString().toDouble()

        val switchIndicador:Switch = findViewById(R.id.switch_indicador)
        val indicador = switchIndicador.isChecked

        val novoCachorro = Cachorro(0, raca, preco, indicador)



        apiCachorro.cadastrar(novoCachorro).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 201) {
                    val ivCachorro: ImageView = findViewById(R.id.iv_cachorro)
                    ivCachorro.visibility = View.VISIBLE

                    val tvSucesso: TextView = findViewById(R.id.tv_sucesso)
                    tvSucesso.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}