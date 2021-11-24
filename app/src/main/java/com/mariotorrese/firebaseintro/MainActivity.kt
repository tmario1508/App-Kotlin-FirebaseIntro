package com.mariotorrese.firebaseintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "FirebaseDebug"

        val db = FirebaseFirestore.getInstance()

        /*
        //Agregar registro a la colección
        db.collection("books")
            .document()
            .set(Book( name = "Programación Web", description = "Educación", autor = "Mario Torres"))
            .addOnSuccessListener {
                Log.d(TAG, "Book add success")
            }
            .addOnFailureListener{ exception ->
                Log.d(TAG, "Un error al agregar libro")

            }

         */

        /*
        //Subscripción a cambios en registro
        db.collection("books")
            .document("001")
            .addSnapshotListener{ value, error ->
                value.let { document ->
                    document.let {
                        Log.d(TAG, "Cambios en el registro. Name: ${document?.getString("name")}, Autor: ${document?.getString("autor")}, Descripción: ${document?.getString("description")}")
                    }

                }
            }

         */

        //Subscripción a cambios en la colección
        db.collection("books")
            .addSnapshotListener{ value, error ->
                value.let {
                    for (document in value?.documents!!){
                        Log.d(TAG, "Consulta de toda la colleccion. Name: ${document?.getString("name")}, Autor: ${document?.getString("autor")}, Descripción: ${document?.getString("description")}")
                    }
                }
            }

        /*
        //Consulta de toda la coleccion
        db.collection("books")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    Log.d(TAG, "Consulta de toda la colleccion. Name: ${document.getString("name")}, Autor: ${document.getString("autor")}, Descripción: ${document.getString("description")}")
                }

            }
            .addOnFailureListener{

            }

        //Consulta por ID
        db.collection("books")
            .document("001")
            .get()
            .addOnSuccessListener { document ->
                document.let {
                    Log.d(TAG, "Consulta por ID. Name: ${document.getString("name")}, Autor: ${document.getString("autor")}, Description: ${document.getString("description")}")
                }
            }

        //Consulta por propiedades
        db.collection("books")
            .whereEqualTo("name", "El Arte de Amar")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    Log.d(TAG, "Consulta por Campo. Name: ${document.getString("name")}, Autor: ${document.getString("autor")}, Description: ${document.getString("description")}")
                }

            }

         */
    }

    data class Book(var name:String, var description:String, var autor:String)
}