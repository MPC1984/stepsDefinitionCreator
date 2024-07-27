import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //*******VARIABLES A MODIFICAR EN FUNCIÓN DEL API DE EJEMPLO QUE SE UTILICE*******
    //URL en la que se encuentra el API de ejemplo
    public static String baseURL = "http://localhost:8000/olympicGames/";
    //Nombres de los endpoints que tiene el API de ejemplo
    public static String[] endpointsName = {"athlete", "metal", "medal table", "olympic games", "sport"};
    //Booleanos para saber el endpoint del API de ejemplo que se está probando en cada archivo featue a tratar
    public static boolean[] isThisEndpoint = {false, false, false, false, false};
    //Booleanos para saber si los enpoints del API de ejemplo tienen una estructura de datos simple o compleja
    public static boolean[] isSimpleEndpoint = {true, true, false, true, true};

    //Keywords permitidos para el endpoint athlete de la API de ejemplo
    public static String[] keywordsEndpoint0 = {"all", "athlete identifier", "athlete name", "athlete surname", "athlete country"};
    //Nombres de los datos que tiene el endpoint athlete de la API de ejemplo
    public static String[] fieldsNameEndpoint0 = {"id", "athleteName", "athleteSurname", "athleteCountry"};
    //Tipos de los datos que tiene el endpoint athlete de la API de ejemplo (están asociados a los nombres anteriores siguiendo el mismo orden en el que aparecen)
    public static String[] fieldsTypeEndpoint0 = {"Long", "String", "String", "String"};
    //Nombres de los parámetros permitidos para el endpoint athlete de la API de ejemplo
    public static String[] parametersURLNameEndpoint0 = {"id", "name", "surname", "country"};
    //Variante del nombre del identificador para el endpoint athlete de la API de ejemplo
    public static String identifierExtendedNameEndpoint0 = "athleteId";
    //Booleanos para saber por qué campo se está realizando una búsqueda de datos para el endpoint athlete de la API de ejemplo. Se corresponden con all, id, athleteName,
    // athleteSurname y athleteCountry en este orden
    public static boolean[] isThisFieldSearchEndpoint0 = {false, false, false, false, false};
    //Booleanos para saber qué datos se van a modificar para el endpoint athlete de la API de ejemplo. Se corresponden con athleteName, athleteSurname
    //y athleteCountry en este orden
    public static boolean[] isThisFieldUpdatedEndpoint0 = {false, false, false};

    //Keywords permitidos para el endpoint metal de la API de ejemplo
    public static String[] keywordsEndpoint1 = {"all", "metal identifier", "metal type"};
    //Nombres de los datos que tiene el endpoint metal de la API de ejemplo
    public static String[] fieldsNameEndpoint1 = {"id", "metalType"};
    //Tipos de los datos que tiene el endpoint metal de la API de ejemplo (están asociados a los nombres anteriores siguiendo el mismo orden en el que aparecen)
    public static String[] fieldsTypeEndpoint1 = {"Long", "String"};
    //Nombres de los parámetros permitidos para el endpoint metal de la API de ejemplo
    public static String[] parametersURLNameEndpoint1 = {"id", "type"};
    //Variante del nombre del identificador para el endpoint metal de la API de ejemplo
    public static String identifierExtendedNameEndpoint1 = "metalId";
    //Booleanos para saber por qué campo se está realizando una búsqueda de datos para el endpoint metal de la API de ejemplo. Se corresponden con all, id y
    //metalType en este orden
    public static boolean[] isThisFieldSearchEndpoint1 = {false, false, false};
    //Booleanos para saber qué datos se van a modificar para el endpoint metal de la API de ejemplo. Se corresponden con metalType
    public static boolean[] isThisFieldUpdatedEndpoint1 = {false};

    //Keywords permitidos para el endpoint Olympic Games medal table de la API de ejemplo
    public static String[] keywordsEndpoint2 = {"all", "olympic games medal table identifier", "olympic games medal table olympic games identifier",
            "olympic games medal table olympic games year", "olympic games medal table olympic games place", "olympic games medal table sport identifier",
            "olympic games medal table sport name", "olympic games medal table sport category", "olympic games medal table metal identifier",
            "olympic games medal table metal type", "olympic games medal table athlete identifier", "olympic games medal table athlete name",
            "olympic games medal table athlete surname", "olympic games medal table athlete country"};
    //Nombres de los datos que tiene el endpoint Olympic Games medal table de la API de ejemplo
    public static String[] fieldsNameEndpoint2 = {"id", "olympicGamesId", "olympicGamesYear", "olympicGamesPlace", "sportId", "sportName",
            "sportCategoryName", "metalId", "metalType", "athleteId", "athleteName", "athleteSurname", "athleteCountry"};
    //Tipos de los datos que tiene el endpoint Olympic Games medal table de la API de ejemplo (están asociados a los nombres anteriores siguiendo el mismo orden
    //en el que aparecen)
    public static String[] fieldsTypeEndpoint2 = {"Long", "Long", "Integer", "String", "Long", "String", "String", "Long",
            "String", "Long", "String", "String", "String"};
    //Nombres de los parámetros permitidos para el endpoint Olympic Games medal table de la API de ejemplo
    public static String[] parametersURLNameEndpoint2 = {"id", "idOlympicGames", "olympicGamesYear", "olympicGamesPlace", "idSport", "sportName",
            "categoryName", "idMetal", "metalType", "idAthlete", "athleteName", "athleteSurname", "athleteCountry"};
    //Variante del nombre del identificador para el endpoint Olympic Games medal table de la API de ejemplo
    public static String identifierExtendedNameEndpoint2 = "olympicGamesMedalTableId";
    //Variantes de los nombres de los endpoints que tienen nombres compuestos de la API de ejemplo
    public static String[] continuousEndpointName2 = {"medalTable", "olympicGames"};
    //Booleanos para saber por qué campo se está realizando una búsqueda de datos para el endpoint Olympic Games medal table de la API de ejemplo.
    //Se corresponden con all, id, idOlympicGames, olympicGamesYear, olympicGamesPlace, idSport, sportName, categoryName, idMetal, metalType, idAthlete,
    //athleteName, athleteSurname y athleteCountry
    public static boolean[] isThisFieldSearchEndpoint2 = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    //Booleanos para saber qué datos se van a modificar para el endpoint Olympic Games medal table de la API de ejemplo. Se corresponden con idOlympicGames,
    //idSport, idMetal e idAthlete
    public static boolean[] isThisFieldUpdatedEndpoint2 = {false, false, false, false};

    //Keywords permitidos para el endpoint Olympic Games de la API de ejemplo
    public static String[] keywordsEndpoint3 = {"all", "olympic games identifier", "olympic games year", "olympic games place"};
    //Nombres de los datos que tiene el endpoint Olympic Games de la API de ejemplo
    public static String[] fieldsNameEndpoint3 = {"id", "olympicGamesYear", "olympicGamesPlace"};
    //Tipos de los datos que tiene el endpoint Olympic Games de la API de ejemplo (están asociados a los nombres anteriores siguiendo el mismo orden en el que aparecen)
    public static String[] fieldsTypeEndpoint3 = {"Long", "Integer", "String"};
    //Nombres de los parámetros permitidos para el endpoint Olympic Games de la API de ejemplo
    public static String[] parametersURLNameEndpoint3 = {"id", "year", "place"};
    //Variante del nombre del identificador para el endpoint Olympic Games de la API de ejemplo
    public static String identifierExtendedNameEndpoint3 = "olympicGamesId";
    //Booleanos para saber por qué campo se está realizando una búsqueda de datos para el endpoint Olympic Games de la API de ejemplo. Se corresponden con all, id,
    //olympicGamesYear y olympicGamesPlace en este orden
    public static boolean[] isThisFieldSearchEndpoint3 = {false, false, false, false};
    //Booleanos para saber qué datos se van a modificar para el endpoint Olympic Games de la API de ejemplo. Se corresponden con olympicGamesYear y
    //olympicGamesPlace en este orden
    public static boolean[] isThisFieldUpdatedEndpoint3 = {false, false};

    //Keywords permitidos para el endpoint sport de la API de ejemplo
    public static String[] keywordsEndpoint4 = {"all", "sport identifier", "sport name", "sport category"};
    //Nombres de los datos que tiene el endpoint sport de la API de ejemplo
    public static String[] fieldsNameEndpoint4 = {"id", "sportName", "sportCategoryName"};
    //Tipos de los datos que tiene el endpoint sport de la API de ejemplo (están asociados a los nombres anteriores siguiendo el mismo orden en el que aparecen)
    public static String[] fieldsTypeEndpoint4 = {"Long", "String", "String"};
    //Nombres de los parámetros permitidos para el endpoint sport de la API de ejemplo
    public static String[] parametersURLNameEndpoint4 = {"id", "name", "category"};
    //Variante del nombre del identificador para el endpoint sport de la API de ejemplo
    public static String identifierExtendedNameEndpoint4 = "sportId";
    //Booleanos para saber por qué campo se está realizando una búsqueda de datos para el endpoint sport de la API de ejemplo. Se corresponden con all, id,
    //sportName y sportCategoryName en este orden
    public static boolean[] isThisFieldSearchEndpoint4 = {false, false, false, false};
    //Booleanos para saber qué datos se van a modificar para el endpoint sport de la API de ejemplo. Se corresponden con sportName y sportCategoryName en este orden
    public static boolean[] isThisFieldUpdatedEndpoint4 = {false, false};
    //*******VARIABLES A MODIFICAR EN FUNCIÓN DEL API DE EJEMPLO QUE SE UTILICE*******

    //Booleanos para saber que método se está probando en el escenario de prueba que se está tratando
    public static boolean isDeleteMethod = false, isGetMethod = false, isPatchMethod = false, isPostMethod = false;
    //Enteros para almacenar posiciones en las que se encuentran los datos de prueba que aparecen en el escenario de prueba que se está tratando y para
    //contabilizar el número de métodos que se llevan diseñados
    public static int posFieldSearch = -2, posQuotationMarks = -2, posSpace = -2, testCounter = 0;
    //Listas para almecenar todas las sentencias que aparecen en el archivo feature, todas las sentencias que se necesitan añadir cuando se hace una petición patch y
    //todas las sentencias que se van a añadir en el archivo con los steps definition
    public static ArrayList<String> featureSentences = new ArrayList<String>(), patchSentences = new ArrayList<String>(),
            scriptSentences = new ArrayList<String>();
    //Entero para almecenar datos de prueba de tipo entero que aparecen en el escenario de prueba que se está tratando
    public static Integer integerItem;
    //Entero largo para almecenar datos de prueba de tipo entero largo que aparecen en el escenario de prueba que se está tratando
    public static Long longItem;
    //Variables para almacenar las URLs de los diferentes endpoints de la API de ejemplo, el path donde se encuentra el archivo feature a tratar, los parámetros de entrada
    //de los diferentes métodos a diseñar, las sentencias que tiene el archivo feature, el path donde dejar el archivo con los steps definition y los datos de prueba de tipo
    //texto que aparecen en el escenario de prueba que se está tratando
    public static String endpointURL = "", featurePath = "", inputParameters = "",
            inputParametersPatch = "", line = "", stepsDefinitionPath = "", stringItem, url = "";

    public static void main(String[] args) throws IOException {

        //Buffer para la lectura de las líneas del archivo feature
        BufferedReader inputBuffer;
        //Buffer para la escritura del archivo con los steps definition
        BufferedWriter outputBuffer;
        //Scanner para la lectura de las diferentes respuestas  que el usuario va dando por pantalla
        Scanner inputScanner = new Scanner(System.in);
        //Variable para almacenar las respuestas del usuario
        String response;

        //Instrucciones que se van dando al usuario del framework por pantalla para que las vaya siguiendo
        //Entre ellas se pide que lea el archivo Readme.txt en el que se indica la manera en la que debe escribir los escenarios de prueba en el archivo feature (si no lo ha
        //leído el framework termina), que indique el nombre del archivo feature y el path donde se encuentra y que indique el nombre que quiere que tenga el archivo
        //con los steps definition y el path donde dejarlo
        System.out.println(
                "Have you taken into account all the instructions given in 'Readme.txt' file? (Y/N)");
        response = inputScanner.nextLine();
        if (response.trim().toUpperCase().equals("Y")) {
            System.out.println("Please introduce the path where I must get the '.feature' file");
            response = inputScanner.nextLine();
            featurePath = featurePath + response.trim();
            System.out.println("Please introduce the name without the extension of the '.feature' file");
            response = inputScanner.nextLine();
            featurePath = featurePath + "/" + response.trim() + ".feature";
            inputBuffer = new BufferedReader(new FileReader(featurePath));
            System.out.println("Please introduce the path where I must leave the file generated with the steps definition related to the previous '.feature' file");
            response = inputScanner.nextLine();
            stepsDefinitionPath = stepsDefinitionPath + response.trim();
            System.out.println("Please introduce the name without the extension of the file generated with the steps definition related to the previous '.feature' file");
            response = inputScanner.nextLine();
            stepsDefinitionPath = stepsDefinitionPath + "/" + response.trim() + ".java";
            outputBuffer = new BufferedWriter(new FileWriter(stepsDefinitionPath));
            line = inputBuffer.readLine();
            while (line != null) {
                line = line.trim();
                inputParameters = "";
                inputParametersPatch = "";
                if (line.startsWith("Feature:")) {
                    //En la sentencia del archivo feature que empieza con 'Feature:', se indica el endpoint que se quiere tratar
                    //En función del endpoint que se quiere tratar, se marca el endpoint que se va a tratar, se genera la URL completa
                    //del endpoint y se añaden los paquetes, imports, nombre de la clase y variables que tendrá el archivo con los steps definition
                    if (line.toLowerCase().contains(endpointsName[0])) {
                        isThisEndpoint[0] = true;
                        endpointURL = baseURL + endpointsName[0];
                        addingPackageImportsClassVariablesSentences(outputBuffer, response);
                        for (int j = 0; j < fieldsNameEndpoint0.length; j++) {
                            outputBuffer.write("    private " + fieldsTypeEndpoint0[j] + " " + fieldsNameEndpoint0[j] + ";\n");
                        }
                        outputBuffer.write("\n");
                    } else if (line.toLowerCase().contains(endpointsName[1])) {
                        isThisEndpoint[1] = true;
                        endpointURL = baseURL + endpointsName[1];
                        addingPackageImportsClassVariablesSentences(outputBuffer, response);
                        for (int j = 0; j < fieldsNameEndpoint1.length; j++) {
                            outputBuffer.write("    private " + fieldsTypeEndpoint1[j] + " " + fieldsNameEndpoint1[j] + ";\n");
                        }
                        outputBuffer.write("\n");
                    } else if (line.toLowerCase().contains(endpointsName[2])) {
                        isThisEndpoint[2] = true;
                        endpointURL = baseURL + continuousEndpointName2[0];
                        addingPackageImportsClassVariablesSentences(outputBuffer, response);
                        outputBuffer.write("    private String key;\n");
                        outputBuffer.write("    private Object value;\n");
                        for (int j = 0; j < fieldsNameEndpoint2.length; j++) {
                            outputBuffer.write("    private " + fieldsTypeEndpoint2[j] + " " + fieldsNameEndpoint2[j] + ";\n");
                        }
                        outputBuffer.write("\n");
                    } else if (line.toLowerCase().contains(endpointsName[3])) {
                        isThisEndpoint[3] = true;
                        endpointURL = baseURL.substring(0, baseURL.length() - 1);
                        addingPackageImportsClassVariablesSentences(outputBuffer, response);
                        for (int j = 0; j < fieldsNameEndpoint3.length; j++) {
                            outputBuffer.write("    private " + fieldsTypeEndpoint3[j] + " " + fieldsNameEndpoint3[j] + ";\n");
                        }
                        outputBuffer.write("\n");
                    } else if (line.toLowerCase().contains(endpointsName[4])) {
                        isThisEndpoint[4] = true;
                        endpointURL = baseURL + endpointsName[4];
                        addingPackageImportsClassVariablesSentences(outputBuffer, response);
                        for (int j = 0; j < fieldsNameEndpoint4.length; j++) {
                            outputBuffer.write("    private " + fieldsTypeEndpoint4[j] + " " + fieldsNameEndpoint4[j] + ";\n");
                        }
                        outputBuffer.write("\n");
                    }
                } else if (line.startsWith("Scenario:")) {
                    //Se inicializan las variables con los valores iniciales que deben tener en cada uno de los escenarios a tratar
                    initializeVariables();
                    //En la sentencia del archivo feature que empieza con 'Scenario:', se indica el método que se quiere tratar
                    //En función del método que se quiere tratar, se marca el método que se va a tratar, y si el método es un get se buscan las keywords que contiene
                    //la sentencia para marcar cuál es el dato de búsqueda y generar la url completa para el escenario de prueba a tratar
                    if (line.toLowerCase().contains("get")) {
                        isGetMethod = true;
                        if (isThisEndpoint[0]) {
                            if (line.toLowerCase().contains(keywordsEndpoint0[0])) {
                                isThisFieldSearchEndpoint0[0] = true;
                                url = endpointURL + "\"";
                            }
                            for (int j = 1; j < keywordsEndpoint0.length; j++) {
                                if (line.toLowerCase().contains(keywordsEndpoint0[j])) {
                                    isThisFieldSearchEndpoint0[j] = true;
                                    url = endpointURL + "/" + parametersURLNameEndpoint0[j - 1] + "=\" + " + fieldsNameEndpoint0[j - 1];
                                }
                            }
                        } else if (isThisEndpoint[1]) {
                            if (line.toLowerCase().contains(keywordsEndpoint1[0])) {
                                isThisFieldSearchEndpoint1[0] = true;
                                url = endpointURL + "\"";
                            }
                            for (int j = 1; j < keywordsEndpoint1.length; j++) {
                                if (line.toLowerCase().contains(keywordsEndpoint1[j])) {
                                    isThisFieldSearchEndpoint1[j] = true;
                                    url = endpointURL + "/" + parametersURLNameEndpoint1[j - 1] + "=\" + " + fieldsNameEndpoint1[j - 1];
                                }
                            }
                        } else if (isThisEndpoint[2]) {
                            if (line.toLowerCase().contains(keywordsEndpoint2[0])) {
                                isThisFieldSearchEndpoint2[0] = true;
                                url = endpointURL + "\"";
                            }
                            for (int j = 1; j < keywordsEndpoint2.length; j++) {
                                if (line.toLowerCase().contains(keywordsEndpoint2[j])) {
                                    isThisFieldSearchEndpoint2[j] = true;
                                    url = endpointURL + "/" + parametersURLNameEndpoint2[j - 1] + "=\" + " + fieldsNameEndpoint2[j - 1];
                                }
                            }
                        } else if (isThisEndpoint[3]) {
                            if (line.toLowerCase().contains(keywordsEndpoint3[0])) {
                                isThisFieldSearchEndpoint3[0] = true;
                                url = endpointURL + "\"";
                            }
                            for (int j = 1; j < keywordsEndpoint3.length; j++) {
                                if (line.toLowerCase().contains(keywordsEndpoint3[j])) {
                                    isThisFieldSearchEndpoint3[j] = true;
                                    url = endpointURL + "/" + parametersURLNameEndpoint3[j - 1] + "=\" + " + fieldsNameEndpoint3[j - 1];
                                }
                            }
                        } else if (isThisEndpoint[4]) {
                            if (line.toLowerCase().contains(keywordsEndpoint4[0])) {
                                isThisFieldSearchEndpoint4[0] = true;
                                url = endpointURL + "\"";
                            }
                            for (int j = 1; j < keywordsEndpoint4.length; j++) {
                                if (line.toLowerCase().contains(keywordsEndpoint4[j])) {
                                    isThisFieldSearchEndpoint4[j] = true;
                                    url = endpointURL + "/" + parametersURLNameEndpoint4[j - 1] + "=\" + " + fieldsNameEndpoint4[j - 1];
                                }
                            }
                        }
                    } else if (line.toLowerCase().contains("add")) {
                        isPostMethod = true;
                    } else if (line.toLowerCase().contains("updat")) {
                        isPatchMethod = true;
                    } else if (line.toLowerCase().contains("delet")) {
                        isDeleteMethod = true;
                    }
                } else if (!line.isEmpty()) {
                    if (line.startsWith("Given")) {
                        //Se actualiza el número de métodos que se llevan diseñados
                        testCounter++;
                        //En la sentencia del archivo feature que empieza con 'Given', se indican los datos de prueba que se van a utilizar en el escenario
                        //que se va a tratar
                        //Si el método a tratar es un GET, en función del endpoint que se está tratando, si la búsqueda que se quiere realizar es de todos los datos
                        //se genera la cabecera del método asociado a la sentencia a tratar y se crea la petición
                        //En cambio, si la búsqueda que se quiere realizar es por un dato concreto, lo primero se busca el dato de prueba, se genera la cabecera
                        //del método asociado a la sentencia a tratar, se crea la petición y se añade la variable que va a almacenar el dato por el que se quiere
                        //realizar la búsqueda
                        if (isGetMethod) {
                            if (isThisEndpoint[0]) {
                                if (isThisFieldSearchEndpoint0[0]) {
                                    addingGivenSentencesAllSearch();
                                }
                                for (int j = 0; j < fieldsNameEndpoint0.length; j++) {
                                    if (isThisFieldSearchEndpoint0[j + 1]) {
                                        if (fieldsTypeEndpoint0[j].equals("String")) {
                                            addingNewStringInputParameter(keywordsEndpoint0[j + 1] + " ", fieldsNameEndpoint0[j]);
                                        } else if (fieldsTypeEndpoint0[j].equals("Long")) {
                                            addingNewLongInputParameter(keywordsEndpoint0[j + 1] + " ", fieldsNameEndpoint0[j]);
                                        }
                                    }
                                }
                            } else if (isThisEndpoint[1]) {
                                if (isThisFieldSearchEndpoint1[0]) {
                                    addingGivenSentencesAllSearch();
                                }
                                for (int j = 0; j < fieldsNameEndpoint1.length; j++) {
                                    if (isThisFieldSearchEndpoint1[j + 1]) {
                                        if (fieldsTypeEndpoint1[j].equals("String")) {
                                            addingNewStringInputParameter(keywordsEndpoint1[j + 1] + " ", fieldsNameEndpoint1[j]);
                                        } else if (fieldsTypeEndpoint1[j].equals("Long")) {
                                            addingNewLongInputParameter(keywordsEndpoint1[j + 1] + " ", fieldsNameEndpoint1[j]);
                                        }
                                    }
                                }
                            } else if (isThisEndpoint[2]) {
                                if (isThisFieldSearchEndpoint2[0]) {
                                    addingGivenSentencesAllSearch();
                                }
                                for (int j = 0; j < fieldsNameEndpoint2.length; j++) {
                                    if (isThisFieldSearchEndpoint2[j + 1]) {
                                        if (fieldsTypeEndpoint2[j].equals("String")) {
                                            addingNewStringInputParameter(keywordsEndpoint2[j + 1] + " ", fieldsNameEndpoint2[j]);
                                        } else if (fieldsTypeEndpoint2[j].equals("Long")) {
                                            addingNewLongInputParameter(keywordsEndpoint2[j + 1] + " ", fieldsNameEndpoint2[j]);
                                        } else if (fieldsTypeEndpoint2[j].equals("Integer")) {
                                            addingNewIntegerInputParameter(keywordsEndpoint2[j + 1] + " ", fieldsNameEndpoint2[j]);
                                        }
                                    }
                                }
                            } else if (isThisEndpoint[3]) {
                                if (isThisFieldSearchEndpoint3[0]) {
                                    addingGivenSentencesAllSearch();
                                }
                                for (int j = 0; j < fieldsNameEndpoint3.length; j++) {
                                    if (isThisFieldSearchEndpoint3[j + 1]) {
                                        if (fieldsTypeEndpoint3[j].equals("String")) {
                                            addingNewStringInputParameter(keywordsEndpoint3[j + 1] + " ", fieldsNameEndpoint3[j]);
                                        } else if (fieldsTypeEndpoint3[j].equals("Long")) {
                                            addingNewLongInputParameter(keywordsEndpoint3[j + 1] + " ", fieldsNameEndpoint3[j]);
                                        } else if (fieldsTypeEndpoint3[j].equals("Integer")) {
                                            addingNewIntegerInputParameter(keywordsEndpoint3[j + 1] + " ", fieldsNameEndpoint3[j]);
                                        }
                                    }
                                }
                            } else if (isThisEndpoint[4]) {
                                if (isThisFieldSearchEndpoint4[0]) {
                                    addingGivenSentencesAllSearch();
                                }
                                for (int j = 0; j < fieldsNameEndpoint4.length; j++) {
                                    if (isThisFieldSearchEndpoint4[j + 1]) {
                                        if (fieldsTypeEndpoint4[j].equals("String")) {
                                            addingNewStringInputParameter(keywordsEndpoint4[j + 1] + " ", fieldsNameEndpoint4[j]);
                                        } else if (fieldsTypeEndpoint4[j].equals("Long")) {
                                            addingNewLongInputParameter(keywordsEndpoint4[j + 1] + " ", fieldsNameEndpoint4[j]);
                                        }
                                    }
                                }
                            }
                        //Si el método a tratar es un POST, en función del endpoint que se está tratando, primero se buscan los datos de prueba
                        //(datos necesarios para crear el nuevo ítem que se va a añadir), se genera la cabecera del método asociado a la sentencia a tratar,
                        //se crea la petición y se añade la variable que va a almacenar el ítem nuevo que se quiere añadir, asignándola los correspondientes datos de prueba
                        } else if (isPostMethod) {
                            if (isThisEndpoint[0]) {
                                for (int j = 2; j < keywordsEndpoint0.length; j++) {
                                    searchingStringInputParameter(keywordsEndpoint0[j] + " ");
                                }
                                scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
                                scriptSentences.add("    public void test_" + testCounter + "(" + fieldsTypeEndpoint0[1] + " " + fieldsNameEndpoint0[1] +
                                        ", " + fieldsTypeEndpoint0[2] + " " + fieldsNameEndpoint0[2] + ", " + fieldsTypeEndpoint0[3] + " " + fieldsNameEndpoint0[3] + ") {\n");
                                scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
                                scriptSentences.add("        newItem = new HashMap<>();\n");
                                for (int j = 1; j < fieldsNameEndpoint0.length; j++) {
                                    scriptSentences.add("        newItem.put(\"" + fieldsNameEndpoint0[j] + "\", " + fieldsNameEndpoint0[j] + ");\n");
                                }
                            } else if (isThisEndpoint[1]) {
                                searchingStringInputParameter(keywordsEndpoint1[2] + " ");
                                scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
                                scriptSentences.add("    public void test_" + testCounter + "(" + fieldsTypeEndpoint1[1] + " " + fieldsNameEndpoint1[1] + ") {\n");
                                scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
                                scriptSentences.add("        newItem = new HashMap<>();\n");
                                for (int j = 1; j < fieldsNameEndpoint1.length; j++) {
                                    scriptSentences.add("        newItem.put(\"" + fieldsNameEndpoint1[j] + "\", " + fieldsNameEndpoint1[j] + ");\n");
                                }
                            } else if (isThisEndpoint[2]) {
                                searchingLongInputParameter(keywordsEndpoint2[2] + " ");
                                searchingLongInputParameter(keywordsEndpoint2[5] + " ");
                                searchingLongInputParameter(keywordsEndpoint2[8] + " ");
                                searchingLongInputParameter(keywordsEndpoint2[10] + " ");
                                scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
                                scriptSentences.add("    public void test_" + testCounter + "(" + fieldsTypeEndpoint2[1] + " " + fieldsNameEndpoint2[1] +
                                        ", " + fieldsTypeEndpoint2[4] + " " + fieldsNameEndpoint2[4] + ", " + fieldsTypeEndpoint2[7] + " " + fieldsNameEndpoint2[7] +
                                        ", " + fieldsTypeEndpoint2[9] + " " + fieldsNameEndpoint2[9] + ") {\n");
                                scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
                                scriptSentences.add("        newItem = new HashMap<>();\n");
                                scriptSentences.add("        newItem.put(\"" + parametersURLNameEndpoint2[1] + "\", " + fieldsNameEndpoint2[1] + ");\n");
                                scriptSentences.add("        newItem.put(\"" + parametersURLNameEndpoint2[4] + "\", " + fieldsNameEndpoint2[4] + ");\n");
                                scriptSentences.add("        newItem.put(\"" + parametersURLNameEndpoint2[7] + "\", " + fieldsNameEndpoint2[7] + ");\n");
                                scriptSentences.add("        newItem.put(\"" + parametersURLNameEndpoint2[9] + "\", " + fieldsNameEndpoint2[9] + ");\n");
                            } else if (isThisEndpoint[3]) {
                                for (int j = 2; j < keywordsEndpoint3.length; j++) {
                                    if (fieldsTypeEndpoint3[j - 1].equals("Integer")) {
                                        searchingIntegerInputParameter(keywordsEndpoint3[j] + " ");
                                    } else if (fieldsTypeEndpoint3[j - 1].equals("String")) {
                                        searchingStringInputParameter(keywordsEndpoint3[j] + " ");
                                    }
                                }
                                scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
                                scriptSentences.add("    public void test_" + testCounter + "(" + fieldsTypeEndpoint3[1] + " " + fieldsNameEndpoint3[1] +
                                        ", " + fieldsTypeEndpoint3[2] + " " + fieldsNameEndpoint3[2] + ") {\n");
                                scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
                                scriptSentences.add("        newItem = new HashMap<>();\n");
                                for (int j = 1; j < fieldsNameEndpoint3.length; j++) {
                                    scriptSentences.add("        newItem.put(\"" + fieldsNameEndpoint3[j] + "\", " + fieldsNameEndpoint3[j] + ");\n");
                                }
                            } else if (isThisEndpoint[4]) {
                                for (int j = 2; j < keywordsEndpoint4.length; j++) {
                                    searchingStringInputParameter(keywordsEndpoint4[j] + " ");
                                }
                                scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
                                scriptSentences.add("    public void test_" + testCounter + "(" + fieldsTypeEndpoint4[1] + " " + fieldsNameEndpoint4[1] +
                                        ", " + fieldsTypeEndpoint4[2] + " " + fieldsNameEndpoint4[2] + ") {\n");
                                scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
                                scriptSentences.add("        newItem = new HashMap<>();\n");
                                for (int j = 1; j < fieldsNameEndpoint4.length; j++) {
                                    scriptSentences.add("        newItem.put(\"" + fieldsNameEndpoint4[j] + "\", " + fieldsNameEndpoint4[j] + ");\n");
                                }
                            }
                        //Si el método a tratar es un PATCH, primero se busca el dato de prueba (identificador del item a modificar), se genera la cabecera del método
                        //asociado a la sentencia a tratar, se crea la petición y se añade la variable que va a almacenar el dato de prueba
                        } else if (isPatchMethod) {
                            addingNewLongInputParameter("identifier ", "id");
                        //Si el método a tratar es un DELETE, primero se busca el dato de prueba (identificador del item a eliminar), se genera la cabecera del método
                        //asociado a la sentencia a tratar, se crea la petición y se añade la variable que va a almacenar el dato de prueba
                        } else if (isDeleteMethod) {
                            addingNewLongInputParameter("identifier ", "id");
                        }
                        scriptSentences.add("    }\n");
                        scriptSentences.add("\n");
                    } else if (line.startsWith("When")) {
                        //Se actualiza el número de métodos que se llevan diseñados
                        testCounter++;
                        //En la sentencia del archivo feature que empieza con 'When', sólo aparece información relevante cuando el método a tratar es un PATCH,
                        //en ese caso concreto, se indican los datos de prueba que se van a utilizar en el escenario que se va a tratar
                        //Si el método a tratar es un GET, se genera la cabecera del método asociado a la sentencia a tratar y se crea la respuesta
                        if (isGetMethod) {
                            scriptSentences.add("    @When(\"" + line.substring(5) + "\")\n");
                            scriptSentences.add("    public void test_" + testCounter + "() {\n");
                            scriptSentences.add("        response = request.when().get(\"" + url + ");\n");
                        //Si el método a tratar es un POST, se genera la cabecera del método asociado a la sentencia a tratar y se crea la respuesta
                        } else if (isPostMethod) {
                            scriptSentences.add("    @When(\"" + line.substring(5) + "\")\n");
                            scriptSentences.add("    public void test_" + testCounter + "() {\n");
                            scriptSentences.add("        response = request.when().body(newItem).post(\"" + endpointURL + "\");\n");
                        //Si el método a tratar es un PATCH, en función del endpoint que se está tratando, lo primero se buscan los datos que se quieren modificar
                        //(actualizando que el dato se va a modificar), almacenando su valor en la nueva variable que va a almacenar el nuevo ítem por el que se va a sustituir
                        //el que se quiere modificar
                        } else if (isPatchMethod) {
                            if (isThisEndpoint[0]) {
                                for (int j = 2; j < keywordsEndpoint0.length; j++) {
                                    if (line.toLowerCase().contains(keywordsEndpoint0[j] + " ")) {
                                        isThisFieldUpdatedEndpoint0[j - 2] = true;
                                        addingNewStringFieldValue(keywordsEndpoint0[j] + " ", ", " + fieldsTypeEndpoint0[j - 1] +
                                                " " + fieldsNameEndpoint0[j - 1], fieldsNameEndpoint0[j - 1]);
                                    }
                                }
                            } else if (isThisEndpoint[1]) {
                                if (line.toLowerCase().contains(keywordsEndpoint1[2] + " ")) {
                                    isThisFieldUpdatedEndpoint1[0] = true;
                                    addingNewStringFieldValue(keywordsEndpoint1[2] + " ", ", " + fieldsTypeEndpoint1[1] +
                                            " " + fieldsNameEndpoint1[1], fieldsNameEndpoint1[1]);
                                }
                            } else if (isThisEndpoint[2]) {
                                if (line.toLowerCase().contains(keywordsEndpoint2[2] + " ")) {
                                    isThisFieldUpdatedEndpoint2[0] = true;
                                    addingNewLongFieldValue(keywordsEndpoint2[2] + " ", ", " +
                                            fieldsTypeEndpoint2[1] + " " + fieldsNameEndpoint2[1], parametersURLNameEndpoint2[1], fieldsNameEndpoint2[1]);
                                }
                                if (line.toLowerCase().contains(keywordsEndpoint2[5] + " ")) {
                                    isThisFieldUpdatedEndpoint2[1] = true;
                                    addingNewLongFieldValue(keywordsEndpoint2[5] + " ", ", " +
                                            fieldsTypeEndpoint2[4] + " " + fieldsNameEndpoint2[4], parametersURLNameEndpoint2[4], fieldsNameEndpoint2[4]);
                                }
                                if (line.toLowerCase().contains(keywordsEndpoint2[8] + " ")) {
                                    isThisFieldUpdatedEndpoint2[2] = true;
                                    addingNewLongFieldValue(keywordsEndpoint2[8] + " ", ", " +
                                            fieldsTypeEndpoint2[7] + " " + fieldsNameEndpoint2[7], parametersURLNameEndpoint2[7], fieldsNameEndpoint2[7]);
                                }
                                if (line.toLowerCase().contains(keywordsEndpoint2[10] + " ")) {
                                    isThisFieldUpdatedEndpoint2[3] = true;
                                    addingNewLongFieldValue(keywordsEndpoint2[10] + " ", ", " +
                                            fieldsTypeEndpoint2[9] + " " + fieldsNameEndpoint2[9], parametersURLNameEndpoint2[9], fieldsNameEndpoint2[9]);
                                }
                            } else if (isThisEndpoint[3]) {
                                for (int j = 2; j < keywordsEndpoint3.length; j++) {
                                    if (line.toLowerCase().contains(keywordsEndpoint3[j] + " ")) {
                                        isThisFieldUpdatedEndpoint3[j - 2] = true;
                                        if (fieldsTypeEndpoint3[j - 1].equals("Integer")) {
                                            addingNewIntegerFieldValue(keywordsEndpoint3[j] + " ", ", " + fieldsTypeEndpoint3[j - 1] +
                                                    " " + fieldsNameEndpoint3[j - 1], fieldsNameEndpoint3[j - 1]);
                                        } else if (fieldsTypeEndpoint3[j - 1].equals("String")) {
                                            addingNewStringFieldValue(keywordsEndpoint3[j] + " ", ", " + fieldsTypeEndpoint3[j - 1] +
                                                    " " + fieldsNameEndpoint3[j - 1], fieldsNameEndpoint3[j - 1]);
                                        }
                                    }
                                }
                            } else if (isThisEndpoint[4]) {
                                for (int j = 2; j < keywordsEndpoint4.length; j++) {
                                    if (line.toLowerCase().contains(keywordsEndpoint4[j] + " ")) {
                                        isThisFieldUpdatedEndpoint4[j - 2] = true;
                                        addingNewStringFieldValue(keywordsEndpoint4[j] + " ", ", " + fieldsTypeEndpoint4[j - 1] +
                                                " " + fieldsNameEndpoint4[j - 1], fieldsNameEndpoint4[j - 1]);
                                    }
                                }
                            }
                            //Tras la búsqueda de los datos que se quieren modificar y su almacenamiento, se genera la cabecera del método asociado a la
                            //sentencia a tratar, se añade la variable que va a almacenar el nuevo ítem por el que se va a sustituir el que se quiere modificar,
                            //asignándola los correspondientes datos que se quieren modificar y se han almacenado, y se crea la respuesta
                            scriptSentences.add("    @When(\"" + line.substring(5) + "\")\n");
                            scriptSentences.add("    public void test_" + testCounter + "(" + inputParametersPatch.substring(2) + ") {\n");
                            scriptSentences.add("        newItemToUpdate = new HashMap<>();\n");
                            for (String patchSentence : patchSentences) {
                                scriptSentences.add(patchSentence);
                            }
                            scriptSentences.add("        response = request.when().body(newItemToUpdate).patch(\"" + endpointURL + "/id=\" + id);\n");
                            patchSentences.clear();
                        //Si el método a tratar es un DELETE, se genera la cabecera del método asociado a la sentencia a tratar y se crea la respuesta
                        } else if (isDeleteMethod) {
                            scriptSentences.add("    @When(\"" + line.substring(5) + "\")\n");
                            scriptSentences.add("    public void test_" + testCounter + "() {\n");
                            scriptSentences.add("        response = request.when().delete(\"" + endpointURL + "/id=\" + id);\n");
                        }
                        scriptSentences.add("    }\n");
                        scriptSentences.add("\n");
                    } else if (line.startsWith("Then")) {
                        //Se actualiza el número de métodos que se llevan diseñados
                        testCounter++;
                        //En la sentencia del archivo feature que empieza con 'Then', se indica si va a aparecer algún tipo de error en el escenario que se va a tratar
                        //Se genera la cabecera del método asociado a la sentencia a tratar
                        scriptSentences.add("    @Then(\"" + line.substring(5) + "\")\n");
                        scriptSentences.add("    public void test_" + testCounter + "() {\n");
                        //Si el método a tratar es un GET, lo primero se comprueba si el código de respuesta obtenido es el correcto en función de si
                        //debía aparecer o no un error
                        //Si no debía aparecer ningún error, a mayores en función del endpoint que se está tratando se almacena la respuesta de la petición
                        //(que puede tener uno o varios ítems en función del dato de búsqueda y el endpoint), se recorren todos los datos que aparecen en ella
                        //y si el dato se corresponde con el de la búsqueda, se comprueba que es correcto
                        //En el caso de que la búsqueda sea de todos los datos, sólo se comprueba que la respuesta obtenida no es vacía
                        if (isGetMethod) {
                            if (line.toLowerCase().contains("not found error")) {
                                checkingResponseCode(404);
                            } else {
                                checkingResponseCode(200);
                                if (isThisEndpoint[0]) {
                                    if (isThisFieldSearchEndpoint0[0]) {
                                        checkingAllItemsInformation();
                                    }
                                    for (int j = 0; j < fieldsNameEndpoint0.length; j++) {
                                        if (fieldsTypeEndpoint0[j].equals("Long")) {
                                            if (isThisFieldSearchEndpoint0[j + 1]) {
                                                checkingItemInformationByIdentifierForSimpleEndpoint(identifierExtendedNameEndpoint0);
                                            }
                                        } else if (fieldsTypeEndpoint0[j].equals("String")) {
                                            if (isThisFieldSearchEndpoint0[j + 1]) {
                                                checkingItemsInformationByStringFieldForSimpleEndpoint(fieldsNameEndpoint0[j]);
                                            }
                                        }
                                    }
                                } else if (isThisEndpoint[1]) {
                                    if (isThisFieldSearchEndpoint1[0]) {
                                        checkingAllItemsInformation();
                                    }
                                    for (int j = 0; j < fieldsNameEndpoint1.length; j++) {
                                        if (fieldsTypeEndpoint1[j].equals("Long")) {
                                            if (isThisFieldSearchEndpoint1[j + 1]) {
                                                checkingItemInformationByIdentifierForSimpleEndpoint(identifierExtendedNameEndpoint1);
                                            }
                                        } else if (fieldsTypeEndpoint1[j].equals("String")) {
                                            if (isThisFieldSearchEndpoint1[j + 1]) {
                                                checkingItemInformationByUniqueStringFieldForSimpleEndpoint(fieldsNameEndpoint1[j]);
                                            }
                                        }
                                    }
                                } else if (isThisEndpoint[2]) {
                                    if (isThisFieldSearchEndpoint2[0]) {
                                        checkingAllItemsInformation();
                                    }
                                    if (isThisFieldSearchEndpoint2[1]) {
                                        checkingItemInformationByIdentifierForComplexEndpoint(identifierExtendedNameEndpoint2);
                                    }
                                    for (int j = 2; j <= 4; j++) {
                                        if (isThisFieldSearchEndpoint2[j]) {
                                            if (fieldsTypeEndpoint2[j - 1].equals("Long")) {
                                                checkingItemsInformationByIntegerLongFieldForComplexEndpoint(continuousEndpointName2[1], fieldsNameEndpoint2[j - 1]);
                                            } else if (fieldsTypeEndpoint2[j - 1].equals("Integer")) {
                                                checkingItemsInformationByIntegerLongFieldForComplexEndpoint(continuousEndpointName2[1], fieldsNameEndpoint2[j - 1]);
                                            } else if (fieldsTypeEndpoint2[j - 1].equals("String")) {
                                                checkingItemsInformationByStringFieldForComplexEndpoint(continuousEndpointName2[1], fieldsNameEndpoint2[j - 1]);
                                            }
                                        }
                                    }
                                    for (int j = 5; j <= 7; j++) {
                                        if (isThisFieldSearchEndpoint2[j]) {
                                            if (fieldsTypeEndpoint2[j - 1].equals("Long")) {
                                                checkingItemsInformationByIntegerLongFieldForComplexEndpoint(endpointsName[4], fieldsNameEndpoint2[j - 1]);
                                            } else if (fieldsTypeEndpoint2[j - 1].equals("String")) {
                                                checkingItemsInformationByStringFieldForComplexEndpoint(endpointsName[4], fieldsNameEndpoint2[j - 1]);
                                            }
                                        }
                                    }
                                    for (int j = 8; j <= 9; j++) {
                                        if (isThisFieldSearchEndpoint2[j]) {
                                            if (fieldsTypeEndpoint2[j - 1].equals("Long")) {
                                                checkingItemsInformationByIntegerLongFieldForComplexEndpoint(endpointsName[1], fieldsNameEndpoint2[j - 1]);
                                            } else if (fieldsTypeEndpoint2[j - 1].equals("String")) {
                                                checkingItemsInformationByStringFieldForComplexEndpoint(endpointsName[1], fieldsNameEndpoint2[j - 1]);
                                            }
                                        }
                                    }
                                    for (int j = 10; j <= 13; j++) {
                                        if (isThisFieldSearchEndpoint2[j]) {
                                            if (fieldsTypeEndpoint2[j - 1].equals("Long")) {
                                                checkingItemsInformationByIntegerLongFieldForComplexEndpoint(endpointsName[0], fieldsNameEndpoint2[j - 1]);
                                            } else if (fieldsTypeEndpoint2[j - 1].equals("String")) {
                                                checkingItemsInformationByStringFieldForComplexEndpoint(endpointsName[0], fieldsNameEndpoint2[j - 1]);
                                            }
                                        }
                                    }
                                } else if (isThisEndpoint[3]) {
                                    if (isThisFieldSearchEndpoint3[0]) {
                                        checkingAllItemsInformation();
                                    }
                                    for (int j = 0; j < fieldsNameEndpoint3.length; j++) {
                                        if (fieldsTypeEndpoint3[j].equals("Long")) {
                                            if (isThisFieldSearchEndpoint3[j + 1]) {
                                                checkingItemInformationByIdentifierForSimpleEndpoint(identifierExtendedNameEndpoint3);
                                            }
                                        } else if (fieldsTypeEndpoint3[j].equals("Integer")) {
                                            if (isThisFieldSearchEndpoint3[j + 1]) {
                                                checkingItemInformationByUniqueIntegerFieldForSimpleEndpoint(fieldsNameEndpoint3[j]);
                                            }
                                        } else if (fieldsTypeEndpoint3[j].equals("String")) {
                                            if (isThisFieldSearchEndpoint3[j + 1]) {
                                                checkingItemsInformationByStringFieldForSimpleEndpoint(fieldsNameEndpoint3[j]);
                                            }
                                        }
                                    }
                                } else if (isThisEndpoint[4]) {
                                    if (isThisFieldSearchEndpoint4[0]) {
                                        checkingAllItemsInformation();
                                    }
                                    for (int j = 0; j < fieldsNameEndpoint4.length; j++) {
                                        if (fieldsTypeEndpoint4[j].equals("Long")) {
                                            if (isThisFieldSearchEndpoint4[j + 1]) {
                                                checkingItemInformationByIdentifierForSimpleEndpoint(identifierExtendedNameEndpoint4);
                                            }
                                        } else if (fieldsTypeEndpoint4[j].equals("String")) {
                                            if (isThisFieldSearchEndpoint4[j + 1]) {
                                                checkingItemsInformationByStringFieldForSimpleEndpoint(fieldsNameEndpoint4[j]);
                                            }
                                        }
                                    }
                                }
                            }
                        //Si el método a tratar es un POST, lo primero se comprueba si el código de respuesta obtenido es el correcto en función de si
                        //debía aparecer o no un error
                        //Si no debía aparecer ningún error, a mayores se almacena la respuesta de la petición (que debe tener un único ítem) y en función del endpoint
                        //que se está tratando, se recorren todos los datos que aparecen en ella (menos el dato que se corresponde con el identificador del ítem) y
                        //se comprueba que son correctos
                        } else if (isPostMethod) {
                            if (line.toLowerCase().contains("bad request error")) {
                                checkingResponseCode(400);
                            } else if (line.toLowerCase().contains("not found error")) {
                                checkingResponseCode(404);
                            } else if (line.toLowerCase().contains("duplicated information error")) {
                                checkingResponseCode(409);
                            } else {
                                checkingResponseCode(201);
                                scriptSentences.add("        uniqueResponseInformation = JsonPath.from(response.asString()).get();\n");
                                scriptSentences.add("        for (Map.Entry<String, Object> entry : uniqueResponseInformation.entrySet()) {\n");
                                if (isThisEndpoint[0]) {
                                    for (int j = 1; j < fieldsNameEndpoint0.length; j++) {
                                        checkingNewStringFieldValueForSimpleEndpoint("newItem", fieldsNameEndpoint0[j]);
                                    }
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[1]) {
                                    checkingNewStringFieldValueForSimpleEndpoint("newItem", fieldsNameEndpoint1[1]);
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[2]) {
                                    scriptSentences.add("            key = entry.getKey();\n");
                                    scriptSentences.add("            value = entry.getValue();\n");
                                    checkingIdentifierFieldValueForComplexEndpoint("newItem", continuousEndpointName2[1],
                                            fieldsNameEndpoint2[1], parametersURLNameEndpoint2[1]);
                                    checkingIdentifierFieldValueForComplexEndpoint("newItem", endpointsName[4], fieldsNameEndpoint2[4], parametersURLNameEndpoint2[4]);
                                    checkingIdentifierFieldValueForComplexEndpoint("newItem", endpointsName[1], fieldsNameEndpoint2[7], parametersURLNameEndpoint2[7]);
                                    checkingIdentifierFieldValueForComplexEndpoint("newItem", endpointsName[0], fieldsNameEndpoint2[9], parametersURLNameEndpoint2[9]);
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[3]) {
                                    for (int j = 1; j < fieldsNameEndpoint3.length; j++) {
                                        if (fieldsTypeEndpoint3[j].equals("Integer")) {
                                            checkingNewIntegerFieldValueForSimpleEndpoint("newItem", fieldsNameEndpoint3[j]);
                                        } else if (fieldsTypeEndpoint3[j].equals("String")) {
                                            checkingNewStringFieldValueForSimpleEndpoint("newItem", fieldsNameEndpoint3[j]);
                                        }
                                    }
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[4]) {
                                    checkingNewStringFieldValueForSimpleEndpoint("newItem", fieldsNameEndpoint4[1]);
                                    checkingNewNullableStringFieldValueForSimpleEndpoint("newItem", fieldsNameEndpoint4[2]);
                                    scriptSentences.add("        }\n");
                                }
                            }
                        //Si el método a tratar es un PATCH, lo primero se comprueba si el código de respuesta obtenido es el correcto en función de si
                        //debía aparecer o no un error
                        //Si no debía aparecer ningún error, a mayores se almacena la respuesta de la petición (que debe tener un único ítem) y en función del endpoint
                        //que se está tratando, se recorren todos los datos que aparecen en ella y si han sido modificados o el dato se corresponde con el identificador
                        //del ítem, se comprueba que son correctos
                        } else if (isPatchMethod) {
                            if (line.toLowerCase().contains("bad request error")) {
                                checkingResponseCode(400);
                            } else if (line.toLowerCase().contains("not found error")) {
                                checkingResponseCode(404);
                            } else if (line.toLowerCase().contains("duplicated information error")) {
                                checkingResponseCode(409);
                            } else {
                                checkingResponseCode(200);
                                scriptSentences.add("        uniqueResponseInformation = JsonPath.from(response.asString()).get();\n");
                                scriptSentences.add("        for (Map.Entry<String, Object> entry : uniqueResponseInformation.entrySet()) {\n");
                                if (isThisEndpoint[0]) {
                                    checkingIdentifierFieldValueForSimpleEndpoint(identifierExtendedNameEndpoint0);
                                    for (int j = 1; j < fieldsNameEndpoint0.length; j++) {
                                        if (isThisFieldUpdatedEndpoint0[j - 1]) {
                                            checkingNewStringFieldValueForSimpleEndpoint("newItemToUpdate", fieldsNameEndpoint0[j]);
                                        }
                                    }
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[1]) {
                                    checkingIdentifierFieldValueForSimpleEndpoint(identifierExtendedNameEndpoint1);
                                    if (isThisFieldUpdatedEndpoint1[0]) {
                                        checkingNewStringFieldValueForSimpleEndpoint("newItemToUpdate", fieldsNameEndpoint1[1]);
                                    }
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[2]) {
                                    scriptSentences.add("            key = entry.getKey();\n");
                                    scriptSentences.add("            value = entry.getValue();\n");
                                    checkingIdentifierValueForComplexEndpoint(identifierExtendedNameEndpoint2);
                                    if (isThisFieldUpdatedEndpoint2[0]) {
                                        checkingIdentifierFieldValueForComplexEndpoint("newItemToUpdate", continuousEndpointName2[1],
                                                fieldsNameEndpoint2[1], parametersURLNameEndpoint2[1]);
                                    }
                                    if (isThisFieldUpdatedEndpoint2[1]) {
                                        checkingIdentifierFieldValueForComplexEndpoint("newItemToUpdate", endpointsName[4],
                                                fieldsNameEndpoint2[4], parametersURLNameEndpoint2[4]);
                                    }
                                    if (isThisFieldUpdatedEndpoint2[2]) {
                                        checkingIdentifierFieldValueForComplexEndpoint("newItemToUpdate", endpointsName[1],
                                                fieldsNameEndpoint2[7], parametersURLNameEndpoint2[7]);
                                    }
                                    if (isThisFieldUpdatedEndpoint2[3]) {
                                        checkingIdentifierFieldValueForComplexEndpoint("newItemToUpdate", endpointsName[0],
                                                fieldsNameEndpoint2[9], parametersURLNameEndpoint2[9]);
                                    }
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[3]) {
                                    checkingIdentifierFieldValueForSimpleEndpoint(identifierExtendedNameEndpoint3);
                                    for (int j = 1; j < fieldsNameEndpoint3.length; j++) {
                                        if (isThisFieldUpdatedEndpoint3[j - 1]) {
                                            if (fieldsTypeEndpoint4[j].equals("Integer")) {
                                                checkingNewIntegerFieldValueForSimpleEndpoint("newItemToUpdate", fieldsNameEndpoint3[j]);
                                            } else if (fieldsTypeEndpoint4[j].equals("String")) {
                                                checkingNewStringFieldValueForSimpleEndpoint("newItemToUpdate", fieldsNameEndpoint3[j]);
                                            }
                                        }
                                    }
                                    scriptSentences.add("        }\n");
                                } else if (isThisEndpoint[4]) {
                                    checkingIdentifierFieldValueForSimpleEndpoint(identifierExtendedNameEndpoint4);
                                    if (isThisFieldUpdatedEndpoint4[0]) {
                                        checkingNewStringFieldValueForSimpleEndpoint("newItemToUpdate", fieldsNameEndpoint4[1]);
                                    }
                                    if (isThisFieldUpdatedEndpoint4[1]) {
                                        checkingNewNullableStringFieldValueForSimpleEndpoint("newItemToUpdate", fieldsNameEndpoint4[2]);
                                    }
                                    scriptSentences.add("        }\n");
                                }
                            }
                        //Si el método a tratar es un DELETE, se comprueba si el código de respuesta obtenido es el correcto en función de si debía aparecer o no un error
                        } else if (isDeleteMethod) {
                            if (line.toLowerCase().contains("not found error")) {
                                checkingResponseCode(404);
                            } else {
                                checkingResponseCode(204);
                            }
                        }
                        scriptSentences.add("    }\n");
                        scriptSentences.add("\n");
                        url = "";
                    }
                    //Si la sentencia del archivo feature no ha aparecido previamente en él, se escribe en el archivo con los steps definition el código generado
                    //asociado a dicha sentencia y se añade dicha sentencia a la lista con todas las sentencias que aparecen en el archivo feature
                    if (!featureSentences.contains(line)) {
                        for (String scriptSentence : scriptSentences) {
                            outputBuffer.write(scriptSentence);
                        }
                        featureSentences.add(line);
                    }
                    //Se vacía la lista que almacena todas las sentencias que se van a añadir en el archivo con los steps definition
                    scriptSentences.clear();
                }
                line = inputBuffer.readLine();
            }
            outputBuffer.write("}\n");
            //Se liberan diferentes recursos utilizados por el framework
            outputBuffer.flush();
            outputBuffer.close();
        } else if (response.trim().toUpperCase().equals("N")) {
            System.out.println("Please review the 'Readme.txt' file before executing the program again.");
        }
    }

    //Método para añadir el paquete, los imports, el nombre de la clase y las variables que tendrá el archivo con los steps definition
    private static void addingPackageImportsClassVariablesSentences(BufferedWriter outputBuffer, String response) throws IOException {
        outputBuffer.write("package com.exampleAPI.olympicGames.stepsDefinition;\n");
        outputBuffer.write("\n");
        outputBuffer.write("import com.exampleAPI.olympicGames.runners.CucumberSpringConfiguration;\n");
        outputBuffer.write("import io.cucumber.java.en.Given;\n");
        outputBuffer.write("import io.cucumber.java.en.Then;\n");
        outputBuffer.write("import io.cucumber.java.en.When;\n");
        outputBuffer.write("import io.restassured.path.json.JsonPath;\n");
        outputBuffer.write("import io.restassured.response.Response;\n");
        outputBuffer.write("import io.restassured.specification.RequestSpecification;\n");
        outputBuffer.write("import org.junit.Assert;\n");
        outputBuffer.write("\n");
        outputBuffer.write("import java.util.HashMap;\n");
        outputBuffer.write("import java.util.List;\n");
        outputBuffer.write("import java.util.Map;\n");
        outputBuffer.write("\n");
        outputBuffer.write("import static io.restassured.RestAssured.given;\n");
        outputBuffer.write("\n");
        outputBuffer.write("public class " + response + " extends CucumberSpringConfiguration {\n");
        outputBuffer.write("\n");
        outputBuffer.write("    private RequestSpecification request;\n");
        outputBuffer.write("    private Response response;\n");
        outputBuffer.write("    private Map<String, Object> uniqueResponseInformation, newItem, newItemToUpdate;\n");
        outputBuffer.write("    private List<Map<String, Object>> responseInformation;\n");
    }

    //Método para inicializar las variables con los valores iniciales que deben tener en cada uno de los escenarios a tratar
    private static void initializeVariables() {
        isGetMethod = false;
        isPostMethod = false;
        isPatchMethod = false;
        isDeleteMethod = false;
        isThisFieldSearchEndpoint0 = new boolean[]{false, false, false, false, false};
        isThisFieldSearchEndpoint1 = new boolean[]{false, false, false};
        isThisFieldSearchEndpoint2 = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        isThisFieldSearchEndpoint3 = new boolean[]{false, false, false, false};
        isThisFieldSearchEndpoint4 = new boolean[]{false, false, false, false};
    }

    //Método para generar la cabecera del método asociado a la sentencia a tratar y crear la petición
    private static void addingGivenSentencesAllSearch() {
        scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
        scriptSentences.add("    public void test_" + testCounter + "() {\n");
        scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
    }

    //Método para buscar una keyword, obtener el dato de tipo entero asociado a dicha keyword y sustituir su valor por {int}
    private static void searchingIntegerInputParameter(String keyword) {
        posFieldSearch = line.toLowerCase().indexOf(keyword);
        posSpace = line.indexOf(" ", posFieldSearch + keyword.length() + 1);
        if (posSpace != -1) {
            integerItem = Integer.parseInt(line.substring(posFieldSearch + keyword.length(), posSpace));
        } else {
            integerItem = Integer.parseInt(line.substring(posFieldSearch + keyword.length()));
        }
        line = line.replaceFirst(integerItem.toString(), "{int}");
    }

    //Método para buscar una keyword que tiene asociada un dato de tipo entero y asignar el valor de tipo entero asociado a dicha keyword en la nueva variable
    //que va a almacenar el nuevo ítem por el que se va a sustituir el que se quiere modificar
    private static void addingNewIntegerFieldValue(String keyword, String inputParameter, String integerFieldName) {
        searchingIntegerInputParameter(keyword);
        inputParametersPatch = inputParametersPatch + inputParameter;
        patchSentences.add("        newItemToUpdate.put(\"" + integerFieldName + "\", " + integerFieldName + ");\n");
    }

    //Método para buscar el dato de tipo entero por el que se quiere realizar la búsqueda, generar la cabecera del método asociado a la sentencia a tratar
    //y crear la petición y la variable que va a almacenar el dato de tipo entero por el que se va a realizar la búsqueda
    private static void addingNewIntegerInputParameter(String keyword, String integerInputParameterName) {
        searchingIntegerInputParameter(keyword);
        inputParameters = "Integer " + integerInputParameterName;
        scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
        scriptSentences.add("    public void test_" + testCounter + "(" + inputParameters + ") {\n");
        scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
        scriptSentences.add("        this." + integerInputParameterName + " = " + integerInputParameterName + ";\n");
    }

    //Método para buscar una keyword, obtener el dato de tipo entero largo asociado a dicha keyword y sustituir su valor por {long}
    private static void searchingLongInputParameter(String keyword) {
        posFieldSearch = line.toLowerCase().indexOf(keyword);
        posSpace = line.indexOf(" ", posFieldSearch + keyword.length() + 1);
        if (posSpace != -1) {
            longItem = Long.parseLong(line.substring(posFieldSearch + keyword.length(), posSpace));
        } else {
            longItem = Long.parseLong(line.substring(posFieldSearch + keyword.length()));
        }
        line = line.replaceFirst(longItem.toString(), "{long}");
    }

    //Método para buscar una keyword que tiene asociada un dato de tipo entero largo y asignar el valor de tipo entero largo asociado a dicha keyword en la nueva variable
    //que va a almacenar el nuevo ítem por el que se va a sustituir el que se quiere modificar
    private static void addingNewLongFieldValue(String keyword, String inputParameter, String longFieldName1, String longFieldName2) {
        searchingLongInputParameter(keyword);
        inputParametersPatch = inputParametersPatch + inputParameter;
        patchSentences.add("        newItemToUpdate.put(\"" + longFieldName1 + "\", " + longFieldName2 + ");\n");
    }

    //Método para buscar el dato de tipo entero largo por el que se quiere realizar la búsqueda o correspondiente al identificador del ítem a modificar o eliminar,
    //generar la cabecera del método asociado a la sentencia a tratar y crear la petición y la variable que va a almacenar el dato de tipo entero largo por el que se
    //va a realizar la búsqueda o correspondiente al identificador del ítem a modificar o eliminar
    private static void addingNewLongInputParameter(String keyword, String longInputParameterName) {
        searchingLongInputParameter(keyword);
        inputParameters = "Long " + longInputParameterName;
        scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
        scriptSentences.add("    public void test_" + testCounter + "(" + inputParameters + ") {\n");
        scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
        scriptSentences.add("        this." + longInputParameterName + " = " + longInputParameterName + ";\n");
    }

    //Método para buscar una keyword, obtener el dato de tipo texto asociado a dicha keyword y sustituir su valor por {string}
    private static void searchingStringInputParameter(String keyword) {
        posFieldSearch = line.toLowerCase().indexOf(keyword);
        posQuotationMarks = line.indexOf("\"", posFieldSearch + keyword.length() + 1);
        stringItem = line.substring(posFieldSearch + keyword.length() + 1, posQuotationMarks);
        line = line.replaceFirst("\"" + stringItem + "\"", "{string}");
    }

    //Método para buscar una keyword que tiene asociada un dato de tipo texto y asignar el valor de tipo texto asociado a dicha keyword en la nueva variable
    //que va a almacenar el nuevo ítem por el que se va a sustituir el que se quiere modificar
    private static void addingNewStringFieldValue(String keyword, String inputParameter, String stringFieldName) {
        searchingStringInputParameter(keyword);
        inputParametersPatch = inputParametersPatch + inputParameter;
        patchSentences.add("        newItemToUpdate.put(\"" + stringFieldName + "\", " + stringFieldName + ");\n");
    }

    //Método para buscar el dato de tipo texto por el que se quiere realizar la búsqueda, generar la cabecera del método asociado a la sentencia a tratar
    //y crear la petición y la variable que va a almacenar el dato de tipo texto por el que se va a realizar la búsqueda
    private static void addingNewStringInputParameter(String keyword, String stringInputParameterName) {
        searchingStringInputParameter(keyword);
        inputParameters = "String " + stringInputParameterName;
        scriptSentences.add("    @Given(\"" + line.substring(6) + "\")\n");
        scriptSentences.add("    public void test_" + testCounter + "(" + inputParameters + ") {\n");
        scriptSentences.add("        request = given().header(\"Content-Type\", \"application/json\");\n");
        scriptSentences.add("        this." + stringInputParameterName + " = " + stringInputParameterName + ";\n");
    }

    //Método para comprobar que el dato de tipo entero que se ha modificado o añadido en la petición enviada, se muestra correctamente en la respuesta obtenida
    private static void checkingNewIntegerFieldValueForSimpleEndpoint(String newOrUpdate, String integerFieldName) {
        scriptSentences.add("            if (entry.getKey().equals(\"" + integerFieldName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals((" + newOrUpdate + ".get(\"" + integerFieldName + "\")).toString(), entry.getValue().toString());\n");
        scriptSentences.add("            }\n");
    }

    //Método para comprobar que el dato de tipo texto que se ha modificado o añadido en la petición enviada, se muestra correctamente en la respuesta obtenida
    private static void checkingNewStringFieldValueForSimpleEndpoint(String newOrUpdate, String stringFieldName) {
        scriptSentences.add("            if (entry.getKey().equals(\"" + stringFieldName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(" + newOrUpdate + ".get(\"" + stringFieldName + "\"), entry.getValue());\n");
        scriptSentences.add("            }\n");
    }

    //Método para comprobar que el dato de tipo texto que se ha modificado o añadido en la petición enviada (y que puede ser nulo), se muestra correctamente
    //en la respuesta obtenida
    private static void checkingNewNullableStringFieldValueForSimpleEndpoint(String newOrUpdate, String nullableStringFieldName) {
        scriptSentences.add("            if (entry.getKey().equals(\"" + nullableStringFieldName + "\")) {\n");
        scriptSentences.add("                if (entry.getValue() != null) {\n");
        scriptSentences.add("                    Assert.assertEquals(" + newOrUpdate + ".get(\"" + nullableStringFieldName + "\"), entry.getValue());\n");
        scriptSentences.add("                } else {\n");
        scriptSentences.add("                    Assert.assertNull(entry.getValue());\n");
        scriptSentences.add("                }\n");
        scriptSentences.add("            }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos simple, que el identificador del ítem que se ha modificado en la petición enviada,
    //se muestra correctamente en la respuesta obtenida
    private static void checkingIdentifierFieldValueForSimpleEndpoint(String identifierName) {
        scriptSentences.add("            if (entry.getKey().equals(\"" + identifierName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(id.toString(), entry.getValue().toString());\n");
        scriptSentences.add("            }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos compleja, que el identificador del ítem que se ha modificado en la petición enviada,
    //se muestra correctamente en la respuesta obtenida
    private static void checkingIdentifierValueForComplexEndpoint(String identifierName) {
        scriptSentences.add("            if (key.equals(\"" + identifierName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(id.toString(), value.toString());\n");
        scriptSentences.add("            }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos compleja, que el identificador del dato modificado en la petición enviada,
    //se muestra correctamente en la respuesta obtenida
    private static void checkingIdentifierFieldValueForComplexEndpoint(String newOrUpdate, String endpointName, String identifierName1, String identifierName2) {
        scriptSentences.add("            if (key.equals(\"" + endpointName + "\")) {\n");
        scriptSentences.add("                for (Map.Entry<String, Object> entryItem : ((Map<String, Object>) value).entrySet()) {\n");
        scriptSentences.add("                    if (entryItem.getKey().equals(\"" + identifierName1 + "\")) {\n");
        scriptSentences.add("                        Assert.assertEquals((" + newOrUpdate + ".get(\"" + identifierName2 + "\")).toString(), entryItem.getValue().toString());\n");
        scriptSentences.add("                    }\n");
        scriptSentences.add("                }\n");
        scriptSentences.add("            }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos simple, que el identificador del ítem por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que sólo tiene un ítem)
    private static void checkingItemInformationByIdentifierForSimpleEndpoint(String identifierName) {
        scriptSentences.add("        uniqueResponseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map.Entry<String, Object> entry : uniqueResponseInformation.entrySet()) {\n");
        scriptSentences.add("            if (entry.getKey().equals(\"" + identifierName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(id.toString(), entry.getValue().toString());\n");
        scriptSentences.add("                break;\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos simple, que el dato de tipo entero (que además es único) por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que sólo tiene un ítem)
    private static void checkingItemInformationByUniqueIntegerFieldForSimpleEndpoint(String uniqueIntegerFieldName) {
        scriptSentences.add("        uniqueResponseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map.Entry<String, Object> entry : uniqueResponseInformation.entrySet()) {\n");
        scriptSentences.add("            if (entry.getKey().equals(\"" + uniqueIntegerFieldName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(" + uniqueIntegerFieldName + ".toString(), entry.getValue().toString());\n");
        scriptSentences.add("                break;\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos simple, que el dato de tipo texto (que además es único) por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que sólo tiene un ítem)
    private static void checkingItemInformationByUniqueStringFieldForSimpleEndpoint(String uniqueStringFieldName) {
        scriptSentences.add("        uniqueResponseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map.Entry<String, Object> entry : uniqueResponseInformation.entrySet()) {\n");
        scriptSentences.add("            if (entry.getKey().equals(\"" + uniqueStringFieldName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(" + uniqueStringFieldName + ", entry.getValue());\n");
        scriptSentences.add("                break;\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos compleja, que el identificador del ítem por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que sólo tiene un ítem)
    private static void checkingItemInformationByIdentifierForComplexEndpoint(String identifierName) {
        scriptSentences.add("        uniqueResponseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map.Entry<String, Object> entry : uniqueResponseInformation.entrySet()) {\n");
        scriptSentences.add("            key = entry.getKey();\n");
        scriptSentences.add("            value = entry.getValue();\n");
        scriptSentences.add("            if (key.equals(\"" + identifierName + "\")) {\n");
        scriptSentences.add("                Assert.assertEquals(id.toString(), value.toString());\n");
        scriptSentences.add("                break;\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos simple, que el dato de tipo texto por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que tiene varios ítems)
    private static void checkingItemsInformationByStringFieldForSimpleEndpoint(String stringFieldName) {
        scriptSentences.add("        responseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map<String, Object> item : responseInformation) {\n");
        scriptSentences.add("            for (Map.Entry<String, Object> entry : item.entrySet()) {\n");
        scriptSentences.add("                if (entry.getKey().equals(\"" + stringFieldName + "\")) {\n");
        scriptSentences.add("                    Assert.assertEquals(" + stringFieldName + ", entry.getValue());\n");
        scriptSentences.add("                    break;\n");
        scriptSentences.add("                }\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos compleja, que el dato de tipo entero o entero largo por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que tiene varios ítems)
    private static void checkingItemsInformationByIntegerLongFieldForComplexEndpoint(String endpointName, String integerLongFieldName) {
        scriptSentences.add("        responseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map<String, Object> item : responseInformation) {\n");
        scriptSentences.add("            for (Map.Entry<String, Object> entry : item.entrySet()) {\n");
        scriptSentences.add("                key = entry.getKey();\n");
        scriptSentences.add("                value = entry.getValue();\n");
        scriptSentences.add("                if (key.equals(\"" + endpointName + "\")) {\n");
        scriptSentences.add("                    for (Map.Entry<String, Object> entryItem : ((Map<String, Object>) value).entrySet()) {\n");
        scriptSentences.add("                        if (entryItem.getKey().equals(\"" + integerLongFieldName + "\")) {\n");
        scriptSentences.add("                            Assert.assertEquals(" + integerLongFieldName + ".toString(), entryItem.getValue().toString());\n");
        scriptSentences.add("                            break;\n");
        scriptSentences.add("                        }\n");
        scriptSentences.add("                    }\n");
        scriptSentences.add("                }\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar, en los endpoints que tienen una estructura de datos compleja, que el dato de tipo texto por el que se realiza la búsqueda en la
    //petición enviada, se muestra correctamente en la respuesta obtenida (que tiene varios ítems)
    private static void checkingItemsInformationByStringFieldForComplexEndpoint(String endpointName, String stringFieldName) {
        scriptSentences.add("        responseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        for (Map<String, Object> item : responseInformation) {\n");
        scriptSentences.add("            for (Map.Entry<String, Object> entry : item.entrySet()) {\n");
        scriptSentences.add("                key = entry.getKey();\n");
        scriptSentences.add("                value = entry.getValue();\n");
        scriptSentences.add("                if (key.equals(\"" + endpointName + "\")) {\n");
        scriptSentences.add("                    for (Map.Entry<String, Object> entryItem : ((Map<String, Object>) value).entrySet()) {\n");
        scriptSentences.add("                        if (entryItem.getKey().equals(\"" + stringFieldName + "\")) {\n");
        scriptSentences.add("                            Assert.assertEquals(" + stringFieldName + ", entryItem.getValue());\n");
        scriptSentences.add("                            break;\n");
        scriptSentences.add("                        }\n");
        scriptSentences.add("                    }\n");
        scriptSentences.add("                }\n");
        scriptSentences.add("            }\n");
        scriptSentences.add("        }\n");
    }

    //Método para comprobar que cuando se hace una búsqueda de todos los datos, la respuesta obtenida de la petición enviada no es vacía
    private static void checkingAllItemsInformation() {
        scriptSentences.add("        responseInformation = JsonPath.from(response.asString()).get();\n");
        scriptSentences.add("        Assert.assertFalse(responseInformation.isEmpty());\n");
    }

    //Método para comprobar que el código de respuesta obtenido de la petición enviada, es correcto
    private static void checkingResponseCode(int responseCode) {
        scriptSentences.add("        Assert.assertEquals(" + responseCode + ", response.getStatusCode());\n");
    }
}