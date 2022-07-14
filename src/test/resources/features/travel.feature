#language: en

Feature: Search plane tickets
  As tourist
  I want to search and buy plane tickets
  To enjoy the holidays vacations

  @vacation
  Scenario Outline: Search flights
    Given that John searches for flights with the following conditions
      | <Origin> | <Destiny> | <DepartureDate> | <ReturnDate> | <Passengers> |
    When John selects the flights
    Then John should see the summary of plane tickets

    Examples:
      | Origin | Destiny | DepartureDate | ReturnDate | Passengers |
      | Bogota | Lima    | 20-08-2022    | 30-08-2022 | 3          |