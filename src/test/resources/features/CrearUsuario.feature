Feature: Crear un usuario
  Como usuario de la API
  Quiero verificar que la funcionalidad de creación de usuarios funciona correctamente
  Para asegurar que se genera un usuario con los datos correctos


  Scenario: Crear un usuario exitosamente
    Given que la API está disponible
    When creo un usuario con los datos "name" como "Juan Pérez" y "job" como "Desarrollador"
    Then la respuesta debe tener un código de estado 201
    And la respuesta debe contener los campos "id" y "createdAt"
    And la estructura de la respuesta debe coincidir con el esquema JSON esperado