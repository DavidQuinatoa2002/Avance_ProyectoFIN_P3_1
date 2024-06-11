import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaParqueadero {


    private List<Parqueadero> parqueaderos;

    public ListaParqueadero() {
        parqueaderos = new ArrayList<Parqueadero>();
    }

    public List<Parqueadero> getParqueaderos() {
        return parqueaderos;
    }

    public void setParqueaderos(List<Parqueadero> parqueaderos) {
        this.parqueaderos = parqueaderos;
    }

    public Parqueadero buscarParqeuadero(String lugar) {
        for (Parqueadero pa : parqueaderos)
            if (pa.getLugar().equals(lugar))
                return pa;
        return null;
    }
    public List<Parqueadero> listarParqueadero(){
        List<Parqueadero> lista = new LinkedList<>();
        for (Parqueadero pa: parqueaderos)
            lista.add(pa);
        return lista;
    }
    public void agregarParqueaderoP(Parqueadero parqueadero) throws Exception {
        if (buscarParqeuadero(parqueadero.getLugar()) == null)
            parqueaderos.add(parqueadero);
        else
            throw new Exception("El lugar ya esta registrado");
    }
    public void editarParqueadero(String nombre, int nuevoCantidadEspacio)  throws Exception {
        Parqueadero parqueadero = buscarParqeuadero(nombre);
        if (parqueadero != null) {
            parqueadero.setCantidadEspacio(nuevoCantidadEspacio);
        } else {
            throw new Exception("No se encontró ninguna parqueadero con el nombre : " + nombre);
        }
    }
    public void eliminarParqueadero(String lugar) throws Exception {
        Parqueadero parqueadero = buscarParqeuadero(lugar);
        if (parqueadero != null) {
            parqueaderos.remove(parqueadero);
        } else {
            throw new Exception("El parqueadero " + lugar + " no existe.");
        }
    }

}
