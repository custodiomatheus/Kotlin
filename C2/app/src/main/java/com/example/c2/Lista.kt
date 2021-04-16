package com.example.c2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val apiCachoro = ConexaoApi.criar()

        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)

        apiCachoro.list().enqueue(object : Callback<List<Cachorro>> {
            override fun onResponse(call: Call<List<Cachorro>>, response: Response<List<Cachorro>>) {
                var qtdeIndicados:Int = 0
                var qtdeNaoIndicados:Int = 0

                response.body()?.forEach {
                    Toast.makeText(baseContext, "Sucesso", Toast.LENGTH_SHORT).show()
                    if(it.indicadoCriancas) {
                        qtdeIndicados++
                    } else {
                        qtdeNaoIndicados++
                    }

                    val tvCachorro = TextView(baseContext)
                    tvCachorro.text = "Id: ${it.id} - Raça: ${it.raca} - " +
                            "Preço médio: ${it.precoMedio} - Indicado: ${it.indicadoCriancas}"

                    layoutLista.addView(tvCachorro)
                }

                var tvIndicados:TextView = findViewById(R.id.tv_indicados)
                tvIndicados.text = "Cachorros indicados para crianças: $qtdeIndicados"

                var tvNaoIndicados:TextView = findViewById(R.id.tv_nao_indicados)
                tvNaoIndicados.text = "Cachorros indicados para crianças: $qtdeNaoIndicados"

                var tvTotal:TextView = findViewById(R.id.tv_total)
                tvTotal.text = "Cachorros indicados para crianças: ${response.body()?.size}"

            }
            override fun onFailure(call: Call<List<Cachorro>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}