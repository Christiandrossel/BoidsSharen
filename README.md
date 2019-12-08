# BoidsSharen
swarm behavior
#
Eine Belegarbeit
#
Simulation Schwarmverhalten mit OpenGL in Java programmiert
#
In dem Projekt befindet sich ein Singleton Pattern: der Objektmanager
diesen darf es nur einmal geben, deswegen ruft er sich selbst auf.
Außerdem wird durch ein Mechanismus darauf geachtet das diese Klasse nicht mehrmals existiert.
diese Klasse Steuert praktisch die Anzahl der "Boids".
Diese "Boids" hier Schwarmobjekt genannt werden in einer HashMap gespeichert.

Außerdem existiert noch ein Design Pattern, der Adapter:
In der Klasse "BewegtesObjekt" wird ein Objekt "Verhalten" initialisiert.
Dieses Interfaces besitzt eine update Funktion. Mit der Klasse lassen sich unterschiedliche Verhaltesarten Realisieren.
In dem Fall wird das "SchwarmVerhalten" eingebunden.