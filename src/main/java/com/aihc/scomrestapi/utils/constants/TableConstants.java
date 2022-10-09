package com.aihc.scomrestapi.utils.constants;

public class TableConstants {

  public static final String USER_TABLE = "usuario";
  public static final String USER_ID = "id_u";
  public static final String USERNAME = "username";
  public static final String NAME = "nombre";
  public static final String FATHER_LASTNAME = "ap_paterno";
  public static final String MOTHER_LASTNAME = "ap_materno";
  public static final String EMAIL = "email";
  public static final String PASSWORD = "contrasenia";
  public static final String ADDRESS_USER = "direccion";

  public static final String CUSTOMER_TABLE = "cliente";

  public static final String WAITER_TABLE = "camarero";
  public static final String SALARY = "salario";
  public static final String EXPERIENCE = "experiencia";
  public static final String HEALTH_CODE = "cod_sanidad";

  public static final String CHEF_TABLE = "chef";
  public static final String NATIONALITY = "nacionalidad";
  public static final String SPECIALTY = "especialidad";

  public static final String CASHIER_TABLE = "cajero";
  public static final String DEGREE = "titulo";

  public static final String ADMINISTRATOR_TABLE = "administrador";

  public static final String RATING_TABLE = "calificacion";
  public static final String RATING_ID = "id_c";
  public static final String VALUE = "valoracion";
  public static final String MESSAGE = "mensaje";
  public static final String DATE = "fecha";

  public static final String INGREDIENT_TABLE = "ingrediente";
  public static final String INGREDIENT_ID = "id_i";
  public static final String PRICE = "precio";

  public static final String PRODUCT_TABLE = "producto";
  public static final String PRODUCT_ID = "id_p";

  public static final String FOOD_TABLE = "plato";
  public static final String TYPE = "tipo";

  public static final String DRINK_TABLE = "bebida";
  public static final String BRAND = "marca";
  public static final String ALCOHOLIC_GRADE = "grado_alcoholico";
  public static final String VOLUME = "volumen";

  public static final String ORDER_TABLE = "pedido";
  public static final String ORDER_ID = "id_pe";
  public static final String DATE_BILL = "fecha_factura";

  public static final String TABLE_REST_TABLE = "mesa";
  public static final String TABLE_ID = "id_m";
  public static final String CAPACITY = "capacidad";
  public static final String NUMBER = "numero";

  public static final String BILL_TABLE = "factura";
  public static final String BILL_ID = "id_f";

  public static final String CUSTOMER_AS_FOREIGN = "id_cliente";
  public static final String CASHIER_AS_FOREIGN = "id_cajero";
  public static final String CHEF_AS_FOREIGN = "id_chef";
  public static final String WAITER_AS_FOREIGN = "id_camarero";
  public static final String BILL_AS_FOREIGN = "id_factura";
  public static final String RESTAURANT_TABLE_AS_FOREIGN = "id_mesa";
  public static final String INGREDIENT_AS_FOREIGN = "id_ingrediente";
  public static final String FOOD_AS_FOREIGN = "id_plato";
  public static final String ORDER_AS_FOREIGN = "id_pedido";
  public static final String PRODUCT_AS_FOREIGN = "id_producto";

  public static final String CHEF_INGREDIENT_RELATIONSHIP = "solicita";
  public static final String FOOD_INGREDIENT_RELATIONSHIP = "cuenta";
  public static final String ORDER_PRODUCT_RELATIONSHIP = "tiene";
  public static final String WAITER_RESTAURANT_TABLE_RELATIONSHIP = "atiende";

  public static final String AMOUNT = "cantidad";
  public static final String QUESTION_ANSWER_ID = "id_pr";
  public static final String QUESTION = "pregunta";
  public static final String ANSWER = "respuesta";
  public static final String ADMINISTRATOR_AS_FOREIGN = "id_admin";
  public static final String QUESTION_ANSWER = "preg_resp";
  public static final String MISSION_VISION = "mis_vis";
  public static final String MISSION_VISION_ID = "id_mv";
  public static final String MISSION = "mision";
  public static final String VISION = "vision";
  public static final int MISSION_LENGTH = 512;
  public static final int VISION_LENGTH = 512;
  public static final String IMAGE = "imagen";
  public static final String IMAGE_ID = "id_i";
  public static final String PUBLIC_ID = "public_id";
  public static final String IMAGE_AS_FOREIGN = "id_imagen";
  public static final String AVAILABLE = "disponible";
  public static final String DELIVERED = "entregado";
  public static final String PREPARED = "preparado";
  public static final String WAITER_CONFIRMED = "confirmado";
}
