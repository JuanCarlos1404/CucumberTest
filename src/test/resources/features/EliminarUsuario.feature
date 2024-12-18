Feature: Eliminar un usuario
  Scenario: Eliminar un usuario exitosamente
    Given que la API está disponible
    When elimino el usuario con id 2
    Then la respuesta debe tener un código de estado 204
    And la respuesta no debe contener un cuerpo
