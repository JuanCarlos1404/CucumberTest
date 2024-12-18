Feature: Actualizar un usuario
  Scenario: Actualizar un usuario exitosamente
    Given que la API está disponible
    When actualizo el usuario con id 2 con los datos "name" como "Ana" y "job" como "Gerente"
    Then la respuesta debe tener un código de estado 200
    And los campos actualizados deben coincidir con los datos enviados
    And la estructura de la respuesta debe coincidir con el esquema JSON esperado