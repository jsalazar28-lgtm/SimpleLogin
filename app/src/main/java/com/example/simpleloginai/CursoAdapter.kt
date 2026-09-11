package com.example.simpleloginai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleloginai.databinding.ItemCursoBinding

class CursoAdapter(
    private val listaCursos: List<Curso>,
    private val onVerDetallesClick: (Curso) -> Unit
) : RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {

    inner class CursoViewHolder(val binding: ItemCursoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val binding = ItemCursoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CursoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]
        with(holder.binding) {
            tvCursoTitulo.text = curso.titulo
            tvCursoNivelDuracion.text = curso.nivelDuracion
            ivCursoThumbnail.setImageResource(curso.imagenResId)
            
            btnVerDetalles.setOnClickListener {
                onVerDetallesClick(curso)
            }
        }
    }

    override fun getItemCount(): Int = listaCursos.size
}