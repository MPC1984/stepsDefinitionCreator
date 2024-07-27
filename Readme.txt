########################################################################################################################
       Welcome to the program which creates the steps definition file of a concrete feature for Olympic Games API                
########################################################################################################################

Please read the following content carefully.

ATTENTION: The only valid characters within the feature file are lowercase letters, uppercase letters, numbers, double quotes and whitespace. Any other type of character used in the feature file will cause
erroneous behavior in this program.

Within the feature file, neither "And" statements, nor "Scenario Outline", nor comments (sentences that begin with the character #) are allowed. Their acceptance will be implemented in subsequent versions.

The feature file must follow the following format:
Feature: ...

  Scenario: ...
    Given ...
    When ...
    Then ...

  Scenario: ...
    Given ...
    When ...
    Then ...

...

Taking into account the following restrictions:

1) In the sentence that begins with the word "Feature", it must be indicated the name of the endpoint to be tested.
   Allowed keywords: "medal table", "olympic games", "sport", "metal" and "athlete".
   Example: Feature: Test athlete endpoint

2) In the sentence that begins with the word "Scenario", it must be indicated the type of method of the request to be tested.
   Allowed keywords: "get", "add", "updat" and "delet".
   Example: Scenario: Getting athletes by athlete country 

3) In the sentence that begins with the word "Scenario", if it is needed to test a request that returns information about an item based on a specific piece of data, it must be indicated the data for which
it is needed to perform this information search.
   Allowed keywords: "all", "olympic games medal table identifier", "olympic games medal table olympic games identifier", "olympic games medal table olympic games year", "olympic games medal table olympic
   games place", "olympic games medal table sport identifier", "olympic games medal table sport name", "olympic games medal table sport category", "olympic games medal table metal identifier", "olympic games
   medal table metal type", "olympic games medal table athlete identifier", "olympic games medal table athlete name", "olympic games medal table athlete surname", "olympic games medal table athlete country",
   "olympic games identifier", "olympic games year", "olympic games place", "sport identifier", "sport name", "sport category", "metal identifier", "metal type", "athlete identifier", "athlete name",
   "athlete surname" and "athlete country".
   Example: Scenario: Getting sports by sport name

4) In the sentence that begins with the word "Given", if it is needed to test a request that returns information about item(s) based on a specific piece of data, it must be indicated the data and its value,
separated by blank spaces (if the value is text, it must be delimited by double quotes), for which it is needed to perform this information search.
   Allowed keywords: "all", "olympic games medal table identifier", "olympic games medal table olympic games identifier", "olympic games medal table olympic games year", "olympic games medal table olympic
   games place", "olympic games medal table sport identifier", "olympic games medal table sport name", "olympic games medal table sport category", "olympic games medal table metal identifier", "olympic games
   medal table metal type", "olympic games medal table athlete identifier", "olympic games medal table athlete name", "olympic games medal table athlete surname", "olympic games medal table athlete country",
   "olympic games identifier", "olympic games year", "olympic games place", "sport identifier", "sport name", "sport category", "metal identifier", "metal type", "athlete identifier", "athlete name",
   "athlete surname" and "athlete country".
   Example: Given a concrete sport name "Atletismo"

5) In the sentence that begins with the word "Given", if it is needed to test a request that creates a new item, it must be indicated the data that the new item will have and its value, separated by blank
spaces (if the value is text, it must be delimited by double quotes).
   Allowed keywords: "olympic games medal table olympic games identifier", "olympic games medal table sport identifier", "olympic games medal table metal identifier", "olympic games medal table athlete
   identifier", "olympic games year", "olympic games place", "sport name", "sport category", "metal type", "athlete name", "athlete surname" and "athlete country".
   Example: Given a new record of the Olympic Games medal table with Olympic Games medal table Olympic Games identifier 3 Olympic Games medal table sport identifier 1 Olympic Games medal table metal
   identifier 1 and Olympic Games medal table athlete identifier 13

6) In the sentence that begins with the word "Given", if it is needed to test a request that updates the data of an item or deletes an item, it must be indicated the identifier of the item to be updated or
deleted and its value, separated by blank spaces.
   Allowed keywords: "olympic games medal table identifier", "olympic games identifier", "sport identifier", "metal identifier" and "athlete identifier".
   Example: Given a concrete Olympic Games medal table identifier 11

7) In the sentence that begins with the word "When", if it is needed to test a request that updates the data of an item, it must be indicated the data to be updated and its new value, separated by white
spaces (if the new value is text, it must be delimited by double quotes).
   Allowed keywords: "olympic games medal table olympic games identifier", "olympic games medal table sport identifier", "olympic games medal table metal identifier", "olympic games medal table athlete
   identifier", "olympic games year", "olympic games place", "sport name", "sport category", "metal type", "athlete name", "athlete surname" and "athlete country".
   Example: When we want to update Olympic Games year 2028 and Olympic Games place "Los Ángeles"

8) In the sentence that begins with the word "Then", if it is expected that the request will return an error, the type of that error must be indicated.
   Allowed keywords: "bad request error", "not found error" and "duplicated information error".
   Example: Then a duplicated information error is shown for the Olympic Games