package carros; /**
 * Escreva a descrição da classe CoordinateManager aqui.
 * 
 * 
 * @version (número de versão ou data)
 */

import java.util.HashMap;

public class CoordinateManager{
  
  /**
   * Constante para a latitude mínima.
   */
  public static final double MIN_LATITUDE = -90.0000;
  
  /**
   * Constante para a latitude máxima.
   */
  public static final double MAX_LATITUDE = 90.0000;
  
  /**
   * Constante para a longitude mínima.
   */
  public static final double MIN_LONGITUDE = -180.0000;
  
  /**
   * Constante para a longitude máxima.
   */
  public static final double MAX_LONGITUDE = 180.0000;
  
  /**
   * Constante para o diâmentro da Terra.
   */
  public static final double EARTH_DIAMETER = 12756.274;

  private static final String ILLEGAL_PARAMETER_MSG = "All parameters are required and must be valid";

  private CoordinateManager(){}

  /**
   *  Método que valida a latitude.
   *  @return true se a latitude está dentro do minimo e do maximo de latitude.  
   */
  
  public static boolean isValidLatitude(double latitude) {
    return latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE;
  }
  
  /**
   *  Método que valida a longitude.
   *  @return true se a longitude está dentro do minimo e do maximo de longitude. 
   */
  
  public static boolean isValidLongitude(double longitude) {
    return longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE;
  }
  
  /**
   * @return um double que representa a constante da latitude.
   */
  
  public static double latitudeConstant() {
    return EARTH_DIAMETER * (Math.PI / Double.valueOf("360"));
  }
  
  /**
   * @return um double que representa a constante da longitude.
   */
  
  public static double longitudeConstant(double latitude) {
    return EARTH_DIAMETER * Math.PI * Math.abs(Math.cos(Math.abs(latitude))) / Double.valueOf("360");
  }
  
  
  /**
   * Método que adiciona uma distancia na direção NORTE a uma coordenada
   * @return coordenada atualizada
   */
  public static Coordinate addDistanceNorth(double latitude, double longitude, int distance) {
  
    // verifica os parametros
    if(!isValidLatitude(latitude) || !isValidLongitude(longitude) || distance <= 0) {
      throw new IllegalArgumentException(ILLEGAL_PARAMETER_MSG);
    }
    
    // converte metros para km
    double kilometers = distance / (double) 1000;
    
    // calcula a nova latitude
    double newLat = latitude + (kilometers / latitudeConstant());
    
    return new Coordinate(newLat, longitude);
  
  }
  
   /**
   * Método que adiciona uma distancia na direção SUL a uma coordenada
   * @return coordenada atualizada
   */
  public static Coordinate addDistanceSouth(double latitude, double longitude, int distance) {
  
    // verifica os parametros
    if(!isValidLatitude(latitude) || !isValidLongitude(longitude) || distance <= 0) {
      throw new IllegalArgumentException(ILLEGAL_PARAMETER_MSG);
    }
    
    // converte metros para km
    double kilometers = distance / (double) 1000;
    
    // calcula a nova latitude
    double newLat = latitude - (kilometers / latitudeConstant());
    
    return new Coordinate(newLat, longitude);
  
  }
  
  /**
   * Método que adiciona uma distancia na direção ESTE a uma coordenada
   * @return coordenada atualizada
   */
  public static Coordinate addDistanceEast(double latitude, double longitude, int distance) {
  
    // verifica os parametros
    if(!isValidLatitude(latitude) || !isValidLongitude(longitude) || distance <= 0) {
      throw new IllegalArgumentException(ILLEGAL_PARAMETER_MSG);
    }
    
    // calcula a nova longitude
    double newLng = longitude + (distance / longitudeConstant(latitude));
    
    return new Coordinate(latitude, newLng);
  }
  
  /**
   * Método que adiciona uma distancia na direção OESTE a uma coordenada
   * @return coordenada atualizada
   */
  
  public static Coordinate addDistanceWest(double latitude, double longitude, int distance) {
  
    // verifica os parametros
    if(!isValidLatitude(latitude) || !isValidLongitude(longitude) || distance <= 0) {
      throw new IllegalArgumentException(ILLEGAL_PARAMETER_MSG);
    }
    
    // calcula a nova longitude
    double newLng = longitude - (distance / longitudeConstant(latitude));
    
    return new Coordinate(latitude, newLng);
  }
  
   /**
   * A method to build four coordinates representing a bounding box given a start coordinate and a distance
   * Método que constroi quatro coordenadas representando uma "bounding box" dando uma coordenada
   * de partida e uma distância
   * @return  um hashMap que representa a bounding box (NE,SE,SW,NW).
   */
  
  public static java.util.HashMap<String, Coordinate> getBoundingBox(double latitude, double longitude, int distance) {
  
    // verifica os parametros
    if(!isValidLatitude(latitude) || !isValidLongitude(longitude) || distance <= 0) {
      throw new IllegalArgumentException(ILLEGAL_PARAMETER_MSG);
    }
    
    HashMap<String, Coordinate> boundingBox = new java.util.HashMap<>();
    
    // calcula coordenadas
    Coordinate north = addDistanceNorth(latitude, longitude, distance);
    Coordinate south = addDistanceSouth(latitude, longitude, distance);
    Coordinate east  = addDistanceEast(latitude, longitude, distance);
    Coordinate west  = addDistanceWest(latitude, longitude, distance);
    
    // constroi a bounding box
    boundingBox.put("NE", new Coordinate(north.getLatitude(), east.getLongitude()));
    boundingBox.put("SE", new Coordinate(south.getLatitude(), east.getLongitude()));
    boundingBox.put("SW", new Coordinate(south.getLatitude(), west.getLongitude()));
    boundingBox.put("NW", new Coordinate(north.getLatitude(), west.getLongitude()));
    
    return boundingBox;  
  }
  
  
}
