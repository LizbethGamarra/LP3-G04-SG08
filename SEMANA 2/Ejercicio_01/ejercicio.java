import java.util.*;

// CLASE ABSTRACTA
abstract class Persona {
    protected String nombre;
    protected String dni;
    protected String email;

    public Persona(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public abstract void mostrarInfo(); // Polimorfismo
}

// INTERFAZ
interface Inscribible {
    void inscribirse(Curso curso);
}

// ESTUDIANTE
class Estudiante extends Persona implements Inscribible {
    private String codigoEstudiante;
    private List<Curso> cursosInscritos;

    public Estudiante(String nombre, String dni, String email, String codigoEstudiante) {
        super(nombre, dni, email);
        this.codigoEstudiante = codigoEstudiante;
        this.cursosInscritos = new ArrayList<>();
    }

    @Override
    public void inscribirse(Curso curso) {
        if (curso.agregarEstudiante(this)) {
            cursosInscritos.add(curso);
            System.out.println(nombre + " se inscribió en el curso: " + curso.getNombreCurso());
        } else {
            System.out.println("No hay cupos disponibles en el curso " + curso.getNombreCurso());
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " | Código: " + codigoEstudiante);
    }
}

// PROFESOR
class Profesor extends Persona {
    private String codigoProfesor;

    public Profesor(String nombre, String dni, String email, String codigoProfesor) {
        super(nombre, dni, email);
        this.codigoProfesor = codigoProfesor;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + " | Código: " + codigoProfesor);
    }
}

// CURSO
class Curso {
    private String nombreCurso;
    private String categoria;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    private int capacidadMaxima; // ahora cada curso tiene su propia capacidad

    public Curso(String nombreCurso, String categoria, Profesor profesor, int capacidadMaxima) {
        this.nombreCurso = nombreCurso;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCantidadEstudiantes() {
        return estudiantes.size();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public boolean agregarEstudiante(Estudiante e) {
        if (estudiantes.size() < capacidadMaxima) {
            estudiantes.add(e);
            return true;
        }
        return false;
    }

    public boolean estaDisponible() {
        return estudiantes.size() < capacidadMaxima;
    }

    public void mostrarInfoCurso() {
        System.out.println("Curso: " + nombreCurso + " | Categoría: " + categoria +
                " | Cupos: " + estudiantes.size() + "/" + capacidadMaxima);
        profesor.mostrarInfo();
    }

    public int getCuposDisponibles() {
        return capacidadMaxima - estudiantes.size();
    }
}

// SISTEMA DE GESTIÓN
class SistemaGestion {
    private List<Curso> cursos = new ArrayList<>();
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();

    public void listarCursosDisponibilidad() {
        System.out.println("\n===== Cursos Disponibles =====");
        for (Curso c : cursos) {
            if (c.estaDisponible()) {
                System.out.println(c.getNombreCurso() + " | Cupos disponibles: " + c.getCuposDisponibles());
            }
        }

        System.out.println("\n===== Cursos NO Disponibles =====");
        for (Curso c : cursos) {
            if (!c.estaDisponible()) {
                System.out.println(c.getNombreCurso());
            }
        }
    }

    public void registrarProfesor(Profesor p) {
        profesores.add(p);
    }

    public void registrarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public Curso registrarCurso(String nombre, String categoria, Profesor profesor, int capacidad) {
        Curso curso = new Curso(nombre, categoria, profesor, capacidad);
        cursos.add(curso);
        return curso;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void listarCursos() {
        for (Curso c : cursos) {
            c.mostrarInfoCurso();
        }
    }
}

// MAIN
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaGestion sistema = new SistemaGestion();

        int opcion;
        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Registrar Profesor");
            System.out.println("2. Registrar Estudiante");
            System.out.println("3. Registrar Curso");
            System.out.println("4. Inscribir Estudiante en Curso");
            System.out.println("5. Listar Cursos");
            System.out.println("6. Ver Disponibilidad de Cursos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre Profesor: ");
                    String nombreP = sc.nextLine();
                    System.out.print("DNI: ");
                    String dniP = sc.nextLine();
                    System.out.print("Email: ");
                    String emailP = sc.nextLine();
                    System.out.print("Código Profesor: ");
                    String codP = sc.nextLine();
                    sistema.registrarProfesor(new Profesor(nombreP, dniP, emailP, codP));
                    break;

                case 2:
                    System.out.print("Nombre Estudiante: ");
                    String nombreE = sc.nextLine();
                    System.out.print("DNI: ");
                    String dniE = sc.nextLine();
                    System.out.print("Email: ");
                    String emailE = sc.nextLine();
                    System.out.print("Código Estudiante: ");
                    String codE = sc.nextLine();
                    sistema.registrarEstudiante(new Estudiante(nombreE, dniE, emailE, codE));
                    break;

                case 3:
                    if (sistema.getProfesores().isEmpty()) {
                        System.out.println("Debe registrar al menos un profesor primero.");
                        break;
                    }
                    System.out.print("Nombre Curso: ");
                    String nombreC = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();

                    int capacidad;
                    do {
                        System.out.print("Capacidad máxima de estudiantes: ");
                        capacidad = sc.nextInt();
                        sc.nextLine();
                        if (capacidad <= 0) {
                            System.out.println("La capacidad debe ser un número positivo.");
                        }
                    } while (capacidad <= 0);

                    // Mostrar profesores
                    System.out.println("Profesores disponibles:");
                    for (int i = 0; i < sistema.getProfesores().size(); i++) {
                        System.out.println((i + 1) + ". " + sistema.getProfesores().get(i).nombre);
                    }
                    System.out.print("Seleccione profesor: ");
                    int idxProf = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idxProf >= 0 && idxProf < sistema.getProfesores().size()) {
                        sistema.registrarCurso(nombreC, categoria, sistema.getProfesores().get(idxProf), capacidad);
                    } else {
                        System.out.println("Profesor inválido.");
                    }
                    break;

                case 4:
                    if (sistema.getEstudiantes().isEmpty() || sistema.getCursos().isEmpty()) {
                        System.out.println("Debe registrar estudiantes y cursos primero.");
                        break;
                    }
                    System.out.println("Estudiantes:");
                    for (int i = 0; i < sistema.getEstudiantes().size(); i++) {
                        System.out.println((i + 1) + ". " + sistema.getEstudiantes().get(i).nombre);
                    }
                    System.out.print("Seleccione estudiante: ");
                    int idxEst = sc.nextInt() - 1;
                    sc.nextLine();

                    System.out.println("Cursos:");
                    for (int i = 0; i < sistema.getCursos().size(); i++) {
                        System.out.println((i + 1) + ". " + sistema.getCursos().get(i).getNombreCurso());
                    }
                    System.out.print("Seleccione curso: ");
                    int idxCurso = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idxEst >= 0 && idxEst < sistema.getEstudiantes().size() &&
                            idxCurso >= 0 && idxCurso < sistema.getCursos().size()) {
                        sistema.getEstudiantes().get(idxEst).inscribirse(sistema.getCursos().get(idxCurso));
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 5:
                    sistema.listarCursos();
                    break;

                case 6:
                    sistema.listarCursosDisponibilidad();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
