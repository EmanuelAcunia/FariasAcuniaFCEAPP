package com.example.tallerlabo.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
   public static final String CLAVE_ID = "_id";
    public static final String CLAVE_NOMBRE ="nombre";
    public static final String CLAVE_DPTO = "dpto";
    public static final String CLAVE_PAGINA = "pagina";
    public static final String CLAVE_DURACION = "duracion";
    public static final String BASE_DE_DATOS = "Carreras";
    public static final String TABLA = "carrera";
    public static final int VERSION = 1;
    public  static final String CREAR_DB =
            "CREATE TABLE carrera (_id INTEGER PRIMARY KEY,"+
                    "nombre TEXT, dpto TEXT, pagina TEXT, duracion TEXT);";

    final Context contexto;
    DataBaseHelper DBHelper;
    static SQLiteDatabase db;

    public DBAdapter(Context contexto){
        this.contexto = contexto;
        DBHelper = new DataBaseHelper(contexto);
    }

    private static class DataBaseHelper extends SQLiteOpenHelper {
        public DataBaseHelper(Context contexto){
            super(contexto, BASE_DE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            try{
                db.execSQL(CREAR_DB);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int versionAnterior, int nuevaVersion){
            Log.w("DBAdapter", "Actualizando desde la version "+versionAnterior+
                    " a la version "+nuevaVersion+". Se eliminaran todos los datos");
            db.execSQL("DROP TABLE IF EXISTS pais;");
            onCreate(db);
            db.execSQL("ALTER TABLE pais ADD COLUMN bandera BLOB;");
        }

    }

    // Abre la Base de Datos
    public DBAdapter abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return this;//db?
    }
    // Cierra la Base de Datos
    public void cerrar(){
        DBHelper.close();
    }

    /* Inserta un pais en la Base de Datos

    public long insertarPais(String pais, String capital, Long poblacion){
        ContentValues valores = new ContentValues();
        valores.put(CLAVE_PAIS, pais);
        valores.put(CLAVE_CAPITAL, capital);
        valores.put(CLAVE_POBLACION, poblacion);
        return db.insert(TABLA, null, valores);
    }

     Recupera todos los paises de la Base de Datos
    public Cursor getPaises(){
        return db.query(TABLA, new String[] {CLAVE_ID, CLAVE_PAIS, CLAVE_CAPITAL, CLAVE_POBLACION},
                null, null, null, null, null);
    }*/

    // Recupera un carrera de la Base de Datos
    public static Cursor getCarrera(int p){
        Cursor cursor =
                db.query(TABLA, new String[] {CLAVE_ID, CLAVE_NOMBRE, CLAVE_DPTO, CLAVE_PAGINA,CLAVE_DURACION},
                        CLAVE_ID+"=" + p, null, null, null, null);
        if (cursor !=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

}
